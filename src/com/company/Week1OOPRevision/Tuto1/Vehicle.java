package com.company.Week1OOPRevision.Tuto1;

public abstract class Vehicle {


    double maxSpeed;
    protected double currentSpeed;

    public Vehicle(double mS) {
        maxSpeed = mS;
    }

    public abstract void accelerate();

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void pedalToTheMetal() {
        while (currentSpeed != maxSpeed) {
            accelerate();
        }

//        for (; currentSpeed != maxSpeed; accelerate()) {
//
//        }
    }
}



