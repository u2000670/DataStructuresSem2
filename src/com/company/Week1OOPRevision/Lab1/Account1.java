package com.company.Week1OOPRevision.Lab1;

import java.util.ArrayList;
import java.util.Date;

public class Account1 extends Account{


    String name = "";
    ArrayList<Transaction> transactions;

    public Account1(String name, int id, double balance) {
        super(id, balance);
        this.transactions = new ArrayList<>();
        this.name = name;
    }

    //over-something? overload
    public void withdraw(double money, String desc) {
        setBalance(getBalance() - money);
        transactions.add(new Transaction('W', money, getBalance(), desc));
    }


    public void deposit(double money, String desc) {
        setBalance(getBalance() + money);
        transactions.add(new Transaction('D', money, getBalance(), desc));

    }

}

class Transaction {

    private final Date date = new Date();
    private final char type;
    private final double amount;
    private final double balance;
    private String description;

    public Transaction(char type, double amount, double balance, String description) {

        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;

//        System.out.println("Type: "+type);
//        System.out.println("Amount: "+amount);
//        System.out.println("Balance: "+balance);
//        System.out.println("Description: "+description);
//        System.out.println("Date: "+date);
    }

    @Override
    public String toString(){
        return "Type: "+type
                +"\nAmount: "+amount
                +"\nBalance: "+balance
                +"\nDescription: "+description
                +"\nDate: "+date;
    }

    public Date getDate() {
        return date;
    }

    //    public void setDate(Date date) {
//        this.date = date;
//    }
    public char getType() {
        return type;
    }

    //    public void setType(char type) {
//        this.type = type;
//    }
    public double getAmount() {
        return amount;
    }

    //    public void setAmount(double amount) {
//        this.amount = amount;
//    }
    public double getBalance() {
        return balance;
    }

    //    public void setBalance(double balance) {
//        this.balance = balance;
//    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

class test {
    public static void main(String[] args) {

        Account1 acc1 = new Account1("George", 1122, 1000);
        Account.setAnnualInterestRate(1.5);

        acc1.deposit(30, "Dari Mak Ngah");
        acc1.deposit(40, "Dari Mak Kiah");
        acc1.deposit(50, "Dari Pak Abu");

        acc1.withdraw(5, "anak saudara sulung");
        acc1.withdraw(4, "anak saudara tengah");
        acc1.withdraw(2, "anak saudara bongsu");

        System.out.println("Account Holder name: "+acc1.name);
        System.out.println("Interest Rate: "+(acc1.getMonthlyInterestRate()*100)+"%");
        System.out.println("Balance: "+acc1.getBalance());

        System.out.println("\n$$$$$$$ Transactions $$$$$$$\n");
        for (int i = 0; i < acc1.transactions.size(); i++) {
            System.out.println("Transaction "+(i+1));
            System.out.println(acc1.transactions.get(i));
            System.out.println();

        }

    }
}
