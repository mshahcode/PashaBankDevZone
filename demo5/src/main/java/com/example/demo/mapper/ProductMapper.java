package com.example.demo.mapper;

import com.example.demo.dto.NewProductDTO;
import com.example.demo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = SalaryMapper.class)

public interface ProductMapper {
    SalaryMapper INSTANCE = Mappers.getMapper(SalaryMapper.class);

    Product mapNewProductDtoToProduct(NewProductDTO newProductDTO);

}
