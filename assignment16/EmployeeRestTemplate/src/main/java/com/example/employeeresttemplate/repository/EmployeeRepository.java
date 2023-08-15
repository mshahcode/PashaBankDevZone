package com.example.employeeresttemplate.repository;

import com.example.employeeresttemplate.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "SELECT e FROM Employee e WHERE EXTRACT(MONTH FROM CAST(e.birth_date AS DATE)) = EXTRACT(MONTH FROM CAST(:currentDate AS DATE)) AND EXTRACT(DAY FROM CAST(e.birth_date AS DATE)) = EXTRACT(DAY FROM CAST(:currentDate AS DATE))")
    List<Employee> getBirthdayEmployees(@Param("currentDate") LocalDate currentDate);

}
