package com.company.Week5DoublyLinkedList.Lab5.QN2StudentList;

import com.company.Week4SinglyLinkedList.Tuto4.Node;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail != null) {
            tail.next = newNode;
            tail = newNode;
        } else {
            head = tail = newNode;
        }
        size++;
    }

    public E removeFirst() {
        if (size == 0) return null; //list is initially empty
        else {
            Node<E> returnedHead = head;
            head = head.next;
            size--;
            if (head == null) //if list initially had 1 element then that means removeFirst() would make head == null
                tail = null;
            return returnedHead.elem;
        }
    }

    public E removeLast() {
        if (size == 0) return null;
//        else if (size == 1) return removeFirst(); //already checked in removeElement()
        else {
            Node<E> point = head;
            for (int i = 0; i < size - 2; i++) { //stops at 2nd last node
                point = point.next;
            }
            Node<E> remember = tail;
            point.next = null;
            tail = point;
            size--;
            return remember.elem;
        }
    }

    public void removeElement(E e) {
        if (head.elem.equals(e)) removeFirst();
        else if (tail.elem.equals(e)) removeLast();
        else {
            Node<E> current = head;
            for (int i = 0; i < size - 1; i++) {
                if (current.next.elem.equals(e)) break;
                current = current.next;
            }//if NOT found, current == tail
            //if FOUND, current == 1 node before the removed Node
            /*if (current == tail) {
                System.out.println("XXXXXXXXXXX Element was not found in the list XXXXXXXXXXX");
                return;
            }*/
            if(current == tail) throw new NoSuchElementException();
            current.next = current.next.next;
            size--;
        }
    }

    public boolean contains(E e) {
        Node<E> pointer = head;
        for (int i = 0; i < size; i++) {
            if (pointer.elem.equals(e))
                return true;
            pointer = pointer.next;
        }
        //pointer would be null after exiting for loop
        return false;
    }

    public void replace(E e, E newE) {
        Node<E> current = head;
        if(size == 0 )throw new NoSuchElementException();   //if the list is empty
        for (int i = 0; i < size; i++) {
            if (current.elem.equals(e)) {
                current.elem = newE;
                break;
            }
            current = current.next;
        }
        if (current == null) throw new NoSuchElementException();    //if the element to be replaced is not found
    }


    public void printList() {
        if (size == 0)
            System.out.println();
        else {
            StringBuilder sb = new StringBuilder();
            Node<E> curr = head;
            for (int i = 0; i < size - 1; i++) { //stops at 2nd last node
                sb.append(curr.elem);
                sb.append(", ");

                curr = curr.next;
            }
            sb.append(tail.elem);
            System.out.println(sb);
        }
    }

}
