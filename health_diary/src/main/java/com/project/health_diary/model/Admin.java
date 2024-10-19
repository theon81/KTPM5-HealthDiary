package com.project.health_diary.model;

import java.sql.Date;
import java.util.ArrayList;

public class Admin extends User{
    // listPlan để lưu các plan hiển thị cho người dùng 
    private static ArrayList<DietPlan> planList;
    
    private Admin(){}

    public Admin(Long id, boolean roles, String username, String password ){
        super(id, roles, username, password);
        if(planList == null){
            this.planList = new ArrayList<>();
        }
    }

    public void addPlan(String namePlan , Date startDate, Date endDate ){ 
        int planId = planList.size();

        for (int i = 0; i < planId; i++){
            if (planList.get(i) == null) {
                planId = i;
                break;
            }
        }
        DietPlan newPlan = new DietPlan(planId, namePlan, startDate, endDate);
        if (planId < planList.size()) {
            planList.set(planId, newPlan); 
        } else {
            planList.add(newPlan);
        }
        System.out.println("Add plan success ID: " +planId);
    }

    public void removePlan(int planId){
        int x = planList.size();
        for (int i = 0; i < x; i++){
            if (planList.get(i).getPlanId() == planId){
                planList.remove(i);
                System.out.println("Remove success");
                break;
            }
        }
    }

    public String dataPlan() {
        StringBuilder data = new StringBuilder();
        for (DietPlan x : planList) {
            if (x != null) {
                data.append(x.getPlanId()).append("</ad>")
                    .append(x.getNamePlan()).append("</ad>")
                    .append(x.getStartDate()).append("</ad>")
                    .append(x.getEndDate()).append("</ad>");
            }
        }
        return data.toString().trim();
    }
    // đâu ra 0</ad>Kiều thanh tung</ad>01/10/2024</ad>07/10/2024</ad>1</ad>Kiều thanh tung</ad>08/10/2024</ad>14/10/2024</ad>

    
// Kế hoạch 1: ID 0, Người dùng: "admin", Ngày bắt đầu: 01/10/2024, Ngày kết thúc: 07/10/2024
// Kế hoạch 2: ID 1, Người dùng: "admin", Ngày bắt đầu: 08/10/2024, Ngày kết thúc: 14/10/2024
// Kế hoạch 3: ID 2, Người dùng: "admin", Ngày bắt đầu: 15/10/2024, Ngày kết thúc: 21/10/2024
// Kế hoạch 4: ID 3, Người dùng: "admin", Ngày bắt đầu: 22/10/2024, Ngày kết thúc: 28/10/2024

//1 string trả về 0</ad>Kiều thanh tung </ad>01/10/2024"</ad>"07/10/2024 
}
