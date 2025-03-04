package com.onlinebanking;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        accounts = new HashMap<>();
        nextAccountNumber = 1000;  // Starting account number
    }

    // Create a new account and automatically assign a unique account number.
    public Account createAccount(String accountHolder, String password, double initialDeposit) {
        int accountNumber = nextAccountNumber++;
        Account newAccount = new Account(accountNumber, accountHolder, password, initialDeposit);
        accounts.put(accountNumber, newAccount);
        return newAccount;
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    // Verify credentials and return the account if login is successful.
    public Account login(int accountNumber, String password) {
        Account account = accounts.get(accountNumber);
        if (account != null && account.validatePassword(password)) {
            return account;
        }
        return null;
    }

    // Convenience methods for transactions.
    public boolean deposit(Account account, double amount) {
        if (account != null && amount > 0) {
            account.deposit(amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(Account account, double amount) {
        if (account != null) {
            return account.withdraw(amount);
        }
        return false;
    }

    public boolean transfer(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount != null && toAccount != null) {
            return fromAccount.transfer(toAccount, amount);
        }
        return false;
    }
}