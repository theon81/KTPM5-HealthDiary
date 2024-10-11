package com.project.health_diary.model;


import java.util.Date;

public class WaterConsumption {
    private int waterId;
    private String userId;
    private Date date;
    private double amount; // Lượng nước uống được tính bằng lít

    // Constructor mặc định
    public WaterConsumption() {
    }

    // Constructor có tham số
    public WaterConsumption(int waterId, String userId, Date date, double amount) {
        this.waterId = waterId;
        this.userId = userId;
        this.date = date;
        this.amount = amount;
    }

    // Getter và Setter
    public int getWaterId() {
        return waterId;
    }

    public void setWaterId(int waterId) {
        this.waterId = waterId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Phương thức để thêm tiến trình nước uống
    public void addWaterProgress(double amount) {
        this.amount += amount;
        System.out.println("Bạn đã uống thêm: " + amount + " lít nước. Tổng cộng: " + this.amount + " lít.");
    }

    // Phương thức để cập nhật tiến trình nước uống
    public void updateWaterEntry(double newAmount) {
        this.amount = newAmount;
        System.out.println("Lượng nước đã được cập nhật thành: " + newAmount + " lít.");
    }
}
