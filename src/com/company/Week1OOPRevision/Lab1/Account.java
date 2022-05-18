package com.company.Week1OOPRevision.Lab1;

import java.util.Date;

public class Account {

    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    final private Date dateCreated = new Date();

    public Account(){

    }
    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
    }

    public double getMonthlyInterestRate(){
        return ((annualInterestRate/12));
    }
    public double getMonthlyInterest(){
        return (balance * (getMonthlyInterestRate()/100));
    }
    public void withdraw(double money){
        balance -= money;
//        return money;
    }
    public void deposit(double money){
        balance += money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public static void main(String[] args) {

        Account acc = new Account(1122,20000);
        Account.setAnnualInterestRate(4.5);
        acc.withdraw(2500);
        acc.deposit(3000);

        System.out.println("Balance: "+acc.getBalance());
        System.out.println("Monthly Interest: "+acc.getMonthlyInterest());
        System.out.println("Date Created: "+acc.getDateCreated());

    }


}
