package com.company.Week2Generics.Tuto2;

import java.util.ArrayList;

public class ArrayListTest {

    public static void allTransportation(ArrayList<?> arrayList1,ArrayList<?> arrayList2){
        System.out.println("this is for qn 7");
    }
    public static void display(ArrayList<?> arrList){
        for (Object o:arrList
             ) {
            System.out.print(o+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //qn 7
        ArrayList<String> vehicle = new ArrayList<>();
        ArrayList<Object> transportation = new ArrayList<>();
        //qn 8
        ArrayList<Integer> numOfCars = new ArrayList<>();
        ArrayList<Double> milesPerHour = new ArrayList<>();

        numOfCars.add(12);
        numOfCars.add(34);
        numOfCars.add(45);
        display(numOfCars);

    }
}
