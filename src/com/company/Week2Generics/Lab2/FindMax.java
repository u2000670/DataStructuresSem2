package com.company.Week2Generics.Lab2;


public class FindMax<E> {

    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];
        for (int i = 0; i < list.length; i++) {
            if (list[i].compareTo(max) > 0)
                max = list[i];
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
/*this*/
/** this*/

class Circle implements Comparable<Circle> {

    private Double r;

    public Double getR() {
        return r;
    }

    public Circle(Double rad) {
        r = rad;
    }

    @Override
    public int compareTo(Circle c) {
        if (this.getR().compareTo(c.getR()) > 0)
            return 1;
        else if (this.getR().compareTo(c.getR()) < 0)
            return -1;
        else
            return 0;
    }
}
