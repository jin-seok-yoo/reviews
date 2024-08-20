package com.example.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class ReviewReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int replyId;

    @Column(length = 2000)
    private String replyContent;

    @Column(updatable = false)
    private java.sql.Timestamp replyCreatedAt;

    private java.sql.Timestamp replyUpdatedAt;

    public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public java.sql.Timestamp getReplyCreatedAt() {
		return replyCreatedAt;
	}

	public void setReplyCreatedAt(java.sql.Timestamp replyCreatedAt) {
		this.replyCreatedAt = replyCreatedAt;
	}

	public java.sql.Timestamp getReplyUpdatedAt() {
		return replyUpdatedAt;
	}

	public void setReplyUpdatedAt(java.sql.Timestamp replyUpdatedAt) {
		this.replyUpdatedAt = replyUpdatedAt;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	@OneToOne
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;
}
