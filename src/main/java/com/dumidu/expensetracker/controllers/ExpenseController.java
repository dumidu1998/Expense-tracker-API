package com.dumidu.expensetracker.controllers;

import com.dumidu.expensetracker.dto.FilterDateAndTypeRequest;
import com.dumidu.expensetracker.dto.FilterDateOnlyRequest;
import com.dumidu.expensetracker.models.Expenses;
import com.dumidu.expensetracker.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/expense")
@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("")
    public ResponseEntity getAll(){
        List<Expenses> allExpenses = expenseService.getAll();
        return ResponseEntity.ok().body(allExpenses);
    }

    @PostMapping("")
    public  ResponseEntity addExpense(@RequestBody Expenses expense){
        return ResponseEntity.ok().body(expenseService.addExpense(expense));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") long id){
        Expenses expense = expenseService.getById(id);
        if(expense!= null){
            return ResponseEntity.ok().body(expense);
        }else{
            return ResponseEntity.badRequest().body("Invalid Id");
        }
    }

    @PutMapping("")
    public  ResponseEntity editExpense(@RequestBody Expenses expense){
        return ResponseEntity.ok().body(expenseService.editExpense(expense));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity deleteExpense(@PathVariable("id") long id){
        return ResponseEntity.ok().body(expenseService.deleteExpense(id));
    }

    @PostMapping("/bydaterange")
    public  ResponseEntity getExpenseByDate(@RequestBody FilterDateOnlyRequest dates){
        System.out.println(dates.getStartDate());
        System.out.println(dates.getEndDate());
        return ResponseEntity.ok().body(expenseService.getByDateOnly(dates));
    }

    @PostMapping("/bydatetype")
    public  ResponseEntity getExpenseByDateAndType(@RequestBody FilterDateAndTypeRequest data){
        return ResponseEntity.ok().body(expenseService.getByDateAndType(data));
    }
    @GetMapping("/bytype/{name}")
    public  ResponseEntity getExpenseByDateAndType(@PathVariable("name") String type){
        return ResponseEntity.ok().body(expenseService.getByType(type));
    }

    @GetMapping("/cardsdata")
    public  ResponseEntity getCardData(){
        return ResponseEntity.ok().body(expenseService.getCardData());
    }



}
