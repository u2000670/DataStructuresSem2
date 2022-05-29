package com.company.Week4SinglyLinkedList.Tuto4;

public class Node<E> {
    //    static Node<E> head, tail; // can't have static generic field
    public E elem;
    public Node<E> next;

    public Node(E elem) {
        this.elem = elem;
    }

    public Node() {
    }

    public static void main(String[] args) {
        Node<String> node1 = new Node<>("a");
        Node<String> node2 = new Node<>("z");
        Node<String> head = node1;
        Node<String> tail = node2;

        head.next = tail;
        /*MyLinkedListT<String> mll = new MyLinkedListT<>(new String[]{"a", "z"});
//        MyLinkedList<String> mll= new MyLinkedList<>();
        mll.addFirst("b");
        mll.addLast("y");
        mll.addFirst("firstNode");
        System.out.println("Size of list: " + mll.getSize());*/
//        System.out.println(mll);
//        mll.print();


    }
}


















