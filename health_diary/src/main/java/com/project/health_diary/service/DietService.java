package com.project.health_diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.health_diary.repository.DietRepository;

@Service
public class DietService {
    @Autowired
    private DietRepository dietplanservice;
}
