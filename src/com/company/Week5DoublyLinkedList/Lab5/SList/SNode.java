package com.company.Week5DoublyLinkedList.Lab5.SList;

public class SNode <E>{
    E elem;
    SNode<E> next;
    SNode<E> prev;

    SNode(){
//        elem = null;
//        next = null;
//        prev = null;
    }

    SNode(E elem){
        this.elem = elem;
        next = null;
        prev = null;
    }

}
