package com.option.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.option.model.Option;
import com.util.DatabaseUtil;

public class OptionDAO {

    // Create Option
    public void createOption(Option option) throws SQLException {
        String query = "INSERT INTO Options (question_id, option_text, is_correct) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, option.getQuestionId());
            stmt.setString(2, option.getOptionText());
            stmt.setBoolean(3, option.isCorrect());
            stmt.executeUpdate();
        }
    }

    // Read Option by ID
    public Option getOptionById(int optionId) throws SQLException {
        String query = "SELECT * FROM Options WHERE option_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, optionId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Option(
                        rs.getInt("option_id"),
                        rs.getInt("question_id"),
                        rs.getString("option_text"),
                        rs.getBoolean("is_correct")
                    );
                }
            }
        }
        return null;
    }

    // Update Option
    public void updateOption(Option option) throws SQLException {
        String query = "UPDATE Options SET question_id = ?, option_text = ?, is_correct = ? WHERE option_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, option.getQuestionId());
            stmt.setString(2, option.getOptionText());
            stmt.setBoolean(3, option.isCorrect());
            stmt.setInt(4, option.getOptionId());
            stmt.executeUpdate();
        }
    }

    // Delete Option
    public void deleteOption(int optionId) throws SQLException {
        String query = "DELETE FROM Options WHERE option_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, optionId);
            stmt.executeUpdate();
        }
    }

    // List all Options for a Question
    public List<Option> getOptionsByQuestionId(int questionId) throws SQLException {
        List<Option> options = new ArrayList<>();
        String query = "SELECT * FROM Options WHERE question_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, questionId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    options.add(new Option(
                        rs.getInt("option_id"),
                        rs.getInt("question_id"),
                        rs.getString("option_text"),
                        rs.getBoolean("is_correct")
                    ));
                }
            }
        }
        return options;
    }
}
