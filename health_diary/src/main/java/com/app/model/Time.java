package com.app.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.app.model.exception.DataException;
import com.app.model.exception.TimeException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
    }

    public Time(int hour, int minute, int second) {
        try {
            this.setHour(hour);
            this.setMinute(minute);
            this.setSecond(second);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) throws DataException {
        if((hour < 0) || (hour > 23)){
            this.hour = -1;
            throw new DataException();
        } else {
            this.hour = hour;
        }
    }

    public void setMinute(int minute) throws DataException {
        if((minute < 0) || (minute > 59)){
            this.minute = -1;
            throw new DataException();
        } else {
            this.minute = minute;
        }
    }

    public void setSecond(int second) throws DataException {
        if ((second < 0) || (second) > 59){
            this.second = -1;
            throw new DataException();
        } else{
            this.second = second;
        }
    }

    public void changeTime(){
        int Second = this.getSecond();
        if (this.getSecond() == 59){   
            int Minute = this.getMinute();
            if(this.getMinute() == 59){
                int Hour = this.getHour();
                if(this.getHour() == 23){
                    Hour = 0;
                    Minute = 0;
                    Second = 0;
                    try {
                        this.setHour(Hour);
                        this.setMinute(Minute);
                        this.setSecond(Second);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else{
                    Minute = 0;
                    Second = 0;
                    Hour++;
                    try {
                        this.setHour(Hour);
                        this.setMinute(Minute);
                        this.setSecond(Second);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                Second = 00;
                try {
                    Minute++;
                    this.setSecond(Second);
                    this.setMinute(Minute);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            try {
                this.setSecond(Second);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                Second++;
                this.setSecond(Second);  
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    } 

    public String getTime(){
        String Time;
        if ((this.getHour() == -1 )|| (this.getMinute() == -1) || (this.getSecond() == -1)) {
            return  "NaN:NaN:NaN";
        } 
        return String.format("%02d:%02d:%02d", hour,minute,second);
    }

    public String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime now = LocalTime.now();
        String Time = now.format(formatter);
        return Time;
    }
    
    public void startClock(Time inputTime) {
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), event -> {
                String currentTime = getCurrentTime();
                System.out.println("Giờ hiện tại: " + currentTime);
                try {
                    compareInputWithCurrentTime(inputTime);
                } catch (TimeException e) {
                    System.out.println("Lỗi: " + e.getMessage());
                }
            })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void compareInputWithCurrentTime(Time inputTime) throws TimeException {
        String currentTime = getCurrentTime(); // Lấy thời gian hiện tại
        String inputTimeString = inputTime.getTime(); // Lấy thời gian nhập vào

        if (currentTime.equals(inputTimeString)) {
            throw new TimeException();
        }
    }

    public static void main(String[] args) {
        Time testTime = new Time(10,51,00);
        String mt;
        mt = testTime.getTime();
        System.out.println(mt);
        // System.out.println(mt);
        // testTime.changeTime();
        // mt = testTime.getTime();
        // System.out.println(mt);
        Time test = new Time();
        System.out.println(test.getCurrentTime());
    }
}
