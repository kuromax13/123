package com.j2core.mrybalkin.week04.ZooEmulator.zoo;

/**
 * Created by mrybalkin on 8/23/16.
 */
public class Worker {
    private String name;
    private int timeToAddFood;

    private static final int MAX_FOOD_CAPACITY_IN_CAFE = 10;
    private static final int MIN_FOOD_CAPACITY_IN_CAGE = 2;

    public Worker(String name, int timeToAddFood) {
        this.name = name;
        this.timeToAddFood = timeToAddFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeToAddFood() {
        return timeToAddFood;
    }

    public void setTimeToAddFood(int timeToAddFood) {
        this.timeToAddFood = timeToAddFood;
    }

    public void workInCage(Cage cage, int hour){
        int food = MAX_FOOD_CAPACITY_IN_CAFE - cage.getFoodCapacity();
        if (hour % getTimeToAddFood() == 0 && !isEnoughFoodInCage(cage)) {
            cage.setFoodCapacity(food);
        }
    }

    public boolean isEnoughFoodInCage(Cage cage){
        return cage.getFoodCapacity() > MIN_FOOD_CAPACITY_IN_CAGE;
    }
}