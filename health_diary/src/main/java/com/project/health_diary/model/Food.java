package com.project.health_diary.model;

import java.util.ArrayList;
import java.util.List;

import com.project.health_diary.model.exception.DataException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foodid")
    private Long foodId;
    
    @Column(name = "nameFood", nullable = false)
    private String nameFood;

    @Column(name = "typeFood")
    private String typeFood; // tinh bột, protein,....
    @Column(name = "weightLimit")
    private double weightLimit;// giới hạn định lượng cho 1 tuần

    @ManyToMany(mappedBy = "foodlist", cascade = CascadeType.ALL)
    private List<DietPlan> dietPlans = new ArrayList<>();


    public Food() {}

    public Food(String nameFood, String typeFood, double weightLimit) {
        this.nameFood = nameFood;
        this.typeFood = typeFood;
        this.weightLimit = weightLimit;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }
    public Long getFoodId() {
        return foodId;
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
