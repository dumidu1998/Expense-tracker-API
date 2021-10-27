package com.dumidu.expensetracker.repositories;

import com.dumidu.expensetracker.models.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expenses, Long> {
    Expenses findByExpenseId(long id);
    List<Expenses> findAllByDateBetween(LocalDate d1, LocalDate d2);
    List<Expenses> findAllByOrderByDateDesc();;
    List<Expenses> findAllByDateBetweenAndExpenseType(LocalDate d1, LocalDate d2, String type);
    @Query(value = "select SUM(e.amount) from Expenses e where month(e.date) = month(current_date)")
    BigDecimal getSumOfCurrentMonth();
    List<Expenses> findTop5ByOrderByDateDesc();
    Expenses findFirstByOrderByDateDesc();
    @Query("from Expenses e where month(e.date) = month(current_date) GROUP BY e.expenseType ORDER BY e.amount DESC")
    List<Expenses> getTopCat();
    List<Expenses> findAllByExpenseTypeIsOrderByDateDesc(String type);

    @Query(value="select SUM(e.amount) from Expenses e where e.date = ?1", nativeQuery=true)
    BigDecimal getSumOfADay(LocalDate d);

    @Query(value="select SUM(e.amount) from Expenses e where month(e.date) = month(current_date) and e.expenseType=?1")
    BigDecimal getSumByCat(String cat);
}
