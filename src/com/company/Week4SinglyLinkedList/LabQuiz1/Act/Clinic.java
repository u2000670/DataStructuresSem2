package com.company.Week4SinglyLinkedList.LabQuiz1.Act;

import java.util.ArrayList;

public class Clinic {
    String clinicName;
    private final Vet vetInCharge;

    public Clinic (String clinicName, String vetName, String vetQualification){
        this.clinicName = clinicName;
        vetInCharge = new Vet (vetName,vetQualification);
    }

    public static void main(String[] args) {
        Clinic HAC = new Clinic("Happy Animal Clinic", "Abu Bakar", "DVM(India)");
        Cat dimmy = new Cat("Dimmy", "Siamese", 5, "Diarrhea");
        Cat tabby = new Cat("Tabby", "British Shorthair", 6, "Worms");


        ArrayList<Prescription<Cat,String,Integer>> prescriptionList = new ArrayList<>();
        prescriptionList.add(new Prescription<>(dimmy,"Pyrantel",3));
        prescriptionList.add(new Prescription<>(tabby,"Tylosin",5));

        HAC.getVet().giveTreatment(prescriptionList);

        System.out.print("\nWeight analysis: ");
        if(dimmy.compareTo(tabby) > 0)
            System.out.println("Dimmy is heavier than Tabby");
        else if (dimmy.compareTo(tabby)< 0)
            System.out.println("Tabby is heavier than Dimmy");
        else
            System.out.println("Tabby and Dimmy weigh the same");

    }

    public Vet getVet() {
        return vetInCharge;
    }

}
