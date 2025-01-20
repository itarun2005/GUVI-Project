package com.bank;

public class BankAccount {
    private String accountNumber; // Unique identifier for the bank account
    private String accountHolderName; // Name of the account holder
    private double balance; // Current balance of the account

    // Constructor to initialize a new bank account
    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0; // Initial balance is set to 0
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount; // Increase the balance by the deposit amount
        System.out.println("Deposited: " + amount + ". New balance: " + balance);
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds. Current balance: " + balance);
        }
        balance -= amount; // Decrease the balance by the withdrawal amount
        System.out.println("Withdrew: " + amount + ". New balance: " + balance);
    }

    // Method to get the current balance of the account
    public double getBalance() {
        return balance; // Return the current balance
    }

    // Method to get the account number
    public String getAccountNumber() {
        return accountNumber; // Return the account number
    }

    // Method to get the account holder's name
    public String getAccountHolderName() {
        return accountHolderName; // Return the account holder's name
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}
