package com.example.oop2a4zms.Model;

public class Animal {
    private String aName;
    private int aAge;
    private String aSex;
    private double aWeight;

    // Constructor
    public Animal(String pName, int pAge, String pSex, double pWeight) {
        this.aName = pName;
        this.aAge = pAge;
        this.aSex = pSex;
        this.aWeight = pWeight;
    }


    public String getName() {
        return aName;
    }

    public void setName(String pName) {
        this.aName = pName;
    }


    public int getAge() {
        return aAge;
    }

    public void setAge(int pAge) {
        if (pAge >= 0) {
            this.aAge = pAge;
        }
    }


    public String getSex() {
        return aSex;
    }

    public void setSex(String pSex) {
        this.aSex = pSex;
    }


    public double getWeight() {
        return aWeight;
    }

    public void setWeight(double pWeight) {
        if (pWeight >= 0) {
            this.aWeight = pWeight;
        }
    }

    // toString method for debugging and display purposes
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + aName + '\'' +
                ", age=" + aAge +
                ", sex='" + aSex + '\'' +
                ", weight=" + aWeight +
                '}';
    }
}
