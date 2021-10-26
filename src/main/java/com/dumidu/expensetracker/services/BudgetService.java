package com.dumidu.expensetracker.services;



import com.dumidu.expensetracker.models.Budget;
import com.dumidu.expensetracker.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public BigDecimal getBudget() {
        try {
            return budgetRepository.findFirstByOrderByBudgetIdDesc().getBudget();
        }catch(Exception e){
            return BigDecimal.valueOf(-1);
        }
    }

    public String addBudget(Budget budget) {
        try{
            Budget currentBudget = budgetRepository.findFirstByOrderByBudgetIdDesc();
            currentBudget.setBudget(budget.getBudget());
            budgetRepository.save(budget);
        }catch(Exception e){
            budgetRepository.save(budget);
        }
        return "Budget Updated Successfully!!";
    }
}
