package com.dumidu.expensetracker.repositories;

import com.dumidu.expensetracker.models.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expenses, Long> {
    Expenses findByExpenseId(long id);
    List<Expenses> findByDateBetween(Date d1, Date d2);
    List<Expenses> findByDateBetweenAndExpenseType(Date d1, Date d2,String type);
}
