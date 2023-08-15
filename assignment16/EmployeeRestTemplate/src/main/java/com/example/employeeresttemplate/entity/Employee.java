package com.example.employeeresttemplate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String full_name;
    private String company_name;
    private Long company_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate birth_date;


}
