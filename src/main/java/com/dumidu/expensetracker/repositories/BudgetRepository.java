package com.dumidu.expensetracker.repositories;

import com.dumidu.expensetracker.models.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    Budget findByBudgetId(long id);
    Budget findFirstByOrderByBudgetIdDesc();

}
