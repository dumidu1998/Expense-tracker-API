package com.dumidu.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterDateAndTypeRequest {
    private Date startDate;
    private Date endDate;
    private String type;
}
