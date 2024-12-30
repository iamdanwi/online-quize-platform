package com.user.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.user.model.User;
import com.util.DatabaseUtil;

public class UserDAO {

    // Create User
    public void createUser(User user) throws SQLException {
        String query = "INSERT INTO Users (username, password_hash, email, role, created_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPasswordHash());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getRole());
            stmt.setTimestamp(5, Timestamp.valueOf(user.getCreatedAt()));
            stmt.executeUpdate();
        }
    }

    // Read User by ID
    public User getUserById(int userId) throws SQLException {
        String query = "SELECT * FROM Users WHERE user_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password_hash"),
                        rs.getString("email"),
                        rs.getString("role"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                    );
                }
            }
        }
        return null;
    }

    // Update User
    public void updateUser(User user) throws SQLException {
        String query = "UPDATE Users SET username = ?, password_hash = ?, email = ?, role = ? WHERE user_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPasswordHash());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getRole());
            stmt.setInt(5, user.getUserId());
            stmt.executeUpdate();
        }
    }

    // Delete User
    public void deleteUser(int userId) throws SQLException {
        String query = "DELETE FROM Users WHERE user_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        }
    }

    // List all Users
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try (Connection connection = DatabaseUtil.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                users.add(new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("password_hash"),
                    rs.getString("email"),
                    rs.getString("role"),
                    rs.getTimestamp("created_at").toLocalDateTime()
                ));
            }
        }
        return users;
    }

    // Authenticate User (for login)
    public User authenticateUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM Users WHERE email = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedPasswordHash = rs.getString("password_hash");
                    // Assuming you will compare the hashed password in real use case
                    if (storedPasswordHash.equals(password)) {
                        return new User(
                            rs.getInt("user_id"),
                            rs.getString("username"),
                            storedPasswordHash,
                            rs.getString("email"),
                            rs.getString("role"),
                            rs.getTimestamp("created_at").toLocalDateTime()
                        );
                    }
                }
            }
        }
        return null;
    }
}
