package com.company.Week5DoublyLinkedList.Lab5.QN3;

//import com.company.Week5DoublyLinkedList.Tuto5.Node;

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

public class DoublyLinkedList<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(E elem) {
        Node<E> newNode = new Node<>(elem, head, null);
        if (head != null) head.prev = newNode;
        head = newNode;
//        if (size == 1)
//            System.out.println(tail.prev == newNode); //outputs true -> tail and head is pointing to the *SAME* object?
        if (tail == null) tail = newNode;
        size++;
    }

    public void addLast(E elem) {
        // scenario 1 : empty list -> head = tail = null
        // scenario 2 : list initially has 1 element
        // scenario 3 : has more than 1 elem in list (ideal) -> head != tail

        Node<E> newNode3 = new Node<>(elem, null, tail);
        if (tail != null) tail.next = newNode3;
        tail = newNode3;
        if (head == null) head = newNode3;
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
        System.out.print("iterating forward >> . . . ");
        Node<E> pointer = head;
        while (pointer != null) {
            System.out.print(pointer.elem);
            System.out.print(" ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public void iterateBackward() {
        System.out.print("iterating backward << . . . ");
        Node<E> pointer = tail;
        while (pointer != null) {
            System.out.print(pointer.elem);
            System.out.print(" ");
            pointer = pointer.prev;
        }
        System.out.println();
    }

    public E removeFirst() {
        Node<E> remember = head; // head != null

        if (head == null) throw new NoSuchElementException();   //if no element (empty)
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
        if (index < 0 || index >= size) {
            System.out.println("---- index out of bounds ----");
            return null;
        }
        else if (index == 0) return removeFirst();
        else if (index == size-1) return removeLast();
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

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addFirst(1);
        dll.addLast(100);
        dll.add(2, 2);
        dll.remove(3);
        dll.iterateForward();
        dll.iterateBackward();
        System.out.println("Current size of list : " + dll.getSize());
        System.out.println("Clearing list . . . ");
        dll.clear();
        System.out.println("Current size of list : " + dll.getSize());

    }


}
