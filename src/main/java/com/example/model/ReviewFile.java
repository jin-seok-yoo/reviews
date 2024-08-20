package com.example.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class ReviewFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewfileId;

    private String reviewFilename;
    public int getReviewfileId() {
		return reviewfileId;
	}

	public void setReviewfileId(int reviewfileId) {
		this.reviewfileId = reviewfileId;
	}

	public String getReviewFilename() {
		return reviewFilename;
	}

	public void setReviewFilename(String reviewFilename) {
		this.reviewFilename = reviewFilename;
	}

	public String getReviewFile() {
		return reviewFile;
	}

	public void setReviewFile(String reviewFile) {
		this.reviewFile = reviewFile;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	private String reviewFile;

    @ManyToOne
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;
}
