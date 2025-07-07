package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;


@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;

    @Autowired
    private EmployeeService autowiredEmployeeService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);

        // Run test methods here
        testGetAverageSalary();
        testGetAverageSalaryByDept();
    }

    @Override
    public void run(String... args) {
        // Optional, if needed for running on application start.
    }

    private static void testGetAverageSalary() {
        LOGGER.info("Start - Average Salary of All Employees");
        double avgSalary = employeeService.getAverageSalary();
        LOGGER.debug("Average Salary: {}", avgSalary);
        LOGGER.info("End");
    }

    private static void testGetAverageSalaryByDept() {
        LOGGER.info("Start - Average Salary by Department ID");
        int departmentId = 1; // Change this as needed
        double avgSalary = employeeService.getAverageSalaryByDept(departmentId);
        LOGGER.debug("Average Salary in Department {}: {}", departmentId, avgSalary);
        LOGGER.info("End");
    }
}
