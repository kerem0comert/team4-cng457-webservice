package com.cng457.Project.service;


import com.cng457.Project.entity.Review;
import com.cng457.Project.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantReadWriteLock;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public Review saveReview(Review r) {
        lock.writeLock().lock();
        try {
            return reviewRepository.save(r);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Review getReview(int id) {
        lock.readLock().lock();
        try {
            return reviewRepository.findById(id).orElse(null);
        } finally {
            lock.readLock().unlock();
        }
    }
}