package com.uhcl.amazonsellers.repository;

import com.uhcl.amazonsellers.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long>,ProductRepositoryCustom{
    @Query("Select distinct p.asin from Product p")
    List<String> findDistinctASIN();

    List<Product> findBySellerId(Long sellerId);

    @Query("Select p from Product p where p.productForecast.reorder<=p.productForecast.leadTime")
    List<Product> findOOStocks();

}
