package com.j2core.mrybalkin.week04.ZooEmulator.animals;

import com.j2core.mrybalkin.week04.ZooEmulator.zoo.Cage;

import java.util.Random;

/**
 * Created by mrybalkin on 9/30/16.
 */
public class Lion extends AbstractAnimal {

    public static final int MIN_TIME_TO_EAT = 1;
    public static final int MIN_TIME_TO_SLEEP = 2;
    private Random random = new Random();

    public Lion(String name, int timeToEat, int timeToSleep){
        this.name = name;
        this.timeToEat = timeToEat;
        this.timeToSleep = timeToSleep;
        this.animalStatus = AnimalStatus.ALIVE;
    }

    @Override
    public void emulateAction(Cage cage) {
        if (this.getTimeToEat() < MIN_TIME_TO_EAT){
            this.findFood(cage);

            if (this.getTimeToSleep() <= MIN_TIME_TO_SLEEP) {
                this.sleep();
            } else {
                this.purr();
            }
        } else {
            this.move();
        }
    }

    public void purr(){
        int sleepingTime = random.nextInt(this.getTimeToSleep());

        this.setTimeToSleep(getTimeToSleep() + sleepingTime);
    }
}
