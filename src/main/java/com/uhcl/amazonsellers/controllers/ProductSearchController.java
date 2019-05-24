package com.uhcl.amazonsellers.controllers;
import com.uhcl.amazonsellers.domain.Product;
import com.uhcl.amazonsellers.service.ProductService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/SearchProduct")
@CrossOrigin
public class ProductSearchController {




    @Autowired
    private ProductService productService;
    @GetMapping(path = "/list")
    public @ResponseBody List<Product> listProducts(){
        return productService.listAll();
    }


}
