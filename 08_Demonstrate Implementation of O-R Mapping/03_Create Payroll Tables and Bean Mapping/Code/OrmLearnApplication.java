package com.cognizant.orm_learn;


import com.cognizant.orm_learn.model.*;
import com.cognizant.orm_learn.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;
import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SkillRepository skillRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }
  
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        // 1. Create and save Department
        Department dept = new Department();
        dept.setName("Technology");
        departmentRepository.save(dept);

        // 2. Create and save Skill
        Skill java = new Skill();
        java.setName("Java");
        skillRepository.save(java);

        // 3. Create and save Employee
        Employee emp = new Employee();
        emp.setName("Rahul Sharma");
        emp.setSalary(60000);
        emp.setPermanent(true);
        emp.setDateOfBirth(Date.valueOf("1990-05-15"));
        emp.setDepartment(dept);
        emp.setSkillList(Set.of(java));
        employeeRepository.save(emp); // Hibernate auto-generates ID

        // 4. Fetch and print using ID assigned by Hibernate (not manually set)
        Employee savedEmp = employeeRepository.findById(emp.getId()).orElse(null);
        if (savedEmp != null) {
            System.out.println("Saved Employee: " + savedEmp.getName());
            System.out.println("Department: " + savedEmp.getDepartment().getName());
            savedEmp.getSkillList().forEach(skill -> System.out.println("Skill: " + skill.getName()));
        } else {
            System.out.println("Employee not found.");
        }
    }
}
