package com.app.model;

import java.util.Date;

public class DietPlan {
    private int planId;
    private String userId;
    private Date startDate;
    private Date endDate;

    public DietPlan() {}

    public DietPlan(int planId, String userId, Date startDate, Date endDate) {
        this.planId = planId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public void addPlan(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        System.out.println("Kế hoạch ăn uống đã được thêm từ: " + startDate + " đến " + endDate);
    }

    public void updatePlan(Date newStartDate, Date newEndDate) {
        this.startDate = newStartDate;
        this.endDate = newEndDate;
        System.out.println("Kế hoạch ăn uống đã được cập nhật từ: " + newStartDate + " đến " + newEndDate);
    }

    public void deletePlan() {
        this.startDate = null;
        this.endDate = null;
        System.out.println("Kế hoạch ăn uống đã bị xóa.");
    }

    public void viewPlan() {
        if (startDate != null && endDate != null) {
            System.out.println("Kế hoạch ăn uống từ: " + startDate + " đến " + endDate);
        } else {
            System.out.println("Không có kế hoạch ăn uống nào.");
        }
    }
}
