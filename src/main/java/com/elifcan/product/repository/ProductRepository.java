package com.elifcan.product.repository;

import com.elifcan.product.view.ViewProduct;
import com.elifcan.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
     */

    List<Product> findAllByNameStartingWith(String statement);

    /**
     * select * from tblproduct where name like '%'+?
     */

    List<Product> findAllByNameEndingWith(String statement);

    /**
     * select * from tblproduct where name like '%'+?+'%'
     */

    List<Product> findAllByNameContaining(String statement);

    /**
     * select * from tblproduct order by column asc
     */

    List<Product> findAllByOrderByPriceAsc();

    /**
    * select * from tblproduct order by column desc
    */

    List<Product> findAllByOrderByPriceDesc();

    /**
     * select * from tblproduct where model = ? order by price asc
     */

    List<Product> findAllByBrandOrderByIdAsc(String brand);

    /**
     * select * from tblproduct order by price limit 1
     * findAllBy -> bring all
     * findBy -> bring found
     * findTopBy -> bring one
     * findTop5By -> bring five
     */

    Product findTopByOrderByPriceDesc(); // The most expensive product
    List<Product> findTop3ByOrderByPriceAsc(); // The cheapest 3 product

    /**
     * select * from tblproduct where price >= 20 and price <= 100
     */

    List<Product> findAllByPriceBetween(Double lower, Double higher); // be careful! limits are included in query
    List<Product> findAllByBrandAndPriceBetween(String Brand, Double lower, Double higher);

    /**
     * Optional takes a value which is either present or null. Therefore, when writing query,
     * the result which returns one value should be made sure.
     */

//    Optional<Product> findOptionalByUserNameAndPassword (String userName, String password);

    /**
     * isDelete queries the boolean true/false query regarding registration
     */

    List<Product> findAllByIsDelete(Boolean isDelete);
    List<Product> findAllByIsDeleteTrue();
    List<Product> findAllByIsDeleteIsFalse();

    /**
     * Distict -> used to singularization of the specific column
     */

    List<Product> findDistinctByBrand(String brand);

    /**
     * If a column is Date type, Before and After are used to query specific date
     */

//    List<Product> findAllByCreatedDateBefore(Date date);
//    List<Product> findAllByCreatedDateAfter(Date date);

    /**
     * IsNull, IsNotNull are used to query to check whether the field is null or not
     */

    List<Product> findAllByImageIsNull();
    List<Product> findAllByImageIsNotNull();

    /**
     * select * from tblproduct where id in (212,121,12,21,122,221)
     */

    List<Product> findAllByIdIn(List<Long> ids);

    /**
     * Using Query
     *
     * JPQL -> Jakarta Persistance Query Language
     * select p from Product p
     *
     * HQL -> Hibernate Query Language
     * from Product
     *
     * NATIVESQL -> SQL Sorgulaması
     * select * from Product
     *
     * @Query -> defines the underlying query, taking parameters and specifying the return value
     *
     */

    @Query("select p from Product p where p.brand = ?1") // JPQL
    List<Product> helloSpringPleaseBringTheBrandNamedApple(String brandName);

    @Query("select p from Product p where p.price = ?2 and p.brand = ?1")
    List<Product> bringAccordingToBrandAndPrice(String brand, Double price);

    @Query(nativeQuery = true, value = "select * from Product")
    List<Product> bringAllProducts();

    /**
     * Is there any product whose name is xxx ?
     */

    @Query("select COUNT(p)>0 from Product p where p.name = ?1")
    Boolean isThereAnyProductWhoseNameIsXxx(String productName);

    /**
     * View can be used to take data from specific field in table
     *
     * select name, price, image from tblproduct
     */

    @Query("select new com.elifcan.product.view.ViewProduct (p.name, p.price, p.image) from Product p")
    List<ViewProduct> getAllProductsInViewProduct();

}