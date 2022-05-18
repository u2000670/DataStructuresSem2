package com.company.Week2Generics.Tuto2;

import java.util.ArrayList;

public class Transport
{

    public static void display(ArrayList<?> list1){
        for (Object o:list1
             ) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numOfCars = new ArrayList<>();
        ArrayList<Double> milesPerHour = new ArrayList<>();

        display(numOfCars);
        display(milesPerHour);
    }
}
