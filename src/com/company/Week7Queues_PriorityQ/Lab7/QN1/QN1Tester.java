package com.company.Week7Queues_PriorityQ.Lab7.QN1;

public class QN1Tester {
    public static void main(String[] args) {
        String[] fruitQ = {"Durian", "Blueberry"};      //a)
        MyQueue<String> queue = new MyQueue<>(fruitQ);
        queue.enqueue("Apple");     //b)
        queue.enqueue("Orange");
        queue.enqueue("Grapes");
        queue.enqueue("Cherry");
        System.out.println(queue);     //c)
        System.out.println("Top item : "+queue.peek()); //d)

        //test 1 : if an array with null values is passed
        /*
        String[] emptyArr= new String[10];
        MyQueue<String> testQueue = new MyQueue<>(emptyArr);
        testQueue.enqueue("anElement");
        System.out.println("testQueue : "+testQueue);
        */
        //end of test 1

        System.out.println("Deleting . . . : "+queue.dequeue());
        System.out.println("3rd item in queue: "+queue.getElement(2));
        System.out.println("Cherry is in the queue: "+queue.contains("Cherry"));
        System.out.println("Durian is in the queue: "+queue.contains("Durian"));

        if (!queue.isEmpty())
            System.out.println(queue);


    }
}

