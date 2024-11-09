package com.user.model;
import java.time.LocalDateTime;

public class User {

	    private int userId;
	    private String username;
	    private String passwordHash;
	    private String email;
	    private String role;
	    private LocalDateTime createdAt;

	    // Constructors, Getters, and Setters
	    public User() {
	    	super();
	    }

	    public User(int userId, String username, String passwordHash, String email, String role, LocalDateTime createdAt) {
	        this.userId = userId;
	        this.username = username;
	        this.passwordHash = passwordHash;
	        this.email = email;
	        this.role = role;
	        this.createdAt = createdAt;
	    }

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPasswordHash() {
			return passwordHash;
		}

		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", username=" + username + ", passwordHash=" + passwordHash + ", email="
					+ email + ", role=" + role + ", createdAt=" + createdAt + "]";
		}
	    
		
}
