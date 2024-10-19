package com.project.health_diary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.health_diary.model.DietPlan;
import com.project.health_diary.service.DietService;

import java.util.List;

@RestController
public class DietController {
    @Autowired
    private DietService dietRepo;

    @GetMapping("/api/Dietlist")
    public List<DietPlan> getAllDiet(){
        return dietRepo.getAllDietPlan();
    }

    @PostMapping("/api/AddDiet")
    public ResponseEntity<String> addDiet(@RequestBody DietPlan newDiet){
        dietRepo.addDiet(newDiet);
        return ResponseEntity.ok("Diet Plan added successfully");
    }
}
