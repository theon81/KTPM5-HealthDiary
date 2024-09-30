package com.app.model;

import com.app.model.exception.DataException;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public Date(int day, int month, int year) {
        try {
            this.setDay(day);
            this.setMonth(month);
            this.setYear(year);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) throws DataException {
        if ((day < 0) || (day > 31)){
            this.day = -1;
            throw new DataException();
        } else{
            this.day = day;
        }
    }

    public void setMonth(int month) throws DataException {
        if ((month < 0) || (month > 12)){
            this.month = -1;
            throw new DataException();
        } else {
            this.month = month;
        }
    }

    public void setYear(int year) throws DataException {
        if ((year < 2023)){
            this.year = -1;
            throw new DataException();
        }
        this.year = year;
    }
    
    public String getDate(){
        String Date;
        if((this.getDay() == -1) || (this.getMonth() == -1) || this.getYear() == -1){
            Date = "NULL/NULL/NULL";
            return Date;
        } else {
            Date = this.getDay() + "/" + this.getMonth() + "/" + this.getYear();
        }
        return Date;
    }
}
