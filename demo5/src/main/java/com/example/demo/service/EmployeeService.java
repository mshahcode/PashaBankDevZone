package com.example.demo.service;

import com.example.demo.dto.EmployeeAllInfoDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.NewEmployeeDTO;
import com.example.demo.entity.Contact;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.entity.Salary;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    public void addNewEmployeeAllInfo(NewEmployeeDTO newEmployeeDTO){
        Employee employee = employeeMapper.mapNewEmployeeDtoToEmployee(newEmployeeDTO);
        Contact contact = employee.getContact();
        contact.setEmployee(employee);
        Salary salary = employee.getSalary();
        salary.setEmployee(employee);
        employeeRepository.save(employee);
    }
    public Page<EmployeeAllInfoDTO> getEmployeePage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        var allEmployees = this.employeeRepository.findAllBy(pageable);
        return allEmployees.map(this.employeeMapper::mapEmployeetoEmployeeAllInfoDto);
    }

    public EmployeeAllInfoDTO getEmployeeById(Long id){
        Employee employee = this.employeeRepository.findById(id).orElse(null);
        if(employee != null){
            return this.employeeMapper.mapEmployeetoEmployeeAllInfoDto(employee);
        }
        return null;
    }

    public void addEmployee(EmployeeDTO employeeDTO){
        this.employeeRepository.save(this.employeeMapper.mapEmployeeDtoToEmployee(employeeDTO));
    }

    public Employee getByFullName(String fName,String lName){
        return this.employeeRepository.getByFullName(fName,lName);
    }

}
