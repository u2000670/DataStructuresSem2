package com.company.Week6Stack.Lab6;

import com.company.Week5DoublyLinkedList.Lab5.QN3.DoublyLinkedList;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TestIntMyStack {

    public static void main(String[] args) {

        //Q2
        MyStack<Integer> intStack = new MyStack<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an int value (-1 to exit) : ");
        int pancake = 0;

        while (true) {
            pancake = sc.nextInt();
            if (pancake == -1)
                break;
            intStack.push(pancake);
            System.out.print("Enter an int value (-1 to exit) : ");
        }

        System.out.println("Stack size : " + intStack.getSize());

        while(!intStack.isEmpty()){
            System.out.print(intStack.pop()+" ");
        }

        //Q3
        //What is the output of the elements? What is the order, why?
        // >> order : LIFO
        Stack<Integer> intStackADT = intStack.toStack();
        System.out.println(intStackADT);
        System.out.println("Sum of all elems : " + stackSum(intStackADT));
        System.out.println("after : " + intStackADT);
    }

    //Q3
    public static int stackSum(Stack<Integer> stack) {
        /*
        //because Stack is a reference variable, popping off the stack passed in the function would actually pop off the actual stack object :|
        int sum = 0;
        for (int i = 0; i < stack.size(); i++) {
            sum += stack.pop();
            System.out.println(">>sum >> " + sum);
        }
        */

        //cloning so as to not affect the original stack when popping off the stack
        Stack<Integer> copyOfStack = (Stack<Integer>) stack.clone();    //clone() returns an Object. hence the typecasting
        int sum = 0;
        for (int i = 0; i < stack.size(); i++) {
            sum += copyOfStack.pop();
        }
        return sum;
    }



}
