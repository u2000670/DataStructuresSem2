package com.company.Week6Stack.Lab6;

import com.company.Week5DoublyLinkedList.Lab5.SList.SNode;

import java.util.ArrayList;
import java.util.Stack;

public class MyStack<E> {
    ArrayList<E> stack;


    MyStack() {
        stack = new ArrayList<>();
    }

    public void push(E e) {
        stack.add(e);
    }

    public E pop() {
        E removedElem = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return removedElem;
    }

    public E peek() {
        return stack.get(stack.size() - 1);
    }

    public int getSize() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public String toString() {
        if (stack.size() == 0)
            return "[]";
        else {

            StringBuilder sb = new StringBuilder("[ ");
            for (int i = 0; i < stack.size() - 1; i++) { //stops at 2nd last node
                sb.append(stack.get(i));
                sb.append(", ");
            }

            sb.append(stack.get(stack.size() - 1));
            sb.append(" ]");
            return sb.toString();
        }
    }

    public boolean search(E e) {
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).equals(e))
                return true;
        }
        return false;
    }
    public Stack<E> toStack(){
        Stack<E> javaStack = new Stack<>();
        javaStack.addAll(this.stack);
        return javaStack;

        //stack[0] = "'
        //array[

    }

}
