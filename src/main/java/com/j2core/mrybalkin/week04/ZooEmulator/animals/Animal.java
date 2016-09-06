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

    public Animal findFood(Animal animal, Cage cage) {
        int chanceToFindFood = random.nextInt(10); //10 is like 100%

        move(animal);
        if (chanceToFindFood > CHANCE_TO_FIND_FOOD){
            eat(animal, cage);
        }
        return animal;
    }

    public Animal eat(Animal animal, Cage cage) {
        int foodToEat = random.nextInt(cage.getFoodCapacity());

        animal.setTimeToEat(animal.getTimeToEat() + foodToEat);
        cage.setFoodCapacity(cage.getFoodCapacity() - foodToEat);

        return animal;
    }

    public Animal move(Animal animal) {
        int sleepingTime = random.nextInt(animal.getTimeToSleep());
        int eatingTime = random.nextInt(animal.getTimeToEat());

        animal.setTimeToEat(getTimeToEat() - eatingTime);
        animal.setTimeToSleep(getTimeToSleep() - sleepingTime);
        animal = timeToDie(animal);

        return animal;
    }

    public Animal sleep(Animal animal){
        int eatingTime = random.nextInt(animal.getTimeToEat());

        animal.setTimeToSleep(10);
        animal.setTimeToEat(getTimeToEat() - eatingTime);

        return animal;
    }

    public Animal timeToDie(Animal animal){
        if (getTimeToEat() <= 0){
            logger.warning("Animal is dead.");
            animal.setAnimalStatus(AnimalStatus.DEAD);
        }

        return animal;
    }
}
