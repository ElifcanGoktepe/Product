package com.elifcan.product.repository;

import com.elifcan.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByBrand(String brand); // Finding Product by Brand
}
