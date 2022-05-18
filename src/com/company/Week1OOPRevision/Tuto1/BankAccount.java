package com.company.Week1OOPRevision.Tuto1;

public class BankAccount implements Account {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    @java.lang.Override
    public int deposit(int x) {
        balance += x;
        return balance;
    }

    @java.lang.Override
    public Boolean withdraw(int y) {

        //wanna make sure that when balance - y, the new balance would not be 0
//        if(y <= balance){
        if(balance - y > 0){
            balance -= y;
            return true;
        }
        return false;
    }
}

interface Account {

    int deposit(int x);

    Boolean withdraw(int y);
}


