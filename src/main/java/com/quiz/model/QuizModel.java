package com.quiz.model;

import java.time.LocalDateTime;

public class QuizModel {
    private int quizId;
    private int creatorId;
    private String title;
    private String description;
    private int timeLimit;
    private double passCriteria;
    private LocalDateTime createdAt;

    // Constructors, Getters, and Setters
    public QuizModel() {
    	super();
    }

    public QuizModel(int quizId, int creatorId, String title, String description, int timeLimit, double passCriteria, LocalDateTime createdAt) {
        this.quizId = quizId;
        this.creatorId = creatorId;
        this.title = title;
        this.description = description;
        this.timeLimit = timeLimit;
        this.passCriteria = passCriteria;
        this.createdAt = createdAt;
    }

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public double getPassCriteria() {
		return passCriteria;
	}

	public void setPassCriteria(double passCriteria) {
		this.passCriteria = passCriteria;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "QuizModel [quizId=" + quizId + ", creatorId=" + creatorId + ", title=" + title + ", description="
				+ description + ", timeLimit=" + timeLimit + ", passCriteria=" + passCriteria + ", createdAt="
				+ createdAt + "]";
	}

   
}
