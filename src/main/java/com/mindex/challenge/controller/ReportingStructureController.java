package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reportingStructure")
public class ReportingStructureController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ReportingStructure getReportingStructure(@PathVariable String employeeId) {
        Employee employee = employeeService.read(employeeId);
        int numberOfReports = employeeService.calculateNumberOfReports(employee);
        ReportingStructure reportingStructure = new ReportingStructure(employee, numberOfReports);
        return reportingStructure;
    }
}
