package com.company.Week7Queues_PriorityQ.Lab7.QN2;

import com.company.Week7Queues_PriorityQ.Lab7.QN1.MyQueue;

import java.util.Scanner;

public class QueuePalindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(">>> Palindrome Checker <<< (enter 'exit' to end the program)");
        while(true){
            System.out.println();
            System.out.print("Enter a string >> ");
            String str = sc.nextLine();
            if(str.equalsIgnoreCase("exit"))
                break;
            System.out.println(palindrome(str));
        }
    }

    static boolean palindrome(String s) {
        s = s.toLowerCase();

        MyQueue<Character> q = new MyQueue<>();
        for (int i = 0; i < s.length() / 2; i++) {
            q.enqueue(s.charAt(i));
        }
        int sameChar = 0;

        for (int i = s.length() - 1; i >= s.length() / 2; i--) {
            if (!q.isEmpty()) {
                if (q.dequeue().equals(s.charAt(i)))
                    sameChar++;
            }
        }
        return sameChar == s.length() / 2;
    }
}
