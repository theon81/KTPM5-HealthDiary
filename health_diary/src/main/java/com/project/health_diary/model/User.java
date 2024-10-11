package com.project.health_diary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Roles")
    private boolean roles;

    @Column(name = "Username", nullable = false, unique = true)
    private String username;

    @Column(name = "Password", nullable = false)
    private String password;

    @Transient
    private boolean statusLogin = false;

    public User() {
    }

    public User(Long id, boolean roles, String username, String password) {
        this.id = id;
        this.roles = roles;
        this.username = username;
        this.password = password;
    }

    // Getters và setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isRoles() {
        return roles;
    }

    public void setRoles(boolean roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Phương thức đăng nhập
    public void login(String username, String password) {
        // Logic đăng nhập sẽ cần sử dụng EntityManager để tìm kiếm trong CSDL
        // Đoạn code này chỉ là mô phỏng
        if (this.username.equals(username) && this.password.equals(password)) {
            statusLogin = true;
            System.out.println("Đăng nhập thành công");
        } else {
            System.out.println("Thông tin đăng nhập không chính xác!");
        }
    }

    // Phương thức đăng xuất
    public void logout() {
        if (statusLogin) {
            statusLogin = false;
            System.out.println("Bạn đã đăng xuất");
        } else {
            System.out.println("Bạn chưa đăng nhập!");
        }
    }

    // Phương thức xem thông tin cá nhân
    public String viewProfile() {
        if (statusLogin) {
            return "ID: " + this.getId() + " | Username: " + this.getUsername() + " | Roles: " + (this.isRoles() ? "Admin" : "User");
        }
        System.out.println("Bạn chưa đăng nhập!");
        return "";
    }

    public static void main(String[] args) {
        User user = new User(1L, true, "admin", "password123");

        System.out.println("---- Kiểm tra đăng nhập thành công ----");
        user.login("admin", "password123");
        System.out.println(user.viewProfile());

        System.out.println("---- Kiểm tra đăng nhập thất bại ----");
        user.login("admin", "wrongpass");

        System.out.println("---- Kiểm tra đăng xuất ----");
        user.logout();
    }
}
