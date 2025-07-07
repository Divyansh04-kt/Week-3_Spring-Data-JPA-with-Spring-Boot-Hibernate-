package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Employee;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Average salary without filtering by department
    @Query("SELECT AVG(e.salary) FROM Employee e")
    double getAverageSalary();

    // Average salary for a specific department
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    double getAverageSalary(@Param("id") int id);
}
