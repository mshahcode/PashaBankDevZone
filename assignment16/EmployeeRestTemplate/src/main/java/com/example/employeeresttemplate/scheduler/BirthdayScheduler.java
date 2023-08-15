package com.example.employeeresttemplate.scheduler;

import com.example.employeeresttemplate.entity.Employee;
import com.example.employeeresttemplate.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BirthdayScheduler {

    private final EmployeeRepository employeeRepository;

    @Scheduled(cron = "0 0 0 * * *")
    public void getBirthDayEmployees(){
        LocalDate today = LocalDate.now();
        List<Employee> employees =  this.employeeRepository.getBirthdayEmployees(today);
        for (Employee employee: employees) {
            String congratulationsMessage = "Happy Birthday, " + employee.getFull_name() + "!";
            System.out.println(congratulationsMessage);
        }
    }
}
