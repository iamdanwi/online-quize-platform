package com.question.model;

import java.time.LocalDateTime;

public class Question {
    private int questionId;
    private int quizId;
    private String questionText;
    private String questionType;
    private LocalDateTime createdAt;

    // Constructors, Getters, and Setters
    public Question() {
    	super();
    }

    public Question(int questionId, int quizId, String questionText, String questionType, LocalDateTime createdAt) {
        this.questionId = questionId;
        this.quizId = quizId;
        this.questionText = questionText;
        this.questionType = questionType;
        this.createdAt = createdAt;
    }

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", quizId=" + quizId + ", questionText=" + questionText
				+ ", questionType=" + questionType + ", createdAt=" + createdAt + "]";
	}

    
}
