package com.company.Week7Queues_PriorityQ.Lab7.QN1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

    //lab qn 3
    public void replace(int index, E e){
        for (int i = 0; i < list.size(); i++) {
            if (index == i){
                list.add(i,e);
                list.remove(i+1);
            }
        }
    }
}
