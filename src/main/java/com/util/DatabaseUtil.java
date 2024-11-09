package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/OnlineQuizPlatform"; // Replace with your DB URL
    private static final String DB_USERNAME = "root"; // Replace with your DB username
    private static final String DB_PASSWORD = "root"; // Replace with your DB password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
}

