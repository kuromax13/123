package com.j2core.mrybalkin.week04.ZooEmulator.zoo;

/**
 * Created by mrybalkin on 8/23/16.
 *
 * Describes worker
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

    /**
     * Adds food to the cage if it is time and it is needed
     *
     * @param cage - with which cage need to work
     * @param hour - counter for work
     */
    public void workInCage(Cage cage, int hour){
        int food = MAX_FOOD_CAPACITY_IN_CAFE - cage.getFoodCapacity();

        if (hour % getTimeToAddFood() == 0 && !isEnoughFoodInCage(cage)) {
            cage.setFoodCapacity(food);
        }
    }

    /**
     * Checks if food is enough in the cage
     *
     * @param cage
     * @return
     */
    public boolean isEnoughFoodInCage(Cage cage){
        return cage.getFoodCapacity() > MIN_FOOD_CAPACITY_IN_CAGE;
    }
}