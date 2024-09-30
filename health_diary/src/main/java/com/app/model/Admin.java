package com.app.model;

import java.util.ArrayList;

public class Admin extends User{
    private static ArrayList<DietPlan> planList;
    
    private Admin(){}

    public Admin(String ID, String Roles, String Usernam, String Password ){
        super(ID, Roles, Usernam, Password);
        this.planList = new ArrayList<>();
    }

    

}
