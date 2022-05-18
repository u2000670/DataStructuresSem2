package com.company.Week3ADTsandBags.Tuto3.QN1;

import java.util.Scanner;

public class QN1_CandyMachine {

    /*
    displayItems()
    1.candies
    2. chips
    3.gum
    4.cookies

    enter the desired item's item no. to purchase:

    selected item: cookies  price: rm5.00
    Are you sure you want to purchase this item? Y/N:

    selected item: cookies  price: rm5.00
    How many would you like to purchase? (int) :

    getMoney(int money)
    if money < price
        "not enough"
    else
        return price - money

     */
    static Dispenser[] disps =
            {new Dispenser("candies", 4.0),
                    new Dispenser("chips", 3.5),
                    new Dispenser("gum", 0.8),
                    new Dispenser("cookies", 5.0)};

    static CashRegister cashRegister = new CashRegister();

    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
//        Map<Integer,String> map = new HashMap<>();
//        map.put()
        while (true) {
            displayAllItems();
            System.out.print("choose an item to purchase (-1 to exit): ");
            choice = sc.nextInt();
            if (choice == -1) {
                System.out.println("Thank you come again!");
                break;
            }
            System.out.println("\n" + disps[choice - 1]);

            System.out.print("are you sure with your purchase? (Y/N) :");
            char resp = sc.next().toUpperCase().charAt(0);
            if (resp == 'Y') {
                System.out.print("input money: ");
                double money = sc.nextDouble();
                double change = cashRegister.payment(money, disps[choice - 1].getPrice())   ;
                if (change != -1) {
                    System.out.println("dispensing . . . " + disps[choice - 1].releaseItem());
                    disps[choice - 1].holdIt();
                    System.out.printf("change >> RM%.2f", change);
                } else
                    System.out.println("there is not enough money to pay for the item!");
            }
        }
    }

    public static void displayAllItems() {
        int i = 1;
        for (Dispenser d : disps
        ) {
            System.out.println(i++ + ") " + d);
        }
    }


}

//holds the item in it & releases its item when it's purchased
//should a Dispenser NOT know the price of the item that it is holding?
class Dispenser implements Container<String ,Integer> {
    private String itemName;
    private double price;
    //    int amount;
    private boolean hold = true;

    public Dispenser(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
//        this.amount = amount;
    }

    public String releaseItem() {
        hold = false;           //let's item go
        return this.itemName;   //gives item
    }

    public double getPrice() {
        return this.price;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void holdIt() {
        this.hold = true;
    }

    public String toString() {
        return String.format("Item: %-8s \tPrice: RM%-5.2f", itemName, price);
    }

    @Override
    public void addItem(String s, Integer ints) {

    }

    @Override
    public void removeItem(String s) {

    }
}

//scans the selected items and calculates the change
class CashRegister {
    private double sum;

    public CashRegister() {
    }

    public double payment(double money, double itemPrice) {
        if (money < itemPrice)
            return -1;
        sum += itemPrice;
        double change = money - itemPrice;

        return change;

    }
}

/*
>customer gives money
>cashRegister gets money and price of selected item, calcs change
> disoenser releases item
> item'sDispenser.holdIt()
 */

