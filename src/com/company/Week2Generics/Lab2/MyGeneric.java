package com.company.Week2Generics.Lab2;

public class MyGeneric <G>{
    private G e;

    public MyGeneric(){}

    public MyGeneric(G e){
        this.e=e;
    }

    public G getE() {
        return e;
    }

    public void setE(G e) {
        this.e = e;
    }

    public static void main(String[] args) {
        MyGeneric<String> strObj = new MyGeneric<>("heyy soul sister");
        MyGeneric<Integer> intObj = new MyGeneric<>();

        intObj.setE(345);

        System.out.println(strObj.getE());
        System.out.println(intObj.getE());


    }
}
