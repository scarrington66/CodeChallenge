package com.mindex.challenge.controller;

import com.mindex.challenge.controller.ReportingStructureController;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReportingStructureControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private ReportingStructureController reportingStructureController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetReportingStructure() {
        // Create a sample employee
        Employee employee = new Employee();
        employee.setEmployeeId("12345");
        employee.setFirstName("John");
        employee.setLastName("Doe");

        // Mock the behavior of the employeeService.read and employeeService.calculateNumberOfReports methods
        when(employeeService.read("12345")).thenReturn(employee);
        when(employeeService.calculateNumberOfReports(employee)).thenReturn(5);

        // Call the controller method
        ReportingStructure reportingStructure = reportingStructureController.getReportingStructure("12345");

        // Verify the response
        assertEquals(employee, reportingStructure.getEmployee());
        assertEquals(5, reportingStructure.getNumberOfReports());
    }
}
