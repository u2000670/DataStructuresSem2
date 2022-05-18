package com.company.Week4SinglyLinkedList.LabQuiz1.Act;

public class Cat extends Pet {
    private String name;

    public Cat(String name, String breed, double weight, String sickness) {
        super(breed, weight, sickness);
        this.name = name;
    }

    /**
     *
     * @return returns name of pet
     */
    public String getName() {
        return name;
    }

    /**
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + name
                + "\nBreed: " + getBreed()
                + "\nWeight(KG): " + getWeight()
                + "\nSickness: " + getSickness();
    }
}
