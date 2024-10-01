package com.app.model;

import java.util.ArrayList;

import javafx.scene.chart.PieChart;

public class Admin extends User{
    private static ArrayList<DietPlan> planList;
    
    private Admin(){}

    public Admin(String ID, String Roles, String Usernam, String Password ){
        super(ID, Roles, Usernam, Password);
        if(planList == null){
            this.planList = new ArrayList<>();
        }
    }

    public void addPlan(int planId, String namePlab , Date startDate, Date endDate ){
        int planId = planList.size();
        DietPlan newPlan = new DietPlan(planId, namePlab ,startDate, endDate);
        planList.add(newPlan);
        
    }

    public void removePlan(int planId){
        for (int i = 0; i <planList.size(); i++){
            if (planList.get(i).getPlanId() == planId){
                planList.remove(i);
                for (int j = i; j < planList.size(); j++){
                    planList.get(j).setPlanId(j +1);
                }
                System.out.println("Remove success");
                break;
            }
        }
    }

    public String dataPlan(){
        StringBuilder data = new StringBuilder();
        for (DietPlan x : planList) {
            data.append("ID: ")
                .append("User: ")
                .append(getUsername())
                .append("Start: ").append(x.getStartDate())
                .append("End: ").append(x.getEndDate());
        }
        return data.toString();
    }


}
