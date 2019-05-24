package com.uhcl.amazonsellers.serviceImpl;

import com.amazonaws.services.comprehend.model.DetectSentimentResult;
import com.uhcl.amazonsellers.comprehend.Comprehend;
import com.uhcl.amazonsellers.domain.Product;
import com.uhcl.amazonsellers.domain.Review;
import com.uhcl.amazonsellers.repository.ProductRepository;
import com.uhcl.amazonsellers.repository.ReviewRepository;
import com.uhcl.amazonsellers.service.ReviewService;

import antlr.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;


    public List<Review> listAll(){
        return reviewRepository.findAll();
    }


	@Override
	public void updateSentimentScore() {
		List<Review> reviews=reviewRepository.findAll();
		for(Review r:reviews) {
			if(org.springframework.util.StringUtils.isEmpty(r.getSentiment())) {
				
				DetectSentimentResult res=Comprehend.calculateSentiment(r.getReview());
				r.setSentiment(res.getSentiment());
				if(res.getSentimentScore()!=null&& res.getSentimentScore().getNegative()!=null) {
					r.setScore(String.valueOf(res.getSentimentScore().getNegative()));
					System.out.println(r.getScore());
				}
				
				
			}
		}
		
		reviewRepository.saveAll(reviews);
		
	}
}
