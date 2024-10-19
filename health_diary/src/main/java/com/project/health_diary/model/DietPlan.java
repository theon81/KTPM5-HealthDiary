package com.project.health_diary.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

// import javax.persistence.JoinColumn;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dietplans")
public class DietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planid")
    private long planid; // id cua plan

    @Column(name = "nameplan", nullable = false)
    private String nameplan; // ten cua plan

    @Column(name = "typeplan")
    private String typeplan; // plan danh cho nguoi tap gym,tieu duong, an kieng,...

    @Column(name = "startdate")
    private Date startdate;// ngay bat dau cua plan

    @Column(name = "enddate")
    private Date enddate;// ngay ket thuc 
    
    // khi 1 plan duoc khoi tao va nguoi dung dang ki thi no se luu xem co nhung ai dang ki plan nay
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "User_DietPlans",
        joinColumns = {@JoinColumn(name = "planid")},
        inverseJoinColumns = {@JoinColumn(name = "userid")}
    )
    private List<User> userlist = new ArrayList<>(); 

    // trong 1 plan thi no se co cac loai thuc pham duoc su dung trong plan do
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "Food_DietPlans",
        joinColumns = {@JoinColumn(name = "planid")},
        inverseJoinColumns = {@JoinColumn(name = "foodid")}
    )
    private List<Food> foodlist = new ArrayList<>();

    // Constructor không tham số
    public DietPlan() {}

    public DietPlan(int id, String name, String type, Date start, Date end) {
        this.planid = id;
        this.nameplan = name;
        this.startdate = start;
        this.enddate = end;
    }

    //setter getter plan id
    public void setPlanid(int planid) {
        this.planid = planid;
    }
    public long getPlanid() {
        return planid;
    }

    //setter getter name plan
    public void setNameplan(String nameplan) {
        this.nameplan = nameplan;
    }
    public String getNameplan() {
        return nameplan;
    }

    //setter getter type plan
    public void setTypeplan(String typeplan) {
        this.typeplan = typeplan;
    }
    public String getTypeplan() {
        return typeplan;
    }

    //setter getter start date
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }
    public Date getStartdate() {
        return startdate;
    }

    //setter getter end date
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
    public Date getEnddate() {
        return enddate;
    }

    //setter getter food list
    public void setFoodlist(List<Food> foodlist) {
        this.foodlist = foodlist;
    }
    public List<Food> getFoodlist() {
        return foodlist;
    }

    //setter getter user list
    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }
    public List<User> getUserlist() {
        return userlist;
    }

    // Phương thức thêm Food vào danh sách
    // public void addFood(Food food) {
    //     foodList.add(food);
    //     food.setDietPlan(this); // Thiết lập quan hệ ngược
    // }

    // Phương thức loại bỏ Food khỏi danh sách
    // public void removeFood(Food food) {
    //     foodList.remove(food);
    //     food.setDietPlan(null); // Gỡ quan hệ
    // }
}
