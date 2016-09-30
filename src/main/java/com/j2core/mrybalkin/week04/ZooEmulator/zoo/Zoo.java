package com.j2core.mrybalkin.week04.ZooEmulator.zoo;

import com.j2core.mrybalkin.week04.ZooEmulator.animals.AnimalStatus;
import com.j2core.mrybalkin.week04.ZooEmulator.animals.Raccoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by mrybalkin on 8/16/16.
 *
 * Describes zoo - creating cages, creating animals
 */
public class Zoo {
    private static final int MAX_CAGE_NUMBER = 10;
    private static final int MAX_ANIMAL_NUMBER_IN_CAGE = 10;

    private static Random random = new Random();
    private static Logger logger = Logger.getLogger(Zoo.class.getName());

    /**
     * Creates random number of cages with animals
     *
     * @return list of created cages with animals
     */
    public static List<Cage> createZoo() {
        List<Cage> cages = new ArrayList<Cage>();
        int randomCage = random.nextInt(MAX_CAGE_NUMBER) + 1;

        logger.info(randomCage + " cages are created");
        for (int i = 0; i < randomCage; i++){
            cages.add(new Cage(0, createAnimals()));
        }

        return cages;
    }

    /**
     * Creates random number of animals
     *
     * @return list of animals
     */
    public static List<Raccoon> createAnimals(){
        List<Raccoon> animals = new ArrayList<Raccoon>();
        int randomAnimal = random.nextInt(MAX_ANIMAL_NUMBER_IN_CAGE) + 1;

        logger.info(randomAnimal + " animals are created");

        for (int i = 0; i < randomAnimal; i++){
            animals.add(new Raccoon("Animal " + i, Raccoon.MIN_TIME_TO_EAT, Raccoon.MIN_TIME_TO_SLEEP, AnimalStatus.ALIVE));
        }

        return animals;
    }
}
