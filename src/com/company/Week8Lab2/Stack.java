package com.company.Week8Lab2;

import java.util.ArrayList;

public class Stack {

    /*String stack_name;
    ArrayList<Person> stack = new ArrayList<>();





    Stack(String stack_name) {
        this.stack_name = stack_name;

//        stack = new ArrayList<>(); //initialise
    }

    //overload
    public void push(String name, int age) {
        //create an object -> new (ClassName) (params);
        stack.add(new Person(name, age));
    }

    public Person pop() {
        Person removedElem = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return removedElem;
    }

    public Person peek() {
        return stack.get(stack.size() - 1);
    }

    public int getSize() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public Stack(String stack_name, ArrayList<Person> stack) {
        this.stack_name = stack_name;
        this.stack = stack;
    }*/

    private ArrayList<Person> personList;
    private final String stack_name;

    Stack(String stack_name) {
        personList = new ArrayList<>();
        this.stack_name = stack_name;
    }

    //overload -> nama method & return type sama // parameter diterima  lain
    public void push(String name, int age) {
        personList.add(new Person(name, age));
    }

    public void push(String name, int age, String gender) {
        personList.add(new Person(name, age, gender));
    }

    public void push(String name, int age, String gender, String occupation) {
        personList.add(new Person(name, age, gender, occupation));
    }

    public void push(Person person) {
        personList.add(person);
    }

    public Person pop() {
        Person removedElem = personList.get(personList.size() - 1);
        personList.remove(personList.size() - 1);
        return removedElem;
    }

    public Person peek() {
        return personList.get(personList.size() - 1);
    }

    public int getSize() {
        return personList.size();
    }

    public boolean isEmpty() {
        return personList.size() == 0;
    }

    public void displayStack() {
        System.out.println("--------- " + stack_name + " ----------");
        if (personList.size() == 0) {
            System.out.println("Empty Stack");
        } else {
            /*
            StringBuilder sb = new StringBuilder("[ ");
            for (int i = 0; i < personList.size() - 1; i++) { //stops at 2nd last node
                sb.append(personList.get(i));
                sb.append(", ");
            }

            sb.append(personList.get(personList.size() - 1));
            sb.append(" ]");
            return sb.toString();

            for (int i = personList.size() - 1; i >= 0; i--) {
                System.out.println(i + " " + personList.get(i));
            }
        }*/

            for (int i = personList.size()-1; i >= 0 ; i--) {
                System.out.println(i+" "+personList.get(i));
            }
        }
        System.out.println("---------- ---------- ----------\n");
    }

}





