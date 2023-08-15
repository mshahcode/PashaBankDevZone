package com.example.demo.service;


import com.example.demo.dto.NewProductDTO;
import com.example.demo.dto.ProductUpdateDto;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public void addNewProduct(NewProductDTO newProductDTO){
        var employee = this.employeeService.getByFullName(newProductDTO.getFirst_name(), newProductDTO.getLast_name());
        if(employee != null){
            Product product = this.productMapper.mapNewProductDtoToProduct(newProductDTO);
            product.setEmployee(employee);
            this.productRepository.save(product);
        }
    }

    public void updateProduct(ProductUpdateDto productUpdateDto, Long product_id) throws Exception {
        var product = this.productRepository.findById(product_id).orElseThrow(() -> new Exception("Employee not found"));
        product.setName(productUpdateDto.getName());
        this.productRepository.save(product);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + id));
        Employee employee = product.getEmployee();
        employee.getProducts().remove(product);
        this.employeeRepository.save(employee);
        this.productRepository.delete(product);

    }


}
