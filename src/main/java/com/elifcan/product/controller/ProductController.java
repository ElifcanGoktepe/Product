package com.elifcan.product.controller;

import com.elifcan.product.entity.Product;
import com.elifcan.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Adding Spring Annotation
@RequiredArgsConstructor // Adding Constructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.getAll();
        return ResponseEntity.ok().body(productList);
    }

    @PostMapping("/add-product")
    public ResponseEntity<Void> addProduct(String name, String brand, Double price){
        Product product = Product.builder()
                .name(name)
                .brand(brand)
                .price(price)
                .build();
        productService.addProduct(name,brand, price);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/get-all-by-brand")
    public ResponseEntity<List<Product>> getAllProductByBrand(String brand){
        return ResponseEntity.ok(productService.getProductByBrand(brand));
    }
}
