package com.project.health_diary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.health_diary.model.DietPlan;

@Repository
public interface DietRepository extends JpaRepository<DietPlan, Long> {
    List<DietPlan> findAll();
}