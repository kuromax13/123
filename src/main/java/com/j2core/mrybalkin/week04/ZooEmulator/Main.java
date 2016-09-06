package com.j2core.mrybalkin.week04.ZooEmulator;

import com.j2core.mrybalkin.week04.ZooEmulator.animals.AnimalStatus;
import com.j2core.mrybalkin.week04.ZooEmulator.animals.Animal;
import com.j2core.mrybalkin.week04.ZooEmulator.zoo.Cage;
import com.j2core.mrybalkin.week04.ZooEmulator.zoo.Worker;
import com.j2core.mrybalkin.week04.ZooEmulator.zoo.Zoo;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by mrybalkin on 04.08.2016.
 */
public class Main {
    protected static final int TIME_TO_EMULATE = 168;

    private static List<Cage> zoo;
    private static Worker worker = new Worker("John", 3);
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        zoo = Zoo.createZoo();

        for(int i = 0; i < TIME_TO_EMULATE; i++) {
            for (Cage cage : zoo) {
                worker.workInCage(cage, i);
                emulateAnimals(cage);
            }
        }
    }

    public static Cage emulateAnimals(Cage cage){
        for (Animal animal : cage.getAnimals()) {
            if (animal.getAnimalStatus() != AnimalStatus.DEAD){
                animal.emulateAction(animal, cage);
            } else {
                logger.info("This animal is dead, can't do anything wit it.");
            }
        }
        return cage;
    }
}
