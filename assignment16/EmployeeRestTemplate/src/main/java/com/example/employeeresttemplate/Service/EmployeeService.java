package com.example.employeeresttemplate.Service;


import com.example.employeeresttemplate.entity.Employee;
import com.example.employeeresttemplate.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee getEmployee(Long id){
        return this.employeeRepository.findById(id).orElse(null);
    }

    public void addEmployee(Employee employee){
        this.employeeRepository.save(employee);
    }
}
