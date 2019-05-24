package com.uhcl.amazonsellers.service;

import com.uhcl.amazonsellers.domain.DailyProductSales;

import java.util.List;

public interface DailyProductSalesService {

    List<DailyProductSales> getAll();

    List<DailyProductSales> getAllByProductId(Long productId);
}
