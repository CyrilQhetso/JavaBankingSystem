package com.onlinebanking;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountNumber;
    private String holderName;
    private String password;
    private double balance;
    private List<String> transactionHistory; // List to store transactions

    public Account(int accountNumber, String holderName, String password, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.password = password;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial deposit: $" + initialBalance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount + " | New Balance: $" + balance);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount + " | New Balance: $" + balance);
            return true;
        }
        return false;
    }

    public boolean transfer(Account toAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            toAccount.deposit(amount);
            transactionHistory.add("Transferred: $" + amount + " to Account #" + toAccount.getAccountNumber());
            toAccount.addTransaction("Received: $" + amount + " from Account #" + accountNumber);
            return true;
        }
        return false;
    }

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}