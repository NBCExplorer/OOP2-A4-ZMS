package com.example.oop2a4zms.Model;

public class Animal {
    private String name;
    private int age;
    private String sex;
    private double weight;

    // Constructor
    public Animal(String name, int age, String sex, double weight) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
    }

    // Getter and Setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for Age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) { // Simple validation to ensure non-negative age
            this.age = age;
        }
    }

    // Getter and Setter for Sex
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    // Getter and Setter for Weight
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight >= 0) {
            // Simple validation to ensure non-negative weight
            this.weight = weight;
        }
    }

    // toString method for debugging and display purposes
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", weight=" + weight +
                '}';
    }
}
