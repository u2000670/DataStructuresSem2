package com.company.Week6Stack.Lab6;

import java.util.ArrayList;
import java.util.Stack;

public class Q4_Q5 {
    public static void main(String[] args) {

        //Q4 (max 15 chars?)
        System.out.println(palindrome("racecar"));
        System.out.println(palindrome("hannah"));
        System.out.println(palindrome("masamm"));

        //Q5
        ArrayList<Stack<Character>> rodz = new ArrayList<>();
        rodz.add(new Stack<>());    //rod 1
        rodz.add(new Stack<>());    //rod 2
        rodz.add(new Stack<>());    //rod 3
        //pushing elements to rod 1
        rodz.get(0).push('r');
        rodz.get(0).push('a');
        rodz.get(0).push('c');
        rodz.get(0).push('e');

        hanoi(rodz.get(0).size(), rodz.get(0), rodz.get(2), rodz.get(1));

        System.out.println("Rod 1: " + rodz.get(0));
        System.out.println("Rod 2: " + rodz.get(1));
        System.out.println("Rod 3: " + rodz.get(2));
    }

    //Q4
    public static boolean palindrome(String word) {
        Stack<Character> charStack = new Stack<>();

        if (word.length() <= 15) {
            for (int i = 0; i < word.length(); i++) {
                if (i >= word.length() / 2) {
                    if (i == word.length() / 2 && word.length() % 2 != 0)
                        continue;    //if i = median && odd number of elems
                    if (charStack.peek().equals(word.charAt(i)))
                        charStack.pop();
                } else
                    charStack.push(word.charAt(i));
            }
            return charStack.empty();
        }
        return false;
    }

    //Q5
    public static <E> void hanoi(int disks, Stack<E> sourceRod, Stack<E> targetRod, Stack<E> auxRod) {
        //sourceRod is empty or (targetRod or auxRod is not empty)
        /*
        if((!targetRod.empty() || !auxRod.empty()) || sourceRod.empty()) {
            System.out.println("invalid");
            return;
        }
        */
        if (disks != 0) {
            hanoi(disks - 1, sourceRod, auxRod, targetRod);
            targetRod.push(sourceRod.pop());
            hanoi(disks - 1, auxRod, targetRod, sourceRod);
        }
    }
}
