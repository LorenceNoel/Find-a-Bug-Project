package com.example.assignment2_group2;

import java.util.List;

public class Question {
    private String codeSnippet;
    private List<String> options;
    private int correctAnswerIndex;
    private boolean answered;
    private int selectedAnswerIndex;
    private int attempts;  // New field to track the number of attempts

    public Question(String codeSnippet, List<String> options, int correctAnswerIndex) {
        this.codeSnippet = codeSnippet;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.answered = false;
        this.selectedAnswerIndex = -1;
        this.attempts = 0; // Initialize attempts to 0
    }

    public String getCodeSnippet() {
        return codeSnippet;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public int getSelectedAnswerIndex() {
        return selectedAnswerIndex;
    }

    public void setSelectedAnswerIndex(int selectedAnswerIndex) {
        this.selectedAnswerIndex = selectedAnswerIndex;
    }

    // New getter for attempts
    public int getAttempts() {
        return attempts;
    }

    // New method to increment attempts
    public void incrementAttempts() {
        this.attempts++;
    }

    // Optionally, a method to reset attempts if needed
    public void resetAttempts() {
        this.attempts = 0;
    }
}
