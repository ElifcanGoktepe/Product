package com.elifcan.product.service;

import com.elifcan.product.entity.Product;
import com.elifcan.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public void save(Product product) {
        repository.save(product);
    }
    public List<Product> getAllProduct() {
        return repository.findAll();
    }
    public List<Product> getProductByBrand(String brand) {
        return repository.findAllByBrand(brand);
    }

}
