package com.elifcan.product.repository;

import com.elifcan.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * select * from tblproduct where brand = ?
     */

    List<Product> findAllByBrand(String brand); // Finding Product by Brand

    /**
     * And, Or
     * select * from tblproduct where model = ? or fiyat = ?
     */

    List<Product> findAllByBrandOrPrice(String brand, Double price); // Finding Products by Brand or Price

    /**
     *  select * from tblproduct where model = ? and stock = ?
     */

    List<Product> findAllByPriceAndBrand(Double price, String brand);

    /**
     * select * from tblproduct where price > ?
     */

    List<Product> findAllByPriceGreaterThan(Integer priceAmount);

    /**
     * select * from tblproduct where price <= ?
     */

    List<Product> findAllByPriceLessThanEqual(Double priceAmount);

    /**
     * select * from tblproduct where name like %----%
     */
    List<Product> findAllByNameLike(String statement);

    /**
     * select * from tblrpoduct where UPPER(name) = UPPER?
     */

    List<Product> findAllByNameIgnoreCase(String name);

    /**
     * select * from tblproduct where name like ?+'%'
     * select * from tblproduct where name like '%'+?
     * select * from tblproduct where name like '%'+?+'%'
     */

    List<Product> findAllByNameStartingWith(String statement);
    List<Product> findAllByNameEndingWith(String statement);
    List<Product> findAllByNameContaining(String statement);

}
