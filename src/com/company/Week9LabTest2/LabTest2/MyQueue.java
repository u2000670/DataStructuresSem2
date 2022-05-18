package com.company.Week9LabTest2.LabTest2;

import java.util.LinkedList;

public class MyQueue<E> {

    LinkedList<E> list = new LinkedList<>();
    E front, rear;

    public MyQueue() {

    }

    public MyQueue(E[] e) {
        for (int i = 0; i < e.length; i++) {
            if(e[i] == null)    //skip null elements
                continue;
            list.add(e[i]);
        }
    }

    public void enqueue(E e) {
        list.add(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public E getElement(int index) {
        return list.get(index);
    }

    public E peek() {
        return list.getFirst();
    }

    public int getSize() {
        return list.size();
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        return list.toString();
    }


}
