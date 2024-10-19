package com.project.health_diary.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DietPlan")
public class DietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planId;

    @Column(name = "namePlan", nullable = false)
    private String namePlan;

    @Column(name = "typePlan") // Loại kế hoạch ăn uống
    private String typePlan;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    // Quan hệ Many-to-One giữa DietPlan và User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    // Quan hệ One-to-Many giữa DietPlan và Food
    @OneToMany(mappedBy = "dietPlan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Food> foodList = new ArrayList<>();

    // Constructor không tham số
    public DietPlan() {}

    // Constructor có tham số
    public DietPlan(int planId, String namePlan, String typePlan, Date startDate, Date endDate, User user) {
        this.planId = planId;
        this.namePlan = namePlan;
        this.typePlan = typePlan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }

    // Getter và Setter cho các thuộc tính
    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getNamePlan() {
        return namePlan;
    }

    public void setNamePlan(String namePlan) {
        this.namePlan = namePlan;
    }

    public String getTypePlan() {
        return typePlan;
    }

    public void setTypePlan(String typePlan) {
        this.typePlan = typePlan;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    // Phương thức thêm Food vào danh sách
    public void addFood(Food food) {
        foodList.add(food);
        food.setDietPlan(this); // Thiết lập quan hệ ngược
    }

    // Phương thức loại bỏ Food khỏi danh sách
    public void removeFood(Food food) {
        foodList.remove(food);
        food.setDietPlan(null); // Gỡ quan hệ
    }
}
