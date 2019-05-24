package com.uhcl.amazonsellers.serviceImpl;

import com.uhcl.amazonsellers.domain.Product;
import com.uhcl.amazonsellers.repository.ProductRepository;
import com.uhcl.amazonsellers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> listAll(){
        return productRepository.findAll();
    }

    public List<Product> listAllBySeller(Long sellerId){
        return productRepository.findBySellerId(sellerId);
    }

    public List<Product> listAllOOStock(){
        return productRepository.findOOStocks();
    }

    public Product updateProduct(Product product){

        if(product.getProductForecast()!=null&&product.getProductForecast().getLeadTime()!=null){
            Integer newreOrder=product.getProductForecast().getOoStock()-product.getProductForecast().getLeadTime();
            product.getProductForecast().setReorder(newreOrder);
        }
        return productRepository.save(product);
    }
}
