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

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testGetAllEmployeesNative();
    }

    private void testGetAllEmployeesNative() {
        LOGGER.info("Start - Native Query");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        for (Employee emp : employees) {
            LOGGER.debug("Employee: {}", emp);
        }
        LOGGER.info("End - Native Query");
    }
}
