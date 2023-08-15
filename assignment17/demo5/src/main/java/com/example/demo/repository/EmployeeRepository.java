package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findAllBy(Pageable pageable);

    @Query(value = "SELECT e FROM Employee e WHERE MONTH(e.birthDate) = MONTH(:currentDate) AND DAY(e.birthDate) = DAY(:currentDate)")
    List<Employee> getBirthdayEmployees(@Param("currentDate") LocalDate currentDate);

    @Query(value = "SELECT e FROM Employee e WHERE e.first_name = :fName AND e.last_name = :lName")
    Employee getByFullName(@Param("fName")String fName,@Param("lName") String lName);

}