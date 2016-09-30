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
     * @param animal
     * @param cage
     * @return
     */
    public AbstractAnimal eat(AbstractAnimal animal, Cage cage) {
        int foodToEat = random.nextInt(cage.getFoodCapacity());

        animal.setTimeToEat(animal.getTimeToEat() + foodToEat);
        cage.setFoodCapacity(cage.getFoodCapacity() - foodToEat);

        return animal;
    }

    /**
     * Moves an animal. With random probability eats a food
     *
     * @param animal - animal to find food
     * @param cage - cage where animal is
     * @return animal
     */
    public AbstractAnimal findFood(AbstractAnimal animal, Cage cage) {
        int chanceToFindFood = random.nextInt(10); //10 is like 100%

        move(animal);
        if (chanceToFindFood > CHANCE_TO_FIND_FOOD){
            eat(animal, cage);
        }
        return animal;
    }

    /**
     * Emulates animal moving.
     *
     * Decreases animal time to eat and time to sleep.
     * Check if animal is going to be dead.
     *
     * @param animal - animal to move
     * @return animal after emulating action
     */
    public AbstractAnimal move(AbstractAnimal animal) {
        int sleepingTime = random.nextInt(animal.getTimeToSleep());
        int eatingTime = random.nextInt(animal.getTimeToEat());

        animal.setTimeToEat(getTimeToEat() - eatingTime);
        animal.setTimeToSleep(getTimeToSleep() - sleepingTime);
        animal = timeToDie(animal);

        return animal;
    }

    /**
     * Check if animal is going to be dead.
     *
     * @param animal - animal to check
     * @return animal with status "DEAD" or "ALIVE"
     */
    public AbstractAnimal timeToDie(AbstractAnimal animal){
        if (animal.getTimeToEat() <= 0){
            logger.warning("Animal is dead.");
            animal.setAnimalStatus(AnimalStatus.DEAD);
        }

        return animal;
    }

    /**
     * Emulates animal sleeping.
     *
     * Sets time to sleep.
     * Decreases time to eat.
     *
     * @param animal - animal to sleep
     * @return animal after sleeping
     */
    public AbstractAnimal sleep(AbstractAnimal animal){
        int eatingTime = random.nextInt(animal.getTimeToEat());
        int sleepingTime = random.nextInt(10);  //10 - max value for sleeping. TODO: think how to avoid using number

        animal.setTimeToSleep(sleepingTime);
        animal.setTimeToEat(getTimeToEat() - eatingTime);

        return animal;
    }
}