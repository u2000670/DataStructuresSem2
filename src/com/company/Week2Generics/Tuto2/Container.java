package com.company.Week2Generics.Tuto2;

public class Container <T>{
    private T t;

    public <T> Container(){

    }

    public void add(T a){
        t = a;
    }
    public T retrieve(){
        return t;
    }

    public static void main(String[] args) {
        Container<Integer> cont =  new Container<>();

        cont.add(50);
        System.out.println(cont.retrieve());

        Container<String> cont2 =  new Container<>();
        cont2.add("Java");
        System.out.println(cont2.retrieve());



    }

}
