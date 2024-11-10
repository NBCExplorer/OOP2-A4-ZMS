package com.example.oop2a4zms.Model;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Enclosure implements AnimalCollection, Iterable<Animal> {
    public String aName;
    public String aType;
    private final List<Animal> aAnimal = new ArrayList<>();
    private final List<AnimalCollection> aCollections = new ArrayList<>();

    public Enclosure(String pName, String pType) {
        this.aName = pName;
        this.aType = pType;
    }

    public List<Animal> getAnimal() {
        return new ArrayList<>(aAnimal);  // return a copy for encapsulation
    }

    public void addAnimal(Animal pAnimal) {
        if (pAnimal != null) {
            aAnimal.add(pAnimal);
        }
    }


    public void removeAnimal(Animal pAnimal) {
        aAnimal.remove(pAnimal);
    }

    // TODO: We are exposing the animals here, since they are mutable, breaking encapsulation
    // Suggestion: Make both classes Iterable instead
    public Iterator<Animal> iterator() {
        return aAnimal.iterator();
    }


    // Additional getter methods, following the same convention
    public String getName() {
        return aName;
    }

    @Override
    public void setName(String name) {
        // TODO: Set name securely
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        aName = name;
    }

    public void setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("type cannot be null or empty");
        }
        aType = type;
    }

    public String toString() {
        return this.getName();
    }
}

