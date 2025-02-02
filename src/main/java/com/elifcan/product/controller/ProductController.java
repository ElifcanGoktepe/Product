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

import static com.elifcan.product.config.RestApis.*;

@RestController // Adding Spring Annotation
@RequiredArgsConstructor // Adding Constructor
@RequestMapping(PRODUCT)
public class ProductController {

    /**
     * Basic Task
     * Taking data according to requirements
     * For example :
     * -- UserName -> notNull, min 8 - max 64 character
     * -- Email -> data should be email format
     * these kind of checking should be in control and all wrong requests are rejected.
     * ----------
     * Rewriting codes is very important steps because of the changing on codes, all related
     * systems can be canceled. All relations have to be rewritten
     *
     * To avoid this situation, transferring between client and server should be checked.
     *
     * DTO ( Data Transfer Object )
     * --- Request
     * --- Response
     * ------- provides adding and removing data without any change at current code
     * ------- used to performance improvement and security
     * ------- used to notify the front-end side and forward fail message and  failed
     * codes
     */

    private final ProductService productService;

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.getAll();
        return ResponseEntity.ok().body(productList);
    }

    @PostMapping(ADD_PRODUCT)
    public ResponseEntity<Void> addProduct(String name, String brand, Double price){
        Product product = Product.builder()
                .name(name)
                .brand(brand)
                .price(price)
                .build();
        productService.addProduct(name,brand, price);
        return ResponseEntity.ok().build();
    }


    @GetMapping(GET_ALL_BY_BRAND)
    public ResponseEntity<List<Product>> getAllProductByBrand(String brand){
        return ResponseEntity.ok(productService.getProductByBrand(brand));
    }
}
