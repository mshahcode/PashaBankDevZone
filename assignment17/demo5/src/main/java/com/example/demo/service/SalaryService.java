package com.example.demo.service;

import com.example.demo.dto.ProductUpdateDto;
import com.example.demo.dto.SalaryDTO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Salary;
import com.example.demo.mapper.SalaryMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SalaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryService {
    private final SalaryRepository salaryRepository;
    private final EmployeeRepository employeeRepository;
    private final SalaryMapper salaryMapper;

    public void addSalary(SalaryDTO salaryDTO,Long employee_id) throws Exception {
        Employee employee = employeeRepository.findById(employee_id).orElseThrow(() -> new Exception("Employee not found"));
        if(employee.getSalary() == null){
            Salary salary = salaryMapper.mapSalaryDtoToSalary(salaryDTO);
            salary.setEmployee(employee);
            employee.setSalary(salary);
            this.employeeRepository.save(employee);
            this.salaryRepository.save(salary);
        }
    }

    public List<Salary> getAllSalaries(){
        return this.salaryRepository.findAll();
    }

   public void deleteSalary(Long id) throws Exception {
        Salary salary = this.salaryRepository.findById(id).orElseThrow(() -> new Exception("Salary not found to be deleted"));
        Employee employee = salary.getEmployee();
        employee.setSalary(null);
        employeeRepository.save(employee);
   }

}
