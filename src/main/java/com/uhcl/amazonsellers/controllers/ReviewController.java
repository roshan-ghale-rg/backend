package com.uhcl.amazonsellers.controllers;

import com.uhcl.amazonsellers.domain.Product;
import com.uhcl.amazonsellers.domain.Review;
import com.uhcl.amazonsellers.service.ProductService;
import com.uhcl.amazonsellers.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public @ResponseBody List<Review> listReviews(){
        return reviewService.listAll();
    }
    
    @GetMapping(value= "/getscore")
    public ResponseEntity<Object> getSentiment(){
    	System.out.print("Inside");
        reviewService.updateSentimentScore();
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}
