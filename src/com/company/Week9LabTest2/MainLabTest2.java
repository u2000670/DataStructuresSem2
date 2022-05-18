package com.company.Week9LabTest2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MainLabTest2 {
    public static void main(String... args ){
        PriorityQueueComparator pqc=new PriorityQueueComparator();
        PriorityQueue<String> pq=new PriorityQueue<>(5,pqc);
        pq.add("Jason");
        pq.add("Ali");
        pq.add("Muhamad");
        int qsize = pq.size();
        for(int i=0; i < qsize; i++){
            String s = pq.poll();
            System.out.println(s);
        }
        System.out.println(pq);
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
