package com.company.Week4SinglyLinkedList.LabQuiz1.Act;

import java.util.ArrayList;

public class Vet {
    private String name;
    private String qualification;

    public Vet(String name, String qualification){
        this.name = name;
        this.qualification = qualification;
    }

    public <T extends Pet> void giveTreatment(ArrayList<Prescription<T,String,Integer>> prescriptions ){

        for (Prescription<T,String,Integer> presc: prescriptions
             ) {
            System.out.println(presc);
            System.out.println();
        }


    }
}
