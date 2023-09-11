package com.mindex.challenge.controller;

import com.mindex.challenge.controller.CompensationController;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CompensationControllerTest {

    @Mock
    private CompensationService compensationService;

    @InjectMocks
    private CompensationController compensationController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCompensation() {
        // Create a sample compensation object
        Compensation compensation = new Compensation();
        compensation.setEmployeeId("12345");
        compensation.setSalary(75000.0);

        // Mock the behavior of the compensationService.create method
        when(compensationService.create(compensation)).thenReturn(compensation);

        // Call the controller method
        Compensation createdCompensation = compensationController.createCompensation(compensation);

        // Verify the response
        assertEquals(compensation, createdCompensation);
    }

    @Test
    public void testRead() {
        // Create a sample compensation object
        Compensation compensation = new Compensation();
        compensation.setEmployeeId("12345");
        compensation.setSalary(75000.0);

        // Mock the behavior of the compensationService.read method
        when(compensationService.read("12345")).thenReturn(compensation);

        // Call the controller method
        Compensation retrievedCompensation = compensationController.read("12345");

        // Verify the response
        assertEquals(compensation, retrievedCompensation);
    }
}
