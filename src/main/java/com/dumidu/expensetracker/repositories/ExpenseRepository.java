package com.dumidu.expensetracker.repositories;

import com.dumidu.expensetracker.models.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expenses, Long> {
    Expenses findByExpenseId(long id);
}
