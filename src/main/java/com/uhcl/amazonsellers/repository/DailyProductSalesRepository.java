package com.uhcl.amazonsellers.repository;

import com.uhcl.amazonsellers.domain.DailyProductSales;
import com.uhcl.amazonsellers.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyProductSalesRepository extends JpaRepository<DailyProductSales, Long>{

    List<DailyProductSales> findByProductId(Long productId);
}

