package com.app.model;

public class SleepReminder {
    private int reminderId;
    private String userId;
    private String time; // Giả sử định dạng HH:MM:SS
    private boolean active;

    // Constructor mặc định
    public SleepReminder() {
        this.active = false; // Mặc định là không hoạt động
    }

    // Constructor có tham số
    public SleepReminder(int reminderId, String userId, String time, boolean active) {
        this.reminderId = reminderId;
        this.userId = userId;
        this.time = time;
        this.active = active;
    }

    // Getter và Setter
    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Phương thức để đặt lời nhắc
    public void setReminder(String time) {
        this.time = time;
        this.active = true;
        System.out.println("Lời nhắc ngủ đã được đặt vào lúc: " + time);
    }

    // Phương thức cập nhật lời nhắc
    public void updateReminder(String newTime) {
        if (active) {
            this.time = newTime;
            System.out.println("Lời nhắc đã được cập nhật thành: " + newTime);
        } else {
            System.out.println("Không thể cập nhật vì lời nhắc chưa được kích hoạt.");
        }
    }

    // Phương thức để tắt lời nhắc
    public void disableReminder() {
        this.active = false;
        System.out.println("Lời nhắc ngủ đã bị tắt.");
    }
}
