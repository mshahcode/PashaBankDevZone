package com.example.demo.dto;

import com.example.demo.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAllInfoDTO {
    private String first_name;
    private String last_name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private SalaryDTO salaryDTO;
    private ContactDTO contactDTO;
    private Set<ProjectDTO> projectsDTOs;
    private List<ProductDTO> productDTOs;


}
