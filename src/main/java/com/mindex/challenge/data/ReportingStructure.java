package com.mindex.challenge.data;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;
}