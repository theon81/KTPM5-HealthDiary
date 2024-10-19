package com.project.health_diary.model;

import com.project.health_diary.model.exception.DataException;

public class Food {
    private String nameFood;
    private String typeFood;
    private double weightLimit;

    public Food() {}

    public Food(String nameFood, String typeFood, double weightLimit) {
        this.nameFood = nameFood;
        this.typeFood = typeFood;
        this.weightLimit = weightLimit;
    }

    public String getNameFood() {
        return nameFood;
    }

    public String getTypeFood() {
        return typeFood;
    }

    public double getWeightLimit() {
        return weightLimit;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public void setTypeFood(String typeFood) {
        this.typeFood = typeFood;
    }

    public void setWeightLimit(double weightLimit) throws DataException {
        this.weightLimit = weightLimit;
        if (weightLimit < 0 || weightLimit > 1000){
            throw new DataException();
        }
    }
    
    public String getFood(){
        return (this.getNameFood()+ "</f>" +
                this.getTypeFood() + "</f>" +
                this.getWeightLimit() +"</f>");
    }
    
    
}
