package com.company.Week2Generics.Lab2;

public class StorePairGeneric <T> implements Comparable<T>{
    private T first, second;

    public StorePairGeneric(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }

    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() == this.getClass())
            return false;
        StorePairGeneric<T> spg = (StorePairGeneric<T>) obj;
        return this.getFirst() == spg.getFirst();
    }
    @Override
    public String toString() {
        return "first = " + first + " second = " + second;
    }


//    @Override //b?
//    public boolean equals(StorePairGeneric <T> obj) {
//        return this == obj;
//    }

//    @Override
    public int compareTo(Object o) {

        if(!(o instanceof StorePairGeneric<?>))
            return -1;
//        object1.getClass().equals( object2.getClass())
//        if(this.getFirst() < ((StorePairGeneric<T>) o).getFirst())
//            return 1;
        return 0;
    }

    public static void main(String[] args) {
//        Integer num = 8;
        String s = "right";
        String d = "left";
        boolean bool = 1 < 2;
        System.out.println(bool);
    }
}

