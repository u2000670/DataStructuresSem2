package com.company.Week4SinglyLinkedList.Lab4;

public interface TutoMyLinkedList<E>{

    /**
     * adds an element to the first position
     *
     * @param e
     */
    void addFirst(E e);

    /**
     * adds an element at the last position
     *
     * @param e
     */
    void addLast(E e);

    /**
     * adds an element anywhere in the list
     *
     * @param index, e
     */
    void add(int index, E e);

    /**
     * removes the first element of the list
     *
     * @return E element
     */
    E removeFirst();

    /**
     * removes the last element of the list
     *
     * @return E element
     */
    E removeLast();

    /**
     * removes the any element in the list
     *
     * @return E element
     */
    E remove(int index);

    /*
    public String toString() {
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

