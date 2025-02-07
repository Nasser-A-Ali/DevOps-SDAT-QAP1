package com.keyin;

public abstract class BankAccount {
    private static int numberOfAccounts;

    private final int accountId;
    private String accountHolderName;
    private double balance;

    protected BankAccount (String accountHolderName, double initialBalance){
        numberOfAccounts++;
        this.accountId = numberOfAccounts;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    protected BankAccount (String accountHolderName){
        numberOfAccounts++;
        this.accountId = numberOfAccounts;
        this.accountHolderName = accountHolderName;
        this.balance = 0.00;
    }

    public abstract void chargeAccountFees();

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds or invalid withdrawal amount");
        }
    }

    // TO BE TESTED ALONG W INCREMENTING ACCOUNT NUMBERS
    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void changeAccountHolderName(String newAccountHolderName) {
        this.accountHolderName = newAccountHolderName;
    }

}
