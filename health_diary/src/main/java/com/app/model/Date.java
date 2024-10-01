package com.app.model;

import com.app.model.exception.DataException;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {}

    public Date(int day, int month, int year) {
        try {
            this.setDay(day);
            this.setMonth(month);
            this.setYear(year);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            this.checkDate();
        } catch(Exception e) {
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
        if (day < 1 || day > 31) {
            this.day = -1;
            throw new DataException();
        } else {
            this.day = day;
        }
    }

    public void setMonth(int month) throws DataException {
        if (month < 1 || month > 12) {
            this.month = -1;
            throw new DataException();
        } else {
            this.month = month;
        }
    }

    public void setYear(int year) throws DataException {
        if (year < 2023) {
            this.year = -1;
            throw new DataException();
        }
        this.year = year;
    }

    public String getDate() {
        boolean isValidDate = true;
        try {
            isValidDate = this.checkDate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (this.getDay() == -1 || this.getMonth() == -1 || this.getYear() == -1 || !isValidDate) {
            return "NULL";
        } 
        return String.format("%02d/%02d/%d", day, month, year);
    }

    public boolean checkDate() throws DataException {
        if (this.getDay() == -1 || this.getMonth() == -1 || this.getYear() == -1) {
            return false;
        }

        switch (this.getMonth()) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if (this.getDay() > 31) return false;
                break;
            case 4: case 6: case 9: case 11:
                if (this.getDay() > 30) return false;
                break;
            case 2:
                if (isLeapYear(this.getYear())) {
                    if (this.getDay() > 29) return false;
                } else {
                    if (this.getDay() > 28) return false;
                }
                break;
            default:
                throw new DataException();
        }
        return true;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Date testDate = new Date(29, 2, 2023);  
        String dateStr = testDate.getDate();
        System.out.println(dateStr);  
    }
}
