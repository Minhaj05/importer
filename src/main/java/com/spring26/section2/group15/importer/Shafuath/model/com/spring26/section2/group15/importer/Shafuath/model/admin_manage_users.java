package com.spring26.section2.group15.importer.Shafuath.model.com.spring26.section2.group15.importer.Shafuath.model;

public class User {

    private String username;
    private String email;
    private String role;

    // Constructor
    public User(String username, String email, String role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }

    // Getters
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    // Setters
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return username + " (" + role + ")";
    }
}