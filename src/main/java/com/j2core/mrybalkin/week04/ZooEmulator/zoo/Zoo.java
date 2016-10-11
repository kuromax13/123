package com.j2core.mrybalkin.week04.ZooEmulator.zoo;

import com.j2core.mrybalkin.week04.ZooEmulator.animals.AbstractAnimal;
import com.j2core.mrybalkin.week04.ZooEmulator.animals.Elephant;
import com.j2core.mrybalkin.week04.ZooEmulator.animals.Lion;
import com.j2core.mrybalkin.week04.ZooEmulator.animals.Raccoon;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by mrybalkin on 8/16/16.
 *
 * Describes zoo - creating cages, creating animals
 */
public class Zoo {
    private static Logger logger = Logger.getLogger(Zoo.class.getName());

    /**
     * Creates random number of cages with animals
     *
     * @return list of created cages with animals
     */
    public static List<Cage> createZoo() {
        List<Cage> cages = new ArrayList<Cage>();
        List<AbstractAnimal> raccoon = new ArrayList<AbstractAnimal>();
        List<AbstractAnimal> elephant = new ArrayList<AbstractAnimal>();
        List<AbstractAnimal> lion = new ArrayList<AbstractAnimal>();

        logger.info("Creating cages and adding animals into it ...");
        raccoon.add(new Raccoon("asd", 10, 10));
        elephant.add(new Elephant("a", 100, 15));
        lion.add(new Lion("a", 40, 9));

        cages.add(new Cage(0, raccoon));
        cages.add(new Cage(0, elephant));
        cages.add(new Cage(0, lion));

        return cages;
    }
}
