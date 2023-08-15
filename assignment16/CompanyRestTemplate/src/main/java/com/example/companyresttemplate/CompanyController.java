package com.example.companyresttemplate;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/{id}/name")
    @ResponseStatus(HttpStatus.OK)
    public String addEmployee(@PathVariable Long id) {
        return this.companyService.getCompanyNameById(id);
    }
}
