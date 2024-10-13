package org.example;

public class BankAccount {
    private float balance;
    private final int userId;

    public BankAccount(float balance, int userId) {
        this.balance = balance;
        this.userId = userId;
    }

    public float getBalance() {
        return balance;
    }

    public void deposit(float amount) {
        balance += amount;
    }

    public void withdraw(float amount) {
        balance -= amount;
    }

    public boolean checkBalance(float amount) {
        return balance >= amount;
    }

    public void cashbackPayment(float spent, float percent) {
        if(!checkBalance(spent)) {return;}
        balance -= (spent - spent * percent / 100);
    }

    public void transferMoney(float amount, BankAccount destination) {
        if(!checkBalance(amount)) {return;}
        balance -= amount;
        destination.deposit(amount);
    }
}
