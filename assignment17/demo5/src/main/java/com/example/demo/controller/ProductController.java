package com.example.demo.controller;


import com.example.demo.dto.NewProductDTO;
import com.example.demo.dto.ProductUpdateDto;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://localhost:8080"; // Replace with your actual base URL

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    void addNewProduct(@RequestBody NewProductDTO newProductDTO) {
//        restTemplate.postForObject(BASE_URL + "/products/add", newProductDTO, Void.class);
        this.productService.addNewProduct(newProductDTO);
    }

    @PutMapping("/update/{product_id}")
    public void updateProduct(@RequestBody ProductUpdateDto productUpdateDto, @PathVariable Long product_id) throws Exception {
        this.productService.updateProduct(productUpdateDto, product_id);
//        restTemplate.exchange(
//                BASE_URL + "/products/update/" + product_id,
//                HttpMethod.PUT,
//                new HttpEntity<>(productUpdateDto),
//                Void.class
//        );
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productService.deleteProduct(id);
//        restTemplate.delete(BASE_URL + "/products/" + id);

    }
}