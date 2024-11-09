package com.quizresult.model;

import java.time.LocalDateTime;

public class QuizResult {
    private int resultId;
    private int userId;
    private int quizId;
    private double score;
    private boolean passed;
    private LocalDateTime completedAt;

    // Constructors, Getters, and Setters
    public QuizResult() {
    	super();
    }

    public QuizResult(int resultId, int userId, int quizId, double score, boolean passed, LocalDateTime completedAt) {
        this.resultId = resultId;
        this.userId = userId;
        this.quizId = quizId;
        this.score = score;
        this.passed = passed;
        this.completedAt = completedAt;
    }

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public LocalDateTime getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(LocalDateTime completedAt) {
		this.completedAt = completedAt;
	}

	@Override
	public String toString() {
		return "QuizResult [resultId=" + resultId + ", userId=" + userId + ", quizId=" + quizId + ", score=" + score
				+ ", passed=" + passed + ", completedAt=" + completedAt + "]";
	}

    
}
