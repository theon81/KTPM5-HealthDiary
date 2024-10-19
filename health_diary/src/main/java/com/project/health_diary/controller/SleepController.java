package com.project.health_diary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class SleepController {
    @PostMapping("/set-reminder")
    @ResponseBody
    public String setRemider(@RequestParam("bedtime") String bedtime,HttpSession session){
        session.setAttribute("bedtime", bedtime);
        return "";
    }
    
    @GetMapping("/get-reminder")
    @ResponseBody
    public String getReminder(HttpSession session) {
        String bedtime = (String) session.getAttribute("bedtime");
        return bedtime != null ? bedtime : "--:--";
    }
}
