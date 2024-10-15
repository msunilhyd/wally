package com.sunil.microservices.product.service;

import com.sunil.microservices.product.dto.ProductRequest;
import com.sunil.microservices.product.dto.ProductResponse;
import com.sunil.microservices.product.model.Product;
import com.sunil.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .id(productRequest.id())
                .price(productRequest.price())
                .description(productRequest.description())
                .build();
        Product savedProduct = productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponse(savedProduct.getId(), savedProduct.getName(), savedProduct.getDescription(), savedProduct.getPrice());
    }

    public List<ProductResponse> findAll() {
        return productRepository
                .findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
