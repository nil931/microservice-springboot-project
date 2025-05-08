package com.ProductService.ProductServiceApplication.controller;


import com.ProductService.ProductServiceApplication.dto.ProductRequest;
import com.ProductService.ProductServiceApplication.dto.ProductResponse;
import com.ProductService.ProductServiceApplication.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productApplication")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping("/createProducts")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProducts(@RequestBody ProductRequest productRequest) {

        productService.createProduct(productRequest);
        return "Product stored successfully!";

    }


    @GetMapping("/getAllProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> productList = productService.getAllProducts();
        return productList;
    }
}

