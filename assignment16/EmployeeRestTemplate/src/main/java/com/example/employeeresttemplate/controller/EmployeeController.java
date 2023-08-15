package com.example.employeeresttemplate.controller;


import com.example.employeeresttemplate.Service.EmployeeService;
import com.example.employeeresttemplate.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final RestTemplate restTemplate = new RestTemplate();

//    private final CompanyClient companyClient;


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(@PathVariable Long id) {
        Employee employee = this.employeeService.getEmployee(id);
        String company_name = getCompanyName(employee.getCompany_id());
        if(!"Company Not Found".equals(company_name)) employee.setCompany_name(company_name);
        this.employeeService.addEmployee(employee);
        return employee;
    }


    private String getCompanyName(Long company_id){
        String url = "http://localhost:8080/companies/" + company_id + "/name";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }else{
            return "Company Not Found";
        }
    }


//    // Feign
//    @GetMapping("/get/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Employee getEmployeeFeign(@PathVariable Long id) {
//        Employee employee = this.employeeService.getEmployee(id);
//        String company_name = companyClient.getCompanyName(employee.getCompany_id());
//        if (!"Company Not Found".equals(company_name)) {
//            employee.setCompany_name(company_name);
//        }
//        this.employeeService.addEmployee(employee);
//        return employee;
//    }
}
