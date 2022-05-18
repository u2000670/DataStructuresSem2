package com.company.Week8Lab2;

public class nums {
    int number;
    int number2;
    static int sum = 9; //

    nums(int n, int m) {
        number = n;
        number2 = m;
    }

    public void increaseSum(){
        sum++;
        System.out.println(sum);
    }
    static void testStaticMethod(){
        System.out.println("its a me mario");
    }

}

