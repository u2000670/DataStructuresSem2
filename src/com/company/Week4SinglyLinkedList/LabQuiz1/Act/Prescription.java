package com.company.Week4SinglyLinkedList.LabQuiz1.Act;

public class Prescription <A extends Pet,B,C>{
    private A pet;
    private B medication;
    private C dosage;

    public Prescription(A pet, B medication, C dosage){
        this.pet = pet;
        this.medication = medication;
        this.dosage= dosage;
    }

    @Override
    public String toString(){
        return "----Prescription Note----\n"
                +pet
                + "\nMedication: "+medication
                + "\nDosage(ml): "+dosage;
    }


}
