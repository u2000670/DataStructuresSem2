package com.company.Week4SinglyLinkedList.Lab4;

import com.company.Week4SinglyLinkedList.Tuto4.MyLinkedListT;
import com.company.Week4SinglyLinkedList.Tuto4.Node;

public class MyLinkedList<E> extends MyLinkedListT<E> {

//    private Node<E> head, tail;
//    private int size;

    public int getSize() {
        return size;
    }

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(E e) {
        addLast(e);
    }

    public boolean contains(E e) {
        Node<E> pointer = head;
        for (int i = 0; i < size ; i++) {
            if (pointer.elem.equals(e))
                return true;
            pointer = pointer.next;
        }
        //pointer would be null if exits for loop
        return false;
    }

    public E getFirst() {
        if (size == 0) return null;
        else return head.elem;
    }

    public E getLast() {
        if (size == 0) return null;
        else return tail.elem;
    }

    public E getMiddleValue() {
        int middleIndex = size / 2;
        Node<E> pointer = head;
        for (int i = 0; i < middleIndex; i++)
            pointer = pointer.next;
        return pointer.elem;

    }

    public E get(int index) {
        if (index < 0 || index >= size) return null; //invalid index
        else if (index == 0) return getFirst();
        else if (index == size - 1) return getLast();
        else {
            Node<E> curr = head;
            for (int i = 0; i < index; i++)
                curr = curr.next;
            return curr.elem;
        }
    }

    public int indexOf(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.elem.equals(e))
                return i;
            current = current.next;
        }
        return -1;
    }

    public int lastIndexOf(E e) {
        Node<E> current = head;
        int sameCounter = -1;
        for (int i = 0; i < size; i++) {
            if (current.elem.equals(e))
                sameCounter = i;
            current = current.next;
        }

        return sameCounter;
    }

    //returns old element?
    public E set(int index, E e) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node<E> remember = current;
        current.elem = e;
        return remember.elem;
    }
//Lab5 Q2
    public void replace(E e, E newE) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.elem.equals(e)) {
                current.elem = newE;
                break;
            }
            current = current.next;
        }
    }

    public void clear() {
        size = 0;
        head.next = null;
        head = tail = null;
    }

    public void print() {
        if (size == 0)
            System.out.println("[]");
        else {
            StringBuilder sb = new StringBuilder("[ ");
            Node<E> curr = head;
            for (int i = 0; i < size - 1; i++) { //stops at 2nd last node
                sb.append(curr.elem);
                sb.append(", ");

                curr = curr.next;
            }
            sb.append(tail.elem);
            sb.append(" ]");
            System.out.println(sb);
        }
    }

    public void reverse() {

        if (size == 0)
            System.out.println("[]");
        else {
            Node<E> current = head;
            Object oArray = new Object[size];
            @SuppressWarnings("unchecked")
            E[] tempArray = (E[]) new Object[size];
//        Node<E>[] tempArray = (Node<E>[]) Array.newInstance(Node<E> current, size);

            for (int i = 0; i < size; i++) {
                tempArray[i] = current.elem;
                current = current.next;
            }
            System.out.print("[ ");
            for (int i = tempArray.length - 1; i > 0; i--)
                System.out.print(tempArray[i] + ", ");

            System.out.println(tempArray[0] + " ]");
        }
    }
}
