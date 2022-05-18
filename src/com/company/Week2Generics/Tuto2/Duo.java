package com.company.Week2Generics.Tuto2;

public class Duo <A, B>{
    A first;
    B second;

    public Duo(A a, B b){
        first = a;
        second = b;
    }

    @Override
    public String toString(){
        return first +" "+second;
    }

    public static void main(String[] args) {
        Duo<String, Integer> sideShape = new Duo<>("square", 3);
        Duo<Double, Double> points = new Duo<>(4.0, 5.1);

        System.out.println(sideShape);
        System.out.println(points);
    }


}
