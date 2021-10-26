package com.dumidu.expensetracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Budget {

    @Id
    @GeneratedValue
    private long budgetId;

    @Column(nullable = false, precision = 10,scale = 2)
    private BigDecimal budget;

}
