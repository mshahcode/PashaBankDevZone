package com.example.demo.mapper;

import com.example.demo.dto.SalaryDTO;
import com.example.demo.entity.Salary;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface SalaryMapper {
    SalaryMapper INSTANCE = Mappers.getMapper(SalaryMapper.class);

    @Named("salaryToDto")

    SalaryDTO mapSalaryToSalaryDto(Salary salary);

    @Named("DtoToSalary")
    Salary mapSalaryDtoToSalary(SalaryDTO salaryDTO);

}
