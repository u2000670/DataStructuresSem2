package com.company.Week4SinglyLinkedList.Lab4;

//import com.company.Week4.Tuto4;

public class LinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Character> mll = new MyLinkedList<>();

        //5a
        mll.addFirst('a');
        mll.addLast('b');
        mll.add(1,'c');
        mll.add(1,'d');
        mll.add('e');
        //5b
        mll.print();
        System.out.println("Middle Value: "+ mll.getMiddleValue());
        //5c
        mll.reverse();
        //5d
//        System.out.println(mll.size);   //this works too as LinkedListTest is in the same package as TutoMyLinkedList
        System.out.println(mll.getSize());
        //5e
        System.out.println("First element: "+mll.getFirst()+"\tLast element: "+mll.getLast());
        //5f
        System.out.println("Removed element: "+mll.remove(2));
        System.out.println("Middle Value: "+ mll.getMiddleValue());
        //5g
        System.out.println("index for 2nd & 3rd element: "+ mll.indexOf('d')+" "+ mll.indexOf('b'));
        //5h
        System.out.println("'c' is in the list: "+mll.contains('c'));
        //5i
        char[] newList = {'h','e','l','l','o'};
        mll.add('f');
        for (int i = 0; i < mll.getSize(); i++) {
            mll.set(i,newList[i]);
        }
        mll.print();
//        System.out.println("Middle Value: "+ mll.getMiddleValue());
    }
}
