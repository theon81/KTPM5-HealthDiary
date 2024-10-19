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

    

    // Xử lý đăng nhập
    @PostMapping("/signin")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Kiểm tra nếu username hoặc password trống
        boolean isLogin = userService.login(username, password);
        if(isLogin){
            return "redirect:/main";
        }
        return "redirect:/";
    }

    // Hiển thị trang đăng ký
    @GetMapping("/signup")
    public String showRegisterForm(Model model) {
        return "signin"; // Quay lại trang đăng nhập, có thể thêm logic hiển thị form đăng ký
    }

    // Xử lý đăng ký
    @PostMapping("/signup")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam(required = false, defaultValue = "false") boolean roles, Model model) {
        // Kiểm tra nếu username hoặc password trống
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            model.addAttribute("error", "Tên đăng nhập và mật khẩu không được để trống.");
            return "signin"; // Quay lại trang đăng nhập với thông báo lỗi
        }

        // Kiểm tra nếu mật khẩu có ít nhất 8 ký tự
        if (password.length() < 8) {
            model.addAttribute("error", "Mật khẩu phải có ít nhất 8 ký tự.");
            return "signin"; // Quay lại trang đăng nhập với thông báo lỗi
        }

        // Kiểm tra nếu tên đăng nhập đã tồn tại
        if (userService.findByUsername(username) != null) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại.");
            return "signin"; // Quay lại trang đăng nhập với thông báo lỗi
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
