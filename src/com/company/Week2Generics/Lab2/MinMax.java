package com.company.Week2Generics.Lab2;

public class MinMax <T> {

    public static <T extends Comparable<T>>String minmax(T[] arr1){
        T min=arr1[0], max=arr1[0];
        T currMin, currMax;

        for (int i = 0; i < arr1.length; i++) {

            if (arr1[i].compareTo(min) < 0)
                min = arr1[i];
            if(arr1[i].compareTo(max) > 0)
                max = arr1[i];
        }
        return "Min = "+min+ "\tMax = "+max;

    }

    public static void main(String[] args) {
        Integer[] intArray = {5, 3, 7, 1, 4, 9, 8, 2};
        String[] strArray = {"red", "blue", "orange", "tan"};

        System.out.println(minmax(intArray));
        System.out.println(minmax(strArray));
    }
}
