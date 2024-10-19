package com.project.health_diary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Users") // Đảm bảo tên bảng trong cơ sở dữ liệu là Account (có chữ A viết hoa)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "roles", nullable = false)
    private boolean roles;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    private boolean statusLogin = false;


    // Constructor mặc định
    public User() {
    }

    // Constructor đầy đủ tham số
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

    // Phương thức kiểm tra đăng nhập (logic sẽ do service thực hiện)
    public void login(String username, String password) {
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

    // Phương thức kiểm tra trạng thái đăng nhập
    public boolean isStatusLogin() {
        return statusLogin;
    }

    public void setStatusLogin(boolean statusLogin) {
        this.statusLogin = statusLogin;
    }
}
