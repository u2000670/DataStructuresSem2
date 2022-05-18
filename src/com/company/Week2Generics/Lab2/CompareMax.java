package com.company.Week2Generics.Lab2;

public class CompareMax <E>{

    public static <E extends Comparable<E>> E maximum(E a, E b, E c){

        if(a.compareTo(b) > 0 && a.compareTo(c)>0)
            return a;
        else if (b.compareTo(a) > 0 && b.compareTo(c)>0)
            return b;
        else if (c.compareTo(b) > 0 && c.compareTo(a)>0)
            return c;
        else
            return null;
    }
}
