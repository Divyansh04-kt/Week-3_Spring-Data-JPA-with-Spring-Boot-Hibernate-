package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.*;
import com.cognizant.orm_learn.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.sql.Date;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testAddEmployee();
        // testGetEmployee();
        // testUpdateEmployee();
    }

    private void testAddEmployee() {
        LOGGER.info("Start");
        Employee emp = new Employee();
        emp.setName("Amit Kumar");
        emp.setSalary(60000);
        emp.setPermanent(true);
        emp.setDateOfBirth(Date.valueOf("1990-01-01"));

        Department dept = departmentService.get(1); 
        emp.setDepartment(dept);

        employeeService.save(emp);
        LOGGER.debug("Saved Employee: {}", emp);
        LOGGER.info("End");
    }

    private void testGetEmployee() {
        LOGGER.info("Start");
        Employee emp = employeeService.get(1);
        LOGGER.debug("Employee: {}", emp);
        LOGGER.debug("Department: {}", emp.getDepartment());
        LOGGER.info("End");
    }

    private void testUpdateEmployee() {
        LOGGER.info("Start");
        Employee emp = employeeService.get(1);
        Department dept = departmentService.get(2); 
        emp.setDepartment(dept);
        employeeService.save(emp);
        LOGGER.debug("Updated Employee: {}", emp);
        LOGGER.info("End");
    }
}
