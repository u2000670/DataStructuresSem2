package com.company.Week7Queues_PriorityQ.Lab7.QN3;

import com.company.Week7Queues_PriorityQ.Lab7.QN1.MyQueue;

import java.util.Scanner;

public class Stochs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue<Integer> sharesQ = new MyQueue<>();
        MyQueue<Integer> priceQ = new MyQueue<>();
        int sumShares = 0;

        while (true) {
            System.out.print("Enter your query (in format 'B (buy) / S (sell)  x (shares) y (price) ') : ");
            String input = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            int shares = 0, price;

            if (input.equalsIgnoreCase("exit"))break;

            for (int i = 0; i < input.length(); i++) {
                if (Character.isDigit(input.charAt(i))) {
                    sb.append(input.charAt(i));
                    continue;
                }
                if (!sb.isEmpty()) {
                    shares = Integer.parseInt(sb.toString());
                    if (input.charAt(0) == 'b' || input.charAt(0) == 'B') sumShares += shares;
                    sb.delete(0, sb.length() - 1);
                }
            }

            price = Integer.parseInt(sb.toString());

            if (input.charAt(0) == 'b' || input.charAt(0) == 'B') {
                System.out.println(" $~ buying ~$");
                sharesQ.enqueue(shares);
                priceQ.enqueue(price);
            } else if (input.charAt(0) == 's' || input.charAt(0) == 'S') {//selling
                if (shares <= sumShares) {
                    int gainOrLoss = 0;
                    int diffShares = 0;
                    System.out.println("$~ selling ~$");

                    while (diffShares >= 0) {
                        diffShares = shares - sharesQ.peek();
                        gainOrLoss += Math.min(shares, sharesQ.peek()) * (price - priceQ.peek());
                        if (diffShares < 0) {
                            sharesQ.replace(0, sharesQ.peek()-shares);
                            continue;
                        }
                        sharesQ.dequeue();
                        priceQ.dequeue();
                        shares = diffShares;
                    }
                    System.out.println("Total Capital Gain/Loss : " + gainOrLoss);
                } else {
                    System.out.println("Not enough shares to sell (?)");
                }
            } else {
                System.out.println(" *** Invalid Entry ***");
            }
            System.out.println("my shares: " + sharesQ);
            System.out.println("prices: " + priceQ);

        }
    }

}
