package com.feedback.model;

import java.time.LocalDateTime;

public class Feedback {
    private int feedbackId;
    private int userId;
    private int quizId;
    private String feedbackText;
    private LocalDateTime createdAt;

    // Constructors, Getters, and Setters
    public Feedback() {
    	super();
    }

    public Feedback(int feedbackId, int userId, int quizId, String feedbackText, LocalDateTime createdAt) {
        this.feedbackId = feedbackId;
        this.userId = userId;
        this.quizId = quizId;
        this.feedbackText = feedbackText;
        this.createdAt = createdAt;
    }

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", userId=" + userId + ", quizId=" + quizId + ", feedbackText="
				+ feedbackText + ", createdAt=" + createdAt + "]";
	}

    
}
