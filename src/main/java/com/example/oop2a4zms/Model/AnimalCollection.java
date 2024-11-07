package com.example.oop2a4zms.Model;

import java.util.List;

public interface AnimalCollection {
    void addAnimal(Animal pAnimal);
    void removeAnimal(Animal pAnimal);
    List<Animal> getAnimals();
}

