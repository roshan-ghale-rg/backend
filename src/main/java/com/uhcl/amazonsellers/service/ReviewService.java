package com.uhcl.amazonsellers.service;

import com.uhcl.amazonsellers.domain.Review;

import java.util.List;

public interface ReviewService {

    List<Review> listAll();
    
    void updateSentimentScore();
}
