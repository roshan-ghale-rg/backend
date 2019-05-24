package com.uhcl.amazonsellers.controllers;

import com.uhcl.amazonsellers.domain.Product;
import com.uhcl.amazonsellers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public @ResponseBody List<Product> listProducts(){
        return productService.listAll();
    }

    @GetMapping(value = "{sellerId}")
    public @ResponseBody List<Product> listProductsBySeller(@PathVariable("sellerId") Long sellerId){
        return productService.listAllBySeller(sellerId);
    }


    @PutMapping(value = "/update")
    public ResponseEntity<Object> listProductsBySeller(@RequestBody Product product){
        Product res=productService.updateProduct(product);
        if(res==null)
            return new ResponseEntity<>(false, HttpStatus.OK);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
