package com.dumidu.expensetracker.services;

import com.dumidu.expensetracker.dto.FilterDateAndType;
import com.dumidu.expensetracker.dto.FilterDateOnly;
import com.dumidu.expensetracker.models.Expenses;
import com.dumidu.expensetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;


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

    public List<Expenses> getByDateOnly(FilterDateOnly dates) {
        return expenseRepository.findByDateBetween(dates.getStartDate(),dates.getEndDate());
    }

    public List<Expenses> getByDateAndType(FilterDateAndType data) {
        return expenseRepository.findByDateBetweenAndExpenseType(data.getStartDate(),data.getEndDate(),data.getType());
    }
}
