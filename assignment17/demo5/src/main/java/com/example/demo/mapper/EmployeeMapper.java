package com.example.demo.mapper;

import com.example.demo.dto.*;
import com.example.demo.entity.Contact;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.entity.Salary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {SalaryMapper.class, ProductMapper.class})
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    Employee mapEmployeeDtoToEmployee(EmployeeDTO employeeDTO);

    @Mapping(target = "salaryDTO", source = "salary", qualifiedByName = "salaryToDto")
    @Mapping(target = "contactDTO", source = "contact")
    @Mapping(target = "projectsDTOs", source = "projects")
    @Mapping(target = "productDTOs", source = "products")
    EmployeeAllInfoDTO mapEmployeetoEmployeeAllInfoDto(Employee employee);

    SalaryDTO mapSalaryToSalaryDto(Salary salary);

//    Salary mapSalaryDtoToSalary(SalaryDTO salaryDTO);

    ContactDTO mapContactToContactDto(Contact contact);

    Contact mapContactDtoToContact(ContactDTO contactDTO);

    @Mapping(target = "salary", source = "salaryDTO", qualifiedByName = "DtoToSalary")
    @Mapping(target = "contact", source = "contactDTO")
    @Mapping(target = "projects", source = "projectsDTOs")
    Employee mapNewEmployeeDtoToEmployee(NewEmployeeDTO newEmployeeDTO);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    Project mapProjectDtoToProject(ProjectDTO projectDTO);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    ProjectDTO mapProjectToProjectDto(Project project);

}
