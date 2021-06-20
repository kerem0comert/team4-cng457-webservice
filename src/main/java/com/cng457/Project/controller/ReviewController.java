package com.cng457.Project.Controller;

import com.cng457.Project.entity.Review;
import com.cng457.Project.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping("/addReview")
    public Review saveReview(@RequestBody Review r) {
        return reviewService.saveReview(r);
    }

    @GetMapping("/getReview/{id}")
    public Review getReview(@PathVariable int id) {
        return reviewService.getReview(id);
    }

}
