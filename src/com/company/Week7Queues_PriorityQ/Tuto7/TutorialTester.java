package com.company.Week7Queues_PriorityQ.Tuto7;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TutorialTester {
    public static void main(String[] args) {

        /*Scanner sc = new Scanner(System.in);

        while(sc.nextBoolean()){
            System.out.print(">> Input : ");
        }*/

        // QN3 T7b
        /*
        PriorityQueue<String> pQueue = new PriorityQueue<String>();
        pQueue.offer("C++");
        pQueue.offer("Python");
        pQueue.offer("Java");
        pQueue.offer("Fortran");
        System.out.println("peek() gives us: " + pQueue.peek()); //(a)
        System.out.println("The queue elements:"); //(b)
        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next()); //(b)
        pQueue.poll();
        System.out.println("After poll():"); //(c)
        Iterator<String> itr2 = pQueue.iterator();
        while (itr2.hasNext())
            System.out.println(itr2.next()); //(c)
        pQueue.remove("Java");
        System.out.println("After remove():"); //(d)
        Iterator<String> itr3 = pQueue.iterator();
        while (itr3.hasNext())
            System.out.println(itr3.next()); //(d)
        boolean b = pQueue.contains("Ruby");
        System.out.println("Priority queue contains Ruby or not?: " + b); //(e)
        Object[] arr = pQueue.toArray();
        System.out.println("Value in array: "); //(f)
        for (int i = 0; i < arr.length; i++)
            System.out.println("Value: " + arr[i].toString()); //(f)*/

        PriorityQueueComparator pqc=new PriorityQueueComparator();
        PriorityQueue<String> pq=new PriorityQueue<String>(5,pqc);
        pq.add("Jason");
        pq.add("Ali");
        pq.add("Muhamad");
        for(String s:pq) {
            System.out.println(s);
        }
    }
}
class PriorityQueueComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return -1;
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }
}

