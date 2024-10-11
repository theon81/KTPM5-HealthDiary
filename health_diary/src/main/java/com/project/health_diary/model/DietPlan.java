package com.project.health_diary.model;



import java.util.ArrayList;

public class DietPlan {
    private int planId;
    private String namePlan;
    private Date startDate;
    private Date endDate;
    private ArrayList<OtherUser> userList;
    private ArrayList<Food> foodList;

    public DietPlan() {}

    public DietPlan(int planId,String namePlan, Date startDate, Date endDate) {
        this.planId = planId;
        this.namePlan = namePlan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userList = new ArrayList<>();
        this.foodList = new ArrayList<>();
    }

    public int getPlanId() {
        return planId;
    }

    public String getNamePlan() {
        return namePlan;
    }
    
    
    public Date getStartDate() {
        return startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }
    
    public String getUserList(){
        String mt =""; 
        for(OtherUser x:userList){
            mt = mt + x.getIF() + "<lc>";
        }
        return mt;
    }

    public String getFoodList() {
        StringBuilder foodData = new StringBuilder();
        for (Food food : foodList) {
            foodData.append(food.getFood()).append("</dp>");
        }
        return foodData.toString();

    }

    

    public void setPlanId(int planId) {
        this.planId = planId;
    }
    
    public void setNamePlan(String namePlan) {
        this.namePlan = namePlan;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void updatePlan(Date newStartDate, Date newEndDate) {
        this.startDate = newStartDate;
        this.endDate = newEndDate;
        System.out.println("Kế hoạch ăn uống đã được cập nhật từ: " + newStartDate + " đến " + newEndDate);
    }

    public String viewPlan() {
        
        return "";
    }

}
