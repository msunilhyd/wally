package com.sunil.ms.product.controller;

import com.sunil.ms.product.dto.ProductRequest;
import com.sunil.ms.product.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequest productRequest) {

        return productService.createProduct(productRequest);
    }
}
