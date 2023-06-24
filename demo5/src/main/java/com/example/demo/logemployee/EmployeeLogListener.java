package com.example.demo.logemployee;

import com.example.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EmployeeLogListener {

    @PersistenceContext
    private EntityManager entityManager;

    @PostPersist
    @PostUpdate
    @PostRemove
    @Transactional
    public void logEmployeeChanges(Employee employee) {
        EmployeeLog employeeLog = new EmployeeLog();
        employeeLog.setLogMessage("Change on employee with ID: " + employee.getId());

        entityManager.persist(employeeLog);
    }
}
