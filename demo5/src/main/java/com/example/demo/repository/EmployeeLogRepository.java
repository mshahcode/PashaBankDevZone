package com.example.demo.repository;

import com.example.demo.logemployee.EmployeeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLogRepository extends JpaRepository<EmployeeLog,Long> {
}
