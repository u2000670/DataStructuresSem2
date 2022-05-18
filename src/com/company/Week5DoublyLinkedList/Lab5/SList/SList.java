package com.company.Week5DoublyLinkedList.Lab5.SList;

import java.util.NoSuchElementException;

public class SList<E> {
    private SNode<E> head;
    private SNode<E> tail;
    private int size;

    SList() {
        size = 0;
        head = null;
        tail = null;
    }

    public void appendEnd(E e) {
        /*if (size == 0) {
            head = tail = new SNode<>(e);
            size++;
        } else {
            SNode<E> newNode = new SNode<>(e);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }*/
        SNode<E> newNode = new SNode<>(e);
        newNode.prev = tail;
        if (tail != null) tail.next = newNode;
        tail = newNode;
        if (head == null) head = tail;  //if list was initially empty
        size++;
    }

    public E removeInitial() {
        if (size == 0) throw new NoSuchElementException();
        SNode<E> removedHead = head;
        head = head.next;
        if (head != null)
            head.prev = null;
        else tail = null;
        size--;
        return removedHead.elem;
    }

    public boolean contains(E e) {
        SNode<E> frontPointer = head;
        SNode<E> backPointer = tail;
        for (int i = 0; i < size / 2 + 1; i++) {        //if the condition was i <size/2, then for odd sizes, the middle won't be checked
                                                        // + 1 is added to be able to check the middle element of the list with size = odd
            if (frontPointer.elem.equals(e) || backPointer.elem.equals(e))
                return true;
            frontPointer = frontPointer.next;   //iterates forward
            backPointer = backPointer.prev;     //iterates backward
        }
        return false;
    }

    public void clear() {
        /*
        SNode<E> pointer = head;
        //severes connections
        while (head != null) {
            pointer = head.next;
            head.prev = head.next = null;
            head = pointer;
        }
//        tail.prev = tail.next = null; //shouldn't tail's pointers already be null after while loop?
        size = 0;*/

        tail = head = null;    //we access the list through the head & tail so w/o these, we won't have access to the list
        size =0;
    }

    public void display() {
        if (size == 0)
            System.out.println("[]");
        else {
            StringBuilder sb = new StringBuilder("[ ");
            SNode<E> pointer = head;
            for (int i = 0; i < size - 1; i++) { //stops at 2nd last node
                sb.append(pointer.elem);
                sb.append(", ");

                pointer = pointer.next;
            }
            sb.append(tail.elem);
            sb.append(" ]");
            System.out.println(sb);
        }
    }

}


