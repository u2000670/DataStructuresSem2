package com.company.Week9LabTest2;

import java.util.LinkedList;

public class FinalsQueue<E> {
    LinkedList<E> list = new LinkedList<>();
    int size;

    FinalsQueue(){

    }

    public FinalsQueue(E[] e) {
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

    public boolean isFull() {
        return !list.isEmpty();
    }

    //k = 0 -> the first element in the queue
    public void changeOrder(int k){

        for (int i = size-1; i >= k ; i--) {
            list.addFirst(list.remove(i));

        }
//        E toBeInFront = list.remove(k);
//        list.addFirst(toBeInFront);
    }

    public void display() {
        System.out.println(list);
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

    public static void main(String[] args) {
        FinalsQueue<Integer> fq = new FinalsQueue<>();
        fq.enqueue(43);
        fq.enqueue(21);
        fq.enqueue(87);
        fq.enqueue(90);
        fq.display();
        fq.changeOrder(2);
        fq.display();
    }
}
