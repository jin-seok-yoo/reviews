package com.example.controller;

import com.example.model.Review;
import com.example.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviewForm")
    public String reviewForm() {
        return "review_form";
    }

    @PostMapping("/submitReview")
    public String submitReview(@ModelAttribute Review review, @RequestParam MultipartFile image) {
        // 이미지 업로드 처리
        if (!image.isEmpty()) {
            String uploadDir = "src/main/resources/static/images/";
            String fileName = image.getOriginalFilename();
            try {
                image.transferTo(new File(uploadDir + fileName));
                review.setImageUrl("/images/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        reviewService.saveReview(review);
        return "redirect:/reviewList";
    }

    @GetMapping("/reviewList")
    public String reviewList(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "review_list";
    }
    
    @GetMapping("/reviews")
    public String redirectToReviewList() {
        return "redirect:/reviewList";
    }
}
