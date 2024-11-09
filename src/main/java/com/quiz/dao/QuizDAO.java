package com.quiz.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.quiz.model.QuizModel;
import com.util.DatabaseUtil;

public class QuizDAO {

    // Create Quiz
    public void createQuiz(QuizModel quiz) throws SQLException {
        String query = "INSERT INTO Quizzes (creator_id, title, description, time_limit, pass_criteria, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quiz.getCreatorId());
            stmt.setString(2, quiz.getTitle());
            stmt.setString(3, quiz.getDescription());
            stmt.setInt(4, quiz.getTimeLimit());
            stmt.setDouble(5, quiz.getPassCriteria());
            stmt.setTimestamp(6, Timestamp.valueOf(quiz.getCreatedAt()));
            stmt.executeUpdate();
        }
    }

    // Read Quiz by ID
    public QuizModel getQuizById(int quizId) throws SQLException {
        String query = "SELECT * FROM Quizzes WHERE quiz_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quizId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new QuizModel(
                        rs.getInt("quiz_id"),
                        rs.getInt("creator_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("time_limit"),
                        rs.getDouble("pass_criteria"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                    );
                }
            }
        }
        return null;
    }

    // Update Quiz
    public void updateQuiz(QuizModel quiz) throws SQLException {
        String query = "UPDATE Quizzes SET creator_id = ?, title = ?, description = ?, time_limit = ?, pass_criteria = ? WHERE quiz_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quiz.getCreatorId());
            stmt.setString(2, quiz.getTitle());
            stmt.setString(3, quiz.getDescription());
            stmt.setInt(4, quiz.getTimeLimit());
            stmt.setDouble(5, quiz.getPassCriteria());
            stmt.setInt(6, quiz.getQuizId());
            stmt.executeUpdate();
        }
    }

    // Delete Quiz
    public void deleteQuiz(int quizId) throws SQLException {
        String query = "DELETE FROM Quizzes WHERE quiz_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quizId);
            stmt.executeUpdate();
        }
    }

    // List all Quizzes
    public List<QuizModel> getAllQuizzes() throws SQLException {
        List<QuizModel> quizzes = new ArrayList<>();
        String query = "SELECT * FROM Quizzes";
        try (Connection connection = DatabaseUtil.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                quizzes.add(new QuizModel(
                    rs.getInt("quiz_id"),
                    rs.getInt("creator_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("time_limit"),
                    rs.getDouble("pass_criteria"),
                    rs.getTimestamp("created_at").toLocalDateTime()
                ));
            }
        }
        return quizzes;
    }
}

