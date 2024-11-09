package com.quizresult.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.quizresult.model.QuizResult;
import com.util.DatabaseUtil;

public class QuizResultDAO {

    // Create QuizResult
    public void createQuizResult(QuizResult quizResult) throws SQLException {
        String query = "INSERT INTO QuizResults (user_id, quiz_id, score, passed, completed_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quizResult.getUserId());
            stmt.setInt(2, quizResult.getQuizId());
            stmt.setDouble(3, quizResult.getScore());
            stmt.setBoolean(4, quizResult.isPassed());
            stmt.setTimestamp(5, Timestamp.valueOf(quizResult.getCompletedAt()));
            stmt.executeUpdate();
        }
    }

    // Read QuizResult by ID
    public QuizResult getQuizResultById(int resultId) throws SQLException {
        String query = "SELECT * FROM QuizResults WHERE result_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, resultId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new QuizResult(
                        rs.getInt("result_id"),
                        rs.getInt("user_id"),
                        rs.getInt("quiz_id"),
                        rs.getDouble("score"),
                        rs.getBoolean("passed"),
                        rs.getTimestamp("completed_at").toLocalDateTime()
                    );
                }
            }
        }
        return null;
    }

    // Update QuizResult
    public void updateQuizResult(QuizResult quizResult) throws SQLException {
        String query = "UPDATE QuizResults SET user_id = ?, quiz_id = ?, score = ?, passed = ?, completed_at = ? WHERE result_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quizResult.getUserId());
            stmt.setInt(2, quizResult.getQuizId());
            stmt.setDouble(3, quizResult.getScore());
            stmt.setBoolean(4, quizResult.isPassed());
            stmt.setTimestamp(5, Timestamp.valueOf(quizResult.getCompletedAt()));
            stmt.setInt(6, quizResult.getResultId());
            stmt.executeUpdate();
        }
    }

    // Delete QuizResult
    public void deleteQuizResult(int resultId) throws SQLException {
        String query = "DELETE FROM QuizResults WHERE result_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, resultId);
            stmt.executeUpdate();
        }
    }

    // List all QuizResults for a specific User
    public List<QuizResult> getQuizResultsByUserId(int userId) throws SQLException {
        List<QuizResult> results = new ArrayList<>();
        String query = "SELECT * FROM QuizResults WHERE user_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    results.add(new QuizResult(
                        rs.getInt("result_id"),
                        rs.getInt("user_id"),
                        rs.getInt("quiz_id"),
                        rs.getDouble("score"),
                        rs.getBoolean("passed"),
                        rs.getTimestamp("completed_at").toLocalDateTime()
                    ));
                }
            }
        }
        return results;
    }

    // List all QuizResults for a specific Quiz
    public List<QuizResult> getQuizResultsByQuizId(int quizId) throws SQLException {
        List<QuizResult> results = new ArrayList<>();
        String query = "SELECT * FROM QuizResults WHERE quiz_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quizId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    results.add(new QuizResult(
                        rs.getInt("result_id"),
                        rs.getInt("user_id"),
                        rs.getInt("quiz_id"),
                        rs.getDouble("score"),
                        rs.getBoolean("passed"),
                        rs.getTimestamp("completed_at").toLocalDateTime()
                    ));
                }
            }
        }
        return results;
    }
}
