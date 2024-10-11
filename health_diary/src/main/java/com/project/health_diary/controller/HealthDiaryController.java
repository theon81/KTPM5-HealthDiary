package com.project.health_diary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthDiaryController {
    // Hiển thị trang đăng nhập
    @GetMapping("/")
    public String login(Model model) {
        return "signin"; // Trả về trang đăng nhập
    }

    @GetMapping("/home")
    public String homePage(){
        return "main";
    }
    
    @GetMapping("/userinfo")
    public String userInfoPage(){
        return "html/userinfo";
    }
    
    @GetMapping("/sleep")
    public String sleepPage(){
        return "html/sleep";
    }
    
    @GetMapping("/dietplan")
    public String dietPlanPage(){
        return "html/dietplan";
    }
    
    @GetMapping("/water")
    public String waterPage(){
        return "html/waterconsumption";
    }

}
