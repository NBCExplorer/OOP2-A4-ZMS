package com.example.oop2a4zms.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Enclosure implements AnimalCollection, Iterable<Animal> {
    private String aName;
    private String aType;
    private List<Animal> aAnimals = new ArrayList<>();

    public Enclosure(String pName, String pType) {
        this.aName = pName;
        this.aType = pType;
    }


    public void addAnimal(Animal pAnimal) {
        aAnimals.add(pAnimal);
    }

    public void removeAnimal(Animal pAnimal) {
        aAnimals.remove(pAnimal);
    }

    // TODO: We are exposing the animals here, since they are mutable, breaking encapsulation
    // Suggestion: Make both classes Iterable instead
    public Iterator<Animal> iterator() {
        return aAnimals.iterator();
    }
//    public List<Animal> getAnimals() {
//        return new ArrayList<>(aAnimals);
//    }

    // Additional getter methods, following the same convention
    public String getName() {
        return aName;
    }

    @Override
    public void setName(String name) {
        // TODO: Set name securely
    }

    public String getType() {
        return aType;
    }
}

