package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewEmployeeDTO {
    private String first_name;
    private String last_name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private SalaryDTO salaryDTO;
    private ContactDTO contactDTO;
    private Set<ProjectDTO> projectsDTOs;
}
