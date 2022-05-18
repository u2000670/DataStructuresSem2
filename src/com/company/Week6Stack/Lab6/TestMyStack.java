package com.company.Week6Stack.Lab6;

public class TestMyStack {
    public static void main(String[] args) {

        // Q1 b)
        MyStack<Character> charStack = new MyStack<>();
        charStack.push('a');
        charStack.push('b');
        charStack.push('c');

        System.out.println(charStack);
        System.out.println("Element 'b' is in the stack: "+charStack.search('b'));
        System.out.println("Element 'k' is in the stack: "+charStack.search('k'));

        // Q1 c)
        MyStack<Integer> intStack = new MyStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        System.out.println(intStack);
        System.out.println("Element 6 is in the stack: "+intStack.search(6));
        System.out.println("Element 3 is in the stack: "+intStack.search(3));

    }
}
