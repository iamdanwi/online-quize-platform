package com.option.model;

public class Option {
    private int optionId;
    private int questionId;
    private String optionText;
    private boolean isCorrect;

    // Constructors, Getters, and Setters
    public Option() {
    	super();
    }

    public Option(int optionId, int questionId, String optionText, boolean isCorrect) {
        this.optionId = optionId;
        this.questionId = questionId;
        this.optionText = optionText;
        this.isCorrect = isCorrect;
    }

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", questionId=" + questionId + ", optionText=" + optionText
				+ ", isCorrect=" + isCorrect + "]";
	}

    
    
}

