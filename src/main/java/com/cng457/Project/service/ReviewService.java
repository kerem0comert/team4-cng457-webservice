package com.cng457.Project.service;


import com.cng457.Project.entity.Review;
import com.cng457.Project.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public Review saveReview(Review r){
        return reviewRepository.save(r);
    }

    public Review getReview(int id){
        return reviewRepository.findById(id).orElse(null);
    }



}