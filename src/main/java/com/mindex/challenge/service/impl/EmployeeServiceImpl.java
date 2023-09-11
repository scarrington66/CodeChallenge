package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);

        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);

        return employeeRepository.save(employee);
    }

    @Override

    public int calculateNumberOfReports(Employee employee) {
        // Start with 0 reports for the current employee
        int numberOfReports = 0;

        // Check if the employee has directReports
        List<Employee> directReports = employee.getDirectReports();
        if (directReports != null && !directReports.isEmpty()) {
            // Loop through each direct report and calculate their reports recursively
            for (Employee directReport : directReports) {
                if (directReport != null) {
                    // Count the direct report
                    numberOfReports++;

                    // Calculate the number of reports for the direct report recursively
                    numberOfReports += calculateNumberOfReports(directReport);
                }
            }
        }
        return numberOfReports;
    }
}
