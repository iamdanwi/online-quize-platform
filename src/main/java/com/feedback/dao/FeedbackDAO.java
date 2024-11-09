package com.feedback.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.feedback.model.Feedback;
import com.util.DatabaseUtil;

public class FeedbackDAO {

    // Create Feedback
    public void createFeedback(Feedback feedback) throws SQLException {
        String query = "INSERT INTO Feedback (user_id, quiz_id, feedback_text, created_at) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, feedback.getUserId());
            stmt.setInt(2, feedback.getQuizId());
            stmt.setString(3, feedback.getFeedbackText());
            stmt.setTimestamp(4, Timestamp.valueOf(feedback.getCreatedAt()));
            stmt.executeUpdate();
        }
    }

    // Read Feedback by ID
    public Feedback getFeedbackById(int feedbackId) throws SQLException {
        String query = "SELECT * FROM Feedback WHERE feedback_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, feedbackId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Feedback(
                        rs.getInt("feedback_id"),
                        rs.getInt("user_id"),
                        rs.getInt("quiz_id"),
                        rs.getString("feedback_text"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                    );
                }
            }
        }
        return null;
    }

    // Update Feedback
    public void updateFeedback(Feedback feedback) throws SQLException {
        String query = "UPDATE Feedback SET user_id = ?, quiz_id = ?, feedback_text = ?, created_at = ? WHERE feedback_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, feedback.getUserId());
            stmt.setInt(2, feedback.getQuizId());
            stmt.setString(3, feedback.getFeedbackText());
            stmt.setTimestamp(4, Timestamp.valueOf(feedback.getCreatedAt()));
            stmt.setInt(5, feedback.getFeedbackId());
            stmt.executeUpdate();
        }
    }

    // Delete Feedback
    public void deleteFeedback(int feedbackId) throws SQLException {
        String query = "DELETE FROM Feedback WHERE feedback_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, feedbackId);
            stmt.executeUpdate();
        }
    }

    // List all Feedback for a specific Quiz
    public List<Feedback> getFeedbackByQuizId(int quizId) throws SQLException {
        List<Feedback> feedbackList = new ArrayList<>();
        String query = "SELECT * FROM Feedback WHERE quiz_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quizId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    feedbackList.add(new Feedback(
                        rs.getInt("feedback_id"),
                        rs.getInt("user_id"),
                        rs.getInt("quiz_id"),
                        rs.getString("feedback_text"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                    ));
                }
            }
        }
        return feedbackList;
    }
}
