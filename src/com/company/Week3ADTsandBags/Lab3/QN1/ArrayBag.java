package com.company.Week3ADTsandBags.Lab3.QN1;

//final class?
public class ArrayBag<T> implements BagInterface<T> {
    T[] bag;
    int DEFAULT_CAPACITY;
    int numberOfEntries;

    public static void main(String[] args) {
        /*Object[] obj = new Object[4];
        for (Object o: obj
        ) {
            System.out.print(o+" ");

        }
        String[] nums = (String[]) new Object[4];
        String[] num2 = nums;
        for (String num: num2
             ) {
            System.out.print(num+" ");
        }*/
    }

    public ArrayBag() {
        this(25);
    }

    public ArrayBag(int capacity) {
        //how does this casting work?
        //ref : Week 3's code
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        if (numberOfEntries >= bag.length)
            return true;
        return false;
        //or return  (numberOfEntries >= bag.length);
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        if (!isFull()) {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            //or bag[numberOfEntries++] = newEntry;
            return true;
        } else {
            System.out.println("Bag is full!");
            return false;
        }

    }

    @Override
    public T remove() {
        if (isEmpty())
            return null;
        else {
            T removedElem = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            return removedElem;
        }
    }

    @Override
    public boolean remove(T anEntry) {

        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                T removedElem = bag[i];
                bag[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
//        Arrays.fill(bag, null);
//        this method^ is equivalent to the algo below

        for (int i = 0; i < numberOfEntries; i++) {
            bag[i] = null;
        }
        numberOfEntries = 0;
    }

    @Override
    public int getFrequencyOf(T anEntry) {

        int counter=0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                counter++;
            }

            /*  throws compilation error: i++ is never used
             *  reason: if anEntry is at index = 1 but  bag[0] != anEntry
             *  then, the method will go to *else* block and return -1 and the method ends there
             */
//            else{
//                return -1;
//            }

        }
        return counter;
    }

    //private (returnType) removeEntry(){
    // }

    @Override
    public boolean contains(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] arr = (T[]) new Object[numberOfEntries];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = bag[i];
        }

        return arr;
    }

    @Override
    public ArrayBag<T> union(ArrayBag<T> arrBag) {

        ArrayBag<T> unionedAB = new ArrayBag<>(bag.length * arrBag.bag.length);
        int combinedEntries = numberOfEntries + arrBag.numberOfEntries;
        for (int i = 0; i < combinedEntries; i++) {
            if (i < numberOfEntries) {
                unionedAB.add(bag[i]);
            } else {
                unionedAB.add(arrBag.bag[i]);
//                unionedAB.bag[i] = arrBag.bag[i];}
            }

        }

        return unionedAB;
    }

    @Override
    public ArrayBag<T> intersection(ArrayBag<T> arrBag) {

        ArrayBag<T> intersectioned = new ArrayBag<>(bag.length * arrBag.bag.length);
        int combinedEntries = numberOfEntries + arrBag.numberOfEntries;
        for (int i = 0; i < combinedEntries; i++) {
            if (i < numberOfEntries) {
//                unionedAB.add(bag[i]);
            } else {
//                unionedAB.add(arrBag.bag[i]);
//                unionedAB.bag[i] = arrBag.bag[i];}
            }

        }

        return intersectioned;
    }


}
