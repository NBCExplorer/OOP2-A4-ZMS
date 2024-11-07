package com.example.oop2a4zms.Model;

import java.util.ArrayList;
import java.util.List;

public class Enclosure implements AnimalCollection {
    private String aName;
    private String aType;
    private List<Animal> aAnimals = new ArrayList<>();

    public Enclosure(String pName, String pType) {
        this.aName = pName;
        this.aType = pType;
    }

    @Override
    public void addAnimal(Animal pAnimal) {
        aAnimals.add(pAnimal);
    }

    @Override
    public void removeAnimal(Animal pAnimal) {
        aAnimals.remove(pAnimal);
    }

    @Override
    public List<Animal> getAnimals() {
        return new ArrayList<>(aAnimals);
    }

    // Additional getter methods, following the same convention
    public String getName() {
        return aName;
    }

    public String getType() {
        return aType;
    }
}

