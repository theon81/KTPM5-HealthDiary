package model;

public class User {
    private String id;
    private String roles;
    private String username;
    private String password;

    public User(String id, String roles, String username, String password) {
        this.id = id;
        this.roles = roles;
        this.username = username;
        this.password = password;
    }

    public void login() {
        // Logic for user login
    }

    public void logOut() {
        // Logic for user logout
    }

    public void viewProfile() {
        // Logic to view user profile
    }

    // Getters and Setters
}
