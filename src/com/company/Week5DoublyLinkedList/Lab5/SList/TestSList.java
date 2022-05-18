package com.company.Week5DoublyLinkedList.Lab5.SList;

public class TestSList {
    public static void main(String[] args) {
        SList<String> sl = new SList<>();
        //1)
        sl.appendEnd("Linked List");
        sl.appendEnd("is");
        sl.appendEnd("easy");
        //2)
        sl.display();
        //3)
        System.out.println("Removed initial: "+sl.removeInitial());
        //4)
        System.out.println("\"difficult\" is in the list: "+sl.contains("difficult"));
//        System.out.println("\"easy\" is in the list: "+sl.contains("easy"));
        //5)
        sl.clear();
        sl.display(); //checking if the clear() was successful
    }
}
