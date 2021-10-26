package com.dumidu.expensetracker.services;

import com.dumidu.expensetracker.dto.DashboardCards;
import com.dumidu.expensetracker.dto.FilterDateAndTypeRequest;
import com.dumidu.expensetracker.dto.FilterDateOnlyRequest;
import com.dumidu.expensetracker.models.Expenses;
import com.dumidu.expensetracker.repositories.BudgetRepository;
import com.dumidu.expensetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private BudgetRepository budgetRepository;


    public List<Expenses> getAll() {
        return expenseRepository.findAll();
    }

    public String addExpense(Expenses expense) {
        try {
            expenseRepository.save(expense);
            return "New Expense Added Successfully!!";
        }catch(Exception e){
            return "Error Occurred!";
        }
    }

    public Expenses getById(long id) {
        Expenses expense = expenseRepository.findByExpenseId(id);
        return expense;
    }

    public String editExpense(Expenses expense) {
        try {
            Expenses extExpense = expenseRepository.findByExpenseId(expense.getExpenseId());
            if(extExpense!=null){
                expense.setDate(new Date());
                expenseRepository.save(expense);
                return "Expense Updated Successfully!!";
            }else{
                return "Invalid Data";
            }
        }catch(Exception e){
            return "Error Occurred!";
        }
    }

    public String deleteExpense(long id) {
        try {
            Expenses extExpense = expenseRepository.findByExpenseId(id);
            expenseRepository.delete(extExpense);
            return "Deleted Successfully!!";
        }catch(Exception e){
            return "Error Occurred!";
        }
    }

    public List<Expenses> getByDateOnly(FilterDateOnlyRequest dates) {
        return expenseRepository.findAllByDateBetween(dates.getStartDate(),dates.getEndDate());
    }

    public List<Expenses> getByDateAndType(FilterDateAndTypeRequest data) {
        return expenseRepository.findAllByDateBetweenAndExpenseType(data.getStartDate(),data.getEndDate(),data.getType());
    }

    public DashboardCards getCardData() {
        DashboardCards res = new DashboardCards();
        res.setTotalSpent(expenseRepository.getSumOfCurrentMonth());
        res.setExpenseUsage((expenseRepository.getSumOfCurrentMonth().divide(budgetRepository.findFirstByOrderByBudgetIdDesc().getBudget(),2, RoundingMode.CEILING)).multiply(BigDecimal.valueOf(100)));
        res.setExpenses(expenseRepository.findTop5ByOrderByDateDesc());
        res.setLastExpense(expenseRepository.findFirstByOrderByDateDesc().getAmount());
        res.setTopSpentCat(expenseRepository.getTopCat().get(0).getExpenseType());
        return res;
    }
}
