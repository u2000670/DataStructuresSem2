package com.company.Week4SinglyLinkedList.Tuto4;

import com.company.GameCharacter;

import java.util.Comparator;
import java.util.Objects;

public class MyLinkedListT<E> {
    protected Node<E> head, tail;
    protected int size;

    public MyLinkedListT() {
        head = null;
        tail = null;
    }

    /*code for world of titans ends here*/
    public E getMiddle(E start, E last) {
        if (start == null)
            return null;

        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.elem.equals(start)) //finding start Node in list
                break;
            temp = temp.next;
        }
        //after loop -> temp == start
        //temp == slow && fastNode == fast

        Node<E> fastNode = temp.next;

//        E slow = temp.elem;
//        E fast = fastNode.elem;
        if (fastNode == null)
            return temp.elem;

        while (last != fastNode.elem) {
            fastNode = fastNode.next;
            if (fastNode.elem != last) {
                temp = temp.next;
                fastNode = fastNode.next;
            }
            if (fastNode == null) break;
        }
        return temp.elem;
    }

    protected Node<E> getNode(E e) {

        Node<E> temp = head;
        while (temp != null) {
            if (temp.elem.equals(e))
                break;
            temp = temp.next;
        }//temp = e's node
        return temp;
    }

/*code for world of titans ends here*/

    public int getSize() {
        return size;
    }

    /**
     * @param arr
     */
    public MyLinkedListT(E[] arr) {
        if (arr.length == 0) {
            head = null;
            tail = null;
        } else if (arr.length == 1) {
            head = new Node<>(arr[0]);
            tail = head;
            size++;
        } else {
            head = new Node<>(arr[0]);
            Node<E> currElem = head;
            size++;
            for (int i = 1; i < arr.length - 1; i++) {
                System.out.println(arr[i]);
                currElem.next = new Node<>(arr[i]);
                currElem = new Node<>(arr[i]);
                size++;
            }
            tail = new Node<>(arr[arr.length - 1]);
            currElem.next = tail;
            size++;
        }
    }

    /*public MyLinkedList(Node<E>[] arr) {
        if (arr.length == 0) {
            head = null;
            tail = null;
        } else if (arr.length == 1) {
            head = arr[0];
            tail = head;
        } else {
            head = arr[0];
            Node<E> currElem = head;
            for (int i = 1; i < arr.length - 1; i++) {
                currElem.next = arr[i];
                currElem = arr[i];
            }
            tail = arr[arr.length - 1];
            currElem.next = tail;
        }
    }*/

    /**
     * adds an element to the first position
     *
     * @param e
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;
        if (newNode.next == null) //if initially empty (no nodes before this)
            tail = head;
    }

    /**
     * adds an element at the last position
     *
     * @param e
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail != null) {
            tail.next = newNode;
            tail = newNode;
        } else {
            head = tail = newNode;
        }
        size++;
    }

    /**
     * adds an element anywhere in the list
     *
     * @param index, e
     */
    public void add(int index, E e) {
        Node<E> newNode = new Node<>(e);
        if (index == 0) addFirst(e);
        else if (index >= size) addLast(e);
        else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) //stops at node of index-1
                current = current.next;
            Node<E> rememberNode = current.next;
            current.next = newNode;
            newNode.next = rememberNode;
            size++;
        }
    }

    /**
     * removes the first element of the list
     *
     * @return E element
     */
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

    /**
     * removes the last element of the list
     *
     * @return E element
     */
    public E removeLast() {
        if (size == 0) return null;
        else if (size == 1) return removeFirst();
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

    /**
     * removes the any element in the list
     *
     * @return E element
     */
    public E remove(int index) {
        if (index < 0 || index >= size) return null; //invalid index
        else if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        else {
            Node<E> curr = head;
            for (int i = 0; i < index - 1; i++)
                curr = curr.next;
            Node<E> remember = curr.next;
            curr.next = remember.next;

            remember.next = null;//severing the remember's next pointer ~~or deleting the node next to remember (thus destroying the list) ? ~~
            //making the remember's next pointer point to nothing (null)
            // we're not deleting the remember.next object?
            size--;
            return remember.elem;
        }
    }

    /**
     * sees if the list contains the element e
     *
     * @return boolean
    public boolean contains(E e) {
    Node<E> pointer = head;
    for (int i = 0; i < size - 1; i++) {
    if (pointer.elem.equals(e))
    return true;
    pointer = pointer.next;
    }
    return false;
    }*/

    /*public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        Node<E> curr = head;
        for (int i = 0; i < size - 1; i++) { //stops at 2nd last node
            sb.append(curr.elem);
            sb.append(", ");

            curr = curr.next;
        }
        sb.append(tail.elem);
        sb.append(" ]");
        return sb.toString();
    }*/
}
