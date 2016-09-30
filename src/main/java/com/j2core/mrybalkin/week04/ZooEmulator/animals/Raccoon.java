package com.j2core.mrybalkin.week04.ZooEmulator.animals;

import com.j2core.mrybalkin.week04.ZooEmulator.zoo.Cage;

import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by mrybalkin on 04.08.2016.
 *
 * Class to describe animal
 */
public class Raccoon extends AbstractAnimal {
    public static final int MIN_TIME_TO_EAT = 4;
    public static final int MIN_TIME_TO_SLEEP = 2;

    private Random random = new Random();
    private static Logger logger = Logger.getLogger(Raccoon.class.getName());

    public Raccoon(String name, int timeToEat, int timeToSleep, AnimalStatus animalStatus){
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
    public Cage emulateAction(Raccoon animal, Cage cage) {
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




}
