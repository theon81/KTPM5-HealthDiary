package com.project.health_diary.service;



import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.health_diary.model.DietPlan;
import com.project.health_diary.repository.DietRepository;

@Service
public class DietService {
    @Autowired
    private DietRepository dietplans;

    public ArrayList<DietPlan> getAllDietPlan(){
        List<DietPlan> Plans = dietplans.findAll();
        return new ArrayList<>(Plans);
    }

    public void addDiet(DietPlan newDiet){
        dietplans.save(newDiet);
    }
}
