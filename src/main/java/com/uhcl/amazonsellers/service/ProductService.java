package com.uhcl.amazonsellers.service;

import com.uhcl.amazonsellers.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAll();

    List<Product> listAllBySeller(Long sellerId);

    List<Product> listAllOOStock();

    Product updateProduct(Product product);
}
