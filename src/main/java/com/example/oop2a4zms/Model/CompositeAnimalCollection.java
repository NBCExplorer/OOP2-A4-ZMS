package com.example.oop2a4zms.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeAnimalCollection implements AnimalCollection, Iterable<AnimalCollection>{
    private final List<AnimalCollection> aCollections = new ArrayList<>();
    private String aName;

    public void addCollection(AnimalCollection pCollection) {
        this.aCollections.add(pCollection);
    }

    public String showAllAnimals() {
        StringBuilder allAnimals = new StringBuilder();
        for (AnimalCollection currentCollection : aCollections) {
            allAnimals.append(currentCollection.toString()).append("\n");
        }
        return allAnimals.toString();
    }

    public void setName(String pName) {
        if (pName == null) {
            throw new IllegalArgumentException("Name cannot be null");
        } else if (pName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (pName.length() >= 256) {
            throw new IllegalArgumentException("Name cannot exceed 255 characters");
        }
        this.aName = pName;
    }

    public String getName() {
        return this.aName;
    }

    public Iterator<AnimalCollection> iterator() {
        return this.aCollections.iterator();
    }

    public AnimalCollection getSelectedIndex(int selectedIndex) {
        return this.aCollections.get(selectedIndex);
    }

    public String toString() {
        return this.getName();
    }
}

