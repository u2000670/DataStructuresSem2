package com.company.Week5DoublyLinkedList.Tuto5;

import java.util.NoSuchElementException;

class Node<E> {
    E elem;
    Node<E> next;
    Node<E> prev;

    public Node(E elem, Node<E> next, Node<E> prev) {
        this.elem = elem;
        this.next = next;
        this.prev = prev;
    }

    public Node(E elem) {
        this.elem = elem;
        this.next = null;
        this.prev = null;
    }
}

class MaiLinkedList<E> {
    int size = 0;
    Node<E> head;
    Node<E> tail;

    public MaiLinkedList() {
        head = null;
        tail = null;

    }

    public void addFirst(E elem) {
        Node<E> newNode = new Node<>(elem, head, null);
        if (head != null) head.prev = newNode;
        head = newNode;

        /* //just checking
        if (size == 1)
            System.out.println(tail.prev == newNode); //this outputs as true*/

        if (tail == null) tail = newNode;
        size++;
    }

    public void addLast(E elem) {

        Node<E> newNode3 = new Node<>(elem, null, tail);
        if (tail != null) tail.next = newNode3;     //if list wasn't empty
        tail = newNode3;
        if (head == null) head = newNode3;          //if list was empty
        size++;
    }

    public void add(int index, E elem) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        else if (index == 0) addFirst(elem);
        else if (index == size) addLast(elem);
        else {
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) { //stops at index-1 (1 node before the inserted node)
                temp = temp.next;
            }

            Node<E> insert = new Node<>(elem, temp.next, temp);
            temp.next = insert; //set next pointer of elem at index-1
            insert.next.prev = insert; //set prev pointer of elem at index+1
            size++;
        }

    }

    public void iterateForward() {
        System.out.println("iterating forward >> . . . ");
        Node<E> pointer = head;
        while (pointer != null) {
            System.out.print(pointer.elem);
            System.out.print(" ");
            pointer = pointer.next;
        }
    }

    public void iterateBackward() {
        System.out.println("iterating backward >> . . . ");
        Node<E> pointer = tail;
        while (pointer != null) {
            System.out.print(pointer.elem);
            System.out.print(" ");
            pointer = pointer.prev;
        }
    }

    public E removeFirst() {
        Node<E> remember = head; // head != null

        if (head == null) throw new NoSuchElementException();   //if no element (empty)

        //the commented code below is what i initially thought of doing
        /*
        //1 elem in list
        else if (head == tail) {
            head = tail = null;
        } else {  //ideal (more than 1 elem)
            head.next.prev = null;
            head = head.next;
        }
        */

        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;   //if list initially had 1 elem

        size--;
        return remember.elem;
    }

    public E removeLast() {
        Node<E> remember = tail;
        if (tail == null) throw new NoSuchElementException();
        if (tail != head) tail.prev.next = null;
        else head = null;
        tail = tail.prev;

        size--;
        return remember.elem;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        else if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        else {
            Node<E> pointer = head;
            for (int i = 0; i < index; i++) {
                pointer = pointer.next;
            } //pointer stops at the node that's to be removed
            Node<E> remember = pointer;
            pointer.prev.next = pointer.next;
            pointer.next.prev = pointer.prev;

            pointer.next = null; //making sure the prev and next pointers for deleted node are null
            pointer.prev = null; //not actually deleting the previous and next elements

            size--;
            return pointer.elem;
        }
    }

    public void clear() {
        //severing the connections?
        Node<E> pointer;
        while (head != null) {
            pointer = head.next;
            head.prev = head.next = null;
            head = pointer;
        }
        tail.prev = tail.next = null;
        size = 0;
    }

    //TUTO5 QN1
    public E xyz(int index, E e) {
        Node<E> current = head;
        Node<E> temp;
        if (index < 0) return null;
        else if (index >= size - 1) {
            this.addLast(e);
            return null;
        } else if (index == 0) { //if replacing the first node
            temp = head;    //stores the initial head node to be returned later
            head.elem = e;  // replaces the head's element with the new element, e
            return temp.elem;   //returns the old element
        } else {
            for (int i = 1; i < index; i++) {
                current = current.next;
            }//current would be 1 node before the targeted node
            temp = current.next;    //stores the replaced node to be returned later
            current.next.elem = e;  //replaces element of the replaced node with the new element,e
            return temp.elem;       //returns the old element
        }
    }

    public E replace(int index, E e) {
        Node<E> temp;
        if (index < 0 || index >= size) return null;
        else if (index == 0) { //if replacing the first node
            temp = head;    //stores the initial head node to be returned later
            head.elem = e;  // replaces the head's element with the new element, e
        } else if (index == size - 1) {
            temp = tail;
            tail.elem = e;
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {   //current would be 1 node before the targeted node
                current = current.next;
            }
            temp = current.next;    //stores the replaced node to be returned later
            current.next.elem = e;  //replaces element of the replaced node with the new element,e
        }
        return temp.elem;   //returns the old element
    }

}

public class test {
    public static void main(String[] args) {
        MaiLinkedList<String> mll = new MaiLinkedList<>();
        mll.addFirst("eh");
        System.out.println("first elem: " + mll.removeFirst());

    }
}
