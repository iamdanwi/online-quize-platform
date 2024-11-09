package com.question.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.question.model.Question;
import com.util.DatabaseUtil;

public class QuestionDAO {

    // Create Question
    public void createQuestion(Question question) throws SQLException {
        String query = "INSERT INTO Questions (quiz_id, question_text, question_type, created_at) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, question.getQuizId());
            stmt.setString(2, question.getQuestionText());
            stmt.setString(3, question.getQuestionType());
            stmt.setTimestamp(4, Timestamp.valueOf(question.getCreatedAt()));
            stmt.executeUpdate();
        }
    }

    // Read Question by ID
    public Question getQuestionById(int questionId) throws SQLException {
        String query = "SELECT * FROM Questions WHERE question_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, questionId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Question(
                        rs.getInt("question_id"),
                        rs.getInt("quiz_id"),
                        rs.getString("question_text"),
                        rs.getString("question_type"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                    );
                }
            }
        }
        return null;
    }

    // Update Question
    public void updateQuestion(Question question) throws SQLException {
        String query = "UPDATE Questions SET quiz_id = ?, question_text = ?, question_type = ? WHERE question_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, question.getQuizId());
            stmt.setString(2, question.getQuestionText());
            stmt.setString(3, question.getQuestionType());
            stmt.setInt(4, question.getQuestionId());
            stmt.executeUpdate();
        }
    }

    // Delete Question
    public void deleteQuestion(int questionId) throws SQLException {
        String query = "DELETE FROM Questions WHERE question_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, questionId);
            stmt.executeUpdate();
        }
    }

    // List all Questions for a Quiz
    public List<Question> getQuestionsByQuizId(int quizId) throws SQLException {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM Questions WHERE quiz_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, quizId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    questions.add(new Question(
                        rs.getInt("question_id"),
                        rs.getInt("quiz_id"),
                        rs.getString("question_text"),
                        rs.getString("question_type"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                    ));
                }
            }
        }
        return questions;
    }
}
