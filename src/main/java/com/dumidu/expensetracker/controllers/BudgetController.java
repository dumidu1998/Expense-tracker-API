package com.dumidu.expensetracker.controllers;

import com.dumidu.expensetracker.models.Budget;
import com.dumidu.expensetracker.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RequestMapping("/budget")
@RestController
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping("")
    public ResponseEntity getBudget(){
        BigDecimal budget = budgetService.getBudget();
            return ResponseEntity.ok().body(budget);
    }

    @PostMapping("")
    public  ResponseEntity setBudget(@RequestBody Budget budget){
        return ResponseEntity.ok().body(budgetService.addBudget(budget));
    }



}
