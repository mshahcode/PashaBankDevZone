package com.example.companyresttemplate;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public String getCompanyNameById(Long id){
        return this.companyRepository.getCompanyNameById(id);
    }
}
