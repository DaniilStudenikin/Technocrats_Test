package ru.itis.technocrats_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.technocrats_test.dto.ProductDto;
import ru.itis.technocrats_test.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "api/product/add")
    public ResponseEntity<ProductDto> addUser(@RequestBody ProductDto product) {
        productService.create(product);
        return ResponseEntity.ok().build();
    }
}
