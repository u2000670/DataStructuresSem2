package com.company.Week1OOPRevision.Tuto1;

import java.util.Random;

public class Telephone {


    private String areaCode;
    private int number;
    private static int numberOfTelephoneObject = 0;

    public Telephone(String areaCode, int number) {
        this.areaCode = areaCode;
        this.number = number;
        numberOfTelephoneObject++;
    }

    public String makeFullNumber(){

        return areaCode + "-" + number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}

class tester {

    public static void main(String[] args) {
        Random r  = new Random();
        Telephone[] tele = new Telephone[5];
        int end = 79676300;


        for (int i = 0; i < tele.length; i++) {
            tele[i] = new Telephone("03",end++) ;
            System.out.println(tele[i]);
            System.out.println(tele[i].makeFullNumber());

        }
    }

}

