package com.example.demo.controller;


import com.example.demo.dto.SalaryDTO;
import com.example.demo.entity.Salary;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/salaries")
public class SalaryController {

    private final EmployeeService employeeService;
    private final SalaryService salaryService;

    @PostMapping("/salary/add")
    @ResponseStatus(HttpStatus.CREATED)
    void addSalary(@RequestBody SalaryDTO salaryDTO, @RequestParam Long employee_id) throws Exception {
        this.salaryService.addSalary(salaryDTO, employee_id);
//                restTemplate.postForObject(BASE_URL + "/salaries/salary/add?employee_id=" + employee_id, salaryDTO, Void.class);
    }

    @GetMapping("/salary")
    @ResponseStatus(HttpStatus.OK)
    List<Salary> getAllSalaries() {
        return this.salaryService.getAllSalaries();
//        ResponseEntity<List<Salary>> response = restTemplate.getForEntity(BASE_URL + "/salaries/salary", List.class);
//        return response.getBody();
    }

    @DeleteMapping("/{id}")
    public void deleteSalary(@PathVariable Long id) throws Exception {
        this.salaryService.deleteSalary(id);
//        // Make a DELETE request to the endpoint /salaries/{id}
//        restTemplate.delete(BASE_URL + "/salaries/" + id);
    }
}