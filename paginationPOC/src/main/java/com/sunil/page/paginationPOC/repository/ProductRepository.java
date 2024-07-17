package com.sunil.page.paginationPOC.repository;

import com.sunil.page.paginationPOC.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
