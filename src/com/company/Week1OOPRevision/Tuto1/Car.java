package com.company.Week1OOPRevision.Tuto1;

public class Car extends Vehicle {

    public Car(double mS) {
        super(mS);
    }

    @java.lang.Override
    public void accelerate() {
        currentSpeed++;
    }

    public static void main(String[] args) {
        Car c = new Car(10);
        System.out.println(c.getMaxSpeed());
        System.out.println(c.getCurrentSpeed());
        c.pedalToTheMetal();
        System.out.println(c.getCurrentSpeed());
    }

}
