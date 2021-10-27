package com.dumidu.expensetracker.dto;

import com.dumidu.expensetracker.models.Expenses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardCards {
    private List<Expenses> expenses;
    private BigDecimal expenseUsage;
    private BigDecimal totalSpent;
    private String topSpentCat;
    private BigDecimal lastExpense;
    private BigDecimal remainingBudget;
}
