package com.company.Week2Generics.Tuto2;

import java.util.LinkedList;

public class MyArray <T>{
     static LinkedList<Object[]> list = new LinkedList<>();

    public MyArray(T[] t){
        list.add(t);

    }

    public void listAll(){
        for (Object[] o : list) {
            System.out.print("{ ");
            for (Object ts: o) {
                System.out.print(ts+" ");
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args) {


        MyArray<Integer> intArr = new MyArray<>(new Integer[]{1,2,3,4,5});
        MyArray<String> names = new MyArray<>(new String[]{"Jane", "Tom", "Bob"});
        MyArray<Character> alphabet = new MyArray<>(new Character[]{'a', 'b', 'c'});

        intArr.listAll();

    }

}
