package com.sunil.page.paginationPOC;

import com.sunil.page.paginationPOC.dto.APIResponse;
import com.sunil.page.paginationPOC.entity.Product;
import com.sunil.page.paginationPOC.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/products")
public class PaginationPocApplication {

	@Autowired
	private ProductService service;

	@GetMapping
	private APIResponse<List<Product>> getProducts() {
		List<Product> allProducts = service.findAllProducts();
		return new APIResponse<>(allProducts.size(), allProducts);
	}

	@GetMapping("/{field}")
	private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
		List<Product> allProducts = service.findProductsWithSorting(field);
		return new APIResponse<>(allProducts.size(), allProducts);
	}

	@GetMapping("/pagination/{offSet}/{pageSize}")
	private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offSet, @PathVariable int pageSize) {
		Page<Product> productsWithPagination = service.findProductsWithPagination(offSet, pageSize);
		return new APIResponse(productsWithPagination.getSize(), productsWithPagination);
	}

	@GetMapping("/pagination/{offSet}/{pageSize}/{field}")
	public APIResponse<Page<Product>> findByPaginationAndSorting(@PathVariable int offSet, @PathVariable int pageSize, @PathVariable String field) {
		Page<Product> products = service.findByPaginationAndSorting(offSet, pageSize, field);

		return new APIResponse<>(products.getSize(), products);
	}


	public static void main(String[] args) {
		SpringApplication.run(PaginationPocApplication.class, args);
	}
}
