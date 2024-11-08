package com.example.oop2a4zms.Helpers;


import com.example.oop2a4zms.Model.*;

public class ImportHelper {

    public static CompositeAnimalCollection createAnimals() {
// Create the lions enclosure
        Enclosure lions = new Enclosure("Lions", "Big Cats");
        lions.addAnimal(new Lion("Simba", 3, "Male", 36.5));
        lions.addAnimal(new Lion("Mufasa", 8, "Male", 41.0));
        lions.addAnimal(new Lion("Nala", 3, "Female", 30.0));

// Create the tiger habitat enclosure
        Enclosure tigerHabitat = new Enclosure("Tiger Habitat", "Big Cats");
        tigerHabitat.addAnimal(new Tiger("Shere Khan", 3, "Male", 25.0));
        tigerHabitat.addAnimal(new Tiger("Rajah", 3, "Male", 23.0));

// Create the tiger cubs enclosure
        Enclosure cubs = new Enclosure("Tiger Cubs", "Big Cats");
        cubs.addAnimal(new Tiger("Tala", 5, "Female", 30.0));
        cubs.addAnimal(new Tiger("Ravi", 0, "Male", 2.0));
        cubs.addAnimal(new Tiger("Kali", 0, "Female", 2.0));
        cubs.addAnimal(new Tiger("Indra", 0, "Female", 2.0));

// Create composite for tigers
        CompositeAnimalCollection tigers = new CompositeAnimalCollection();
        tigers.setName("Tigers");
        tigers.addCollection(tigerHabitat);
        tigers.addCollection(cubs);

// Create the cougars enclosure
        Enclosure cougarsEnclosure = new Enclosure("Cougars", "Big Cats");
        cougarsEnclosure.addAnimal(new Cougar("Sierra", 3, "Female", 25.0)); // Add Sierra
        cougarsEnclosure.addAnimal(new Cougar("Rocky", 3, "Male", 18.0)); // Add Rocky
        cougarsEnclosure.addAnimal(new Cougar("Luna", 2, "Female", 23.0)); // Add Luna
        cougarsEnclosure.addAnimal(new Cougar("Lenny", 1, "Male", 26.0)); // Add Lenny

// Create the big cats composite
        CompositeAnimalCollection bigCats = new CompositeAnimalCollection();
        bigCats.setName("Big Cats");
        bigCats.addCollection(lions);
        bigCats.addCollection(tigers);
        bigCats.addCollection(cougarsEnclosure);

        return bigCats;
    }
}