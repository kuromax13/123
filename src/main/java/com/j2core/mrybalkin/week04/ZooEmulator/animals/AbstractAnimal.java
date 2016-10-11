package com.j2core.mrybalkin.week04.ZooEmulator.animals;

import com.j2core.mrybalkin.week04.ZooEmulator.zoo.Cage;

import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by mrybalkin on 04.08.2016.
 */
public abstract class AbstractAnimal {
    protected String name;
    protected int timeToSleep;
    protected int timeToEat;
    protected AnimalStatus animalStatus;

    protected static final int CHANCE_TO_FIND_FOOD = 3;

    private Random random = new Random();
    private static Logger logger = Logger.getLogger(Raccoon.class.getName());

    public AnimalStatus getAnimalStatus() {
        return animalStatus;
    }

    public void setAnimalStatus(AnimalStatus animalStatus) {
        this.animalStatus = animalStatus;
    }

    public String getName() {
        return name;
    }

    public int getTimeToSleep() {
        return timeToSleep;
    }

    public int getTimeToEat() {
        return timeToEat;
    }

    public void setTimeToEat(int timeToEat) {
        this.timeToEat = timeToEat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeToSleep(int timeToSleep) {
        this.timeToSleep = timeToSleep;
    }

    /**
     * Emulates animal eating.
     * Adds random number of time to eat and decreases food capacity in the cage.
     *
     * @param cage
     * @return
     */
    public void eat(Cage cage) {
        int foodToEat = random.nextInt(cage.getFoodCapacity());

        this.setTimeToEat(this.getTimeToEat() + foodToEat);
        cage.setFoodCapacity(cage.getFoodCapacity() - foodToEat);
    }

    /**
     * Moves an animal. With random probability eats a food
     *
     * @param cage - cage where animal is
     * @return animal
     */
    public void findFood(Cage cage) {
        int chanceToFindFood = random.nextInt(10); //10 is like 100%

        this.move();
        if (chanceToFindFood > CHANCE_TO_FIND_FOOD){
            this.eat(cage);
        }
    }

    /**
     * Emulates animal moving.
     *
     * Decreases animal time to eat and time to sleep.
     * Check if animal is going to be dead.
     *
     * @return animal after emulating action
     */
    public void move() {
        int sleepingTime = random.nextInt(this.getTimeToSleep());
        int eatingTime = random.nextInt(this.getTimeToEat());

        this.setTimeToEat(getTimeToEat() - eatingTime);
        this.setTimeToSleep(getTimeToSleep() - sleepingTime);
        this.timeToDie();
    }

    /**
     * Check if animal is going to be dead.
     *
     * @return animal with status "DEAD" or "ALIVE"
     */
    public void timeToDie(){
        if (this.getTimeToEat() <= 0){
            logger.warning("Animal is dead.");
            this.setAnimalStatus(AnimalStatus.DEAD);
        }
    }

    /**
     * Emulates animal sleeping.
     *
     * Sets time to sleep.
     * Decreases time to eat.
     *
     * @return animal after sleeping
     */
    public void sleep(){
        int eatingTime = random.nextInt(this.getTimeToEat());
        int sleepingTime = random.nextInt(10);  //10 - max value for sleeping. TODO: think how to avoid using number

        this.setTimeToSleep(sleepingTime);
        this.setTimeToEat(getTimeToEat() - eatingTime);

    }

    public abstract void emulateAction(Cage cage);
}