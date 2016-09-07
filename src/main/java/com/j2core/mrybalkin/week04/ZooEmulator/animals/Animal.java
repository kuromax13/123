package com.j2core.mrybalkin.week04.ZooEmulator.animals;

import com.j2core.mrybalkin.week04.ZooEmulator.zoo.Cage;

import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by mrybalkin on 04.08.2016.
 *
 * Class to describe anomal
 */
public class Animal extends AbstractAnimal {
    public static final int MIN_TIME_TO_EAT = 4;
    public static final int MIN_TIME_TO_SLEEP = 2;
    protected static final int CHANCE_TO_FIND_FOOD = 3;

    private Random random = new Random();
    private static Logger logger = Logger.getLogger(Animal.class.getName());

    public Animal(String name, int timeToEat, int timeToSleep, AnimalStatus animalStatus){
        this.name = name;
        this.timeToEat = timeToEat;
        this.timeToSleep = timeToSleep;
        this.animalStatus = animalStatus;
    }

    /**
     * Emulates animal's actions
     *
     * @param animal - animal to emulate
     * @param cage - in which cage animal is
     * @return cage with animal
     */
    public Cage emulateAction(Animal animal, Cage cage) {
        if (animal.getTimeToEat() < MIN_TIME_TO_EAT){
            animal.findFood(animal, cage);

            if (animal.getTimeToSleep() <= MIN_TIME_TO_SLEEP) {
                animal.sleep(animal);
            }
        } else {
            animal.move(animal);
        }

        return cage;
    }

    /**
     * Moves an animal. With random probability eats a food
     *
     * @param animal - animal to find food
     * @param cage - cage where animal is
     * @return animal
     */
    public Animal findFood(Animal animal, Cage cage) {
        int chanceToFindFood = random.nextInt(10); //10 is like 100%

        move(animal);
        if (chanceToFindFood > CHANCE_TO_FIND_FOOD){
            eat(animal, cage);
        }
        return animal;
    }

    /**
     * Emulates animal eating.
     * Adds random number of time to eat and decreases food capacity in the cage.
     *
     * @param animal
     * @param cage
     * @return
     */
    public Animal eat(Animal animal, Cage cage) {
        int foodToEat = random.nextInt(cage.getFoodCapacity());

        animal.setTimeToEat(animal.getTimeToEat() + foodToEat);
        cage.setFoodCapacity(cage.getFoodCapacity() - foodToEat);

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
    public Animal move(Animal animal) {
        int sleepingTime = random.nextInt(animal.getTimeToSleep());
        int eatingTime = random.nextInt(animal.getTimeToEat());

        animal.setTimeToEat(getTimeToEat() - eatingTime);
        animal.setTimeToSleep(getTimeToSleep() - sleepingTime);
        animal = timeToDie(animal);

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
    public Animal sleep(Animal animal){
        int eatingTime = random.nextInt(animal.getTimeToEat());
        int sleepingTime = random.nextInt(10);  //10 - max value for sleeping. TODO: think how to avoid using number

        animal.setTimeToSleep(sleepingTime);
        animal.setTimeToEat(getTimeToEat() - eatingTime);

        return animal;
    }

    /**
     * Check if animal is going to be dead.
     *
     * @param animal - animal to check
     * @return animal with status "DEAD" or "ALIVE"
     */
    public Animal timeToDie(Animal animal){
        if (animal.getTimeToEat() <= 0){
            logger.warning("Animal is dead.");
            animal.setAnimalStatus(AnimalStatus.DEAD);
        }

        return animal;
    }
}
