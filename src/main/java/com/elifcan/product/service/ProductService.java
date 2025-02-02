package com.elifcan.product.service;

import com.elifcan.product.entity.Product;
import com.elifcan.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Spring Service Annotation
@RequiredArgsConstructor // Lombok Constructor Annotation
public class ProductService {
    /**
     * Business Logic Layer
     * Service has to manage only its own repository.
     * If the service need to reach the information in another repository
     * other service can be called carefully because they can loop with each other.
     *
     * Add only required methods
     *
     * services do not approve the accuracy of data.
     */

    private final ProductRepository repository;

    public List<Product> getAll() { // Listing All Products
        return repository.findAll();
    }

    public void addProduct(String name, String brand, Double price) { // Adding Products
        repository.save(Product.builder()
                .name(name)
                .brand(brand)
                .price(price)
                .build());
    }

    public List<Product> getProductByBrand(String brand) { // Searching Product by Brand
        return repository.findAllByBrand(brand);
    }
}
