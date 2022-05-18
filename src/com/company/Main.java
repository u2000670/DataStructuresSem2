package com.company;

import java.util.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //generate random Num
        Random rand = new Random();
        int ans = 1;

        //while loop utk program
        while (ans == 1) {
            //range : minimum -> maximum
            //formula utk range = rand.nextInt(max-min) + minimum

            int actualNum = rand.nextInt(1000) + 1; // 0+1 -> 999+1 // 1 -> 1000
            //
            int guess = 0;

            //utk kite-kite je
            System.out.println("actualNum : " + actualNum);

            //game
            boolean dptBetul = false; //initialise
            int numOfGuess = 0;
            while (guess != -1) {
                System.out.print("Try to guess the number (enter -1 to exit): ");
                guess = sc.nextInt();

                //check klau guess =, > , < actualNum
                if (guess != -1) {
                    if (guess > actualNum) {
                        System.out.println("You're guess is too high! ");
                    } else if (guess < actualNum) { //termasuk kat sini
                        System.out.println("You're guess is too low!");
                    } else {
                        System.out.println("You're correct!");
                        guess = -1;    //utk keluar dari loop
                        dptBetul = true;
                    }
                    numOfGuess++;
                }
            }

            //check rank - dpt guess dgn betul
            if (dptBetul) {
                if (numOfGuess >= 1 && numOfGuess <= 10) {
                    System.out.println("Rank -> Grand Master ");
                } else if (numOfGuess <= 20) {
                    System.out.println("Rank -> Novice");
                } else {
                    System.out.println("Rank -> Newbie");
                }
            }
            System.out.print("Do you want to continue playing? (1 to continue/ enter any number to stop):");
            ans = sc.nextInt();
        }

        //guess == -1 , print  "you're guess is too low!" lps tu dpt keluar
//        System.out.println("num of guesses:" + i);
        System.out.println("outside loop");


    }

}
