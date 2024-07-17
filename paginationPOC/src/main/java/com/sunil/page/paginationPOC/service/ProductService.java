package com.sunil.page.paginationPOC.service;

import com.sunil.page.paginationPOC.entity.Product;
import com.sunil.page.paginationPOC.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//    The alternate of init method is postConstruct annotation. At the time of application startup if you want to start any pre processing logic you can use postConstruct

    @PostConstruct
    public void initDB() {
        List<Product> products = IntStream.rangeClosed(1, 200)
                .mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
                .collect(Collectors.toList());
        productRepository.saveAll(products);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findProductsWithSorting(String field) {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Page<Product> findProductsWithPagination(int offSet, int pageSize) {
        Page<Product> products = productRepository.findAll(PageRequest.of(offSet, pageSize));

        return products;
    }

    public Page<Product> findByPaginationAndSorting(int offSet, int pageSize, String field) {
        Page<Product> products = productRepository.findAll(PageRequest.of(offSet, pageSize).withSort(Sort.by(field)));
        return products;
    }
}
