package com.company.Week7Queues_PriorityQ.Lab7.QN3;

import com.company.Week7Queues_PriorityQ.Lab7.QN1.MyQueue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SeniorStocks {
    private static MyQueue<Integer> shares_q = new MyQueue<>();
    private static MyQueue<Double> prices_q = new MyQueue<>();
    private static double capital;

    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);
        String query;

        do {
            System.out.print("Enter your query (In format 'Buy / Sell x shares at $y each'): ");
            query = keyIn.nextLine();
            if (query.equalsIgnoreCase("exit"))
                break;

            String[] opt = query.split(" ");

            //opt[1]: amount of shares, opt[4]: price per share (transform string to int and double)
            int shares = Integer.parseInt(opt[1]);
            double price = Double.parseDouble(opt[4].replace("$", ""));

            if (opt[0].equalsIgnoreCase("buy")) {
                buyShare(shares, price);
            } else if (opt[0].equalsIgnoreCase("sell")) {
                sellShare(shares, price);
            } else
                throw new InputMismatchException("Wrong input!");
        } while (true);
    }

    private static void buyShare(int sharesToBuy, double buyPrice) {
        System.out.println("Buying now...");
        shares_q.enqueue(sharesToBuy);
        prices_q.enqueue(buyPrice);

        System.out.print("Queue for Shares: ");
//        shares_q.display();
        System.out.println(shares_q);

        System.out.print("Queue for Prices: ");
//        prices_q.display();
        System.out.println(prices_q);
    }

    private static void sellShare(int sharesToSell, double sellPrice) {
        System.out.println("Selling the shares now...");

        if (shares_q.isEmpty() || sharesToSell == 0) {
            System.out.println("No shares to sell!");
            return;
        }

        //TO AVOID NullPointerException when sharesToSell > shares_q.peek() and there's only 1 element in queue
        if (sharesToSell >= shares_q.peek() && shares_q.getSize() == 1) {
            capital += shares_q.peek() * (sellPrice - prices_q.dequeue());
            sharesToSell -= shares_q.dequeue(); //update the value while removing the shares queue

            System.out.print("Queue for Shares: ");
//            shares_q.display();
            System.out.println(shares_q);

            System.out.print("Queue for Prices: ");
//            prices_q.display();
            System.out.println(prices_q);

            System.out.println("Total Capital Gain/Loss: " + capital);
            return;
        }

        do {
            if (sharesToSell < shares_q.peek()) {
                shares_q.replace(0, shares_q.peek() - sharesToSell);
                capital += sharesToSell * (sellPrice - prices_q.peek());

                sharesToSell = 0; //update the value
            } else if (sharesToSell >= shares_q.peek()) {
                capital += shares_q.peek() * (sellPrice - prices_q.dequeue());

                sharesToSell -= shares_q.dequeue(); //update the value while removing the shares queue
            }
        } while (sharesToSell > 0);

        System.out.print("Queue for Shares: ");
//        shares_q.display();
        System.out.println(shares_q);

        System.out.print("Queue for Prices: ");
//        prices_q.display();
        System.out.println(shares_q);

        System.out.println("Total Capital Gain/Loss: " + capital);
    }
}

