package com.dumidu.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterDateOnlyRequest {
    private Date startDate;
    private Date endDate;
}
