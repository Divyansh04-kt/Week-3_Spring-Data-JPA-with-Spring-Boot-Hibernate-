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
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testGetAllPermanentEmployees();
    }

    public void testGetAllPermanentEmployees() {
        System.out.println("=== Permanent Employees ===");

        List<Employee> employees = employeeService.getAllPermanentEmployees();

        for (Employee e : employees) {
            System.out.println("Employee: " + e.getName());
            System.out.println("Department: " + e.getDepartment().getName());

            System.out.print("Skills: ");
            for (Skill skill : e.getSkillList()) {
                System.out.print(skill.getName() + " ");
            }
            System.out.println();
        }
    }
}
