package com.company.Week4SinglyLinkedList.LabQuiz1.Act;

public class Pet implements Comparable<Pet> {
    private String breed;
    private double weight;
    private String sickness;

    public Pet(String breed, double weight, String sickness) {
        this.breed = breed;
        this.weight = weight;
        this.sickness = sickness;
    }

    /**
     *
     * @return returns the breed of a pet
     */
    public String getBreed() {
        return breed;
    }

    /**
     *
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     *
     * @return returns the weight of pet
     */
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     *
     * @return returns the sickness of pet
     */
    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    /**
     *
     * @return returns 0 if weight is the same, returns >0 if calling pet is heavier, returns <0 if anotherPet is heavier
     */
    @Override
    public int compareTo(Pet anotherPet) {

        return Double.compare(weight, anotherPet.weight);
    }
}
