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

    public Raccoon(String name, int timeToEat, int timeToSleep){
        this.name = name;
        this.timeToEat = timeToEat;
        this.timeToSleep = timeToSleep;
        this.animalStatus = AnimalStatus.ALIVE;
    }

    /**
     * Emulates animal's actions
     *
     * @param cage - in which cage animal is
     * @return cage with animal
     */
    public void emulateAction(Cage cage) {
        if (this.getTimeToEat() < MIN_TIME_TO_EAT){
            this.findFood(cage);

            if (this.getTimeToSleep() <= MIN_TIME_TO_SLEEP) {
                this.sleep();
            } else {
                this.rinse(cage);
            }
        } else {
            this.move();
        }
    }

    public void rinse(Cage cage){
        int foodToEat = random.nextInt(cage.getFoodCapacity());
        int sleepingTime = random.nextInt(this.getTimeToSleep());

        this.setTimeToEat(this.getTimeToEat() - foodToEat);
        this.setTimeToSleep(getTimeToSleep() - sleepingTime);
    }
}
