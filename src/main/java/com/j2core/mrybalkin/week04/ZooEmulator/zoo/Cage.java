package com.j2core.mrybalkin.week04.ZooEmulator.zoo;

import com.j2core.mrybalkin.week04.ZooEmulator.animals.Animal;

import java.util.List;

/**
 * Created by mrybalkin on 04.08.2016.
 *
 * Class to describe cage
 */
public class Cage {
    private int foodCapacity;
    private List<Animal> animals;

    public Cage(int foodCapacity, List<Animal> animal) {
        this.foodCapacity = foodCapacity;
        this.animals = animal;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void setFoodCapacity(int foodCapacity) {
        this.foodCapacity = foodCapacity;
    }

    public int getFoodCapacity() {
        return foodCapacity;
    }
}