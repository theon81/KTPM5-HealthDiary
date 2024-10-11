package com.project.health_diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.health_diary.model.User;
import com.project.health_diary.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String login(Model model) {
        return "signin"; // Trả về trang đăng nhập
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Kiểm tra nếu username hoặc password trống
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            model.addAttribute("error", "Tên đăng nhập và mật khẩu không được để trống.");
            return "signin";
        }

        // Kiểm tra thông tin đăng nhập
        User user = userService.findByUsernameAndPassword(username, password);
        if (user != null) {
            // Điều hướng đến trang chính nếu đăng nhập thành công
            model.addAttribute("username", user.getUsername());
            return "main"; // Trả về trang chính (main.html)
        } else {
            // Thông báo lỗi nếu đăng nhập thất bại
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
            return "signin";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        return "register"; // Trả về trang đăng ký
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam boolean roles, Model model) {
        // Kiểm tra nếu username hoặc password trống
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            model.addAttribute("error", "Tên đăng nhập và mật khẩu không được để trống.");
            return "register";
        }

        // Kiểm tra nếu tên đăng nhập đã tồn tại
        if (userService.findByUsername(username) != null) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại.");
            return "register";
        }

        // Tạo tài khoản mới và lưu vào cơ sở dữ liệu
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRoles(roles);
        userService.save(newUser);
        return "redirect:/"; // Điều hướng về trang đăng nhập sau khi đăng ký thành công
    }
}
