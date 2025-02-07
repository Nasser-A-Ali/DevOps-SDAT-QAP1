package com.keyin;

public class CreditAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.1999;

    private double creditLimit = 1000.00;

    public CreditAccount(String accountHolderName, double initialBalance, double creditLimit) {
        super(accountHolderName, initialBalance);
        this.creditLimit = creditLimit;
    }

    public CreditAccount(String accountHolderName, double initialBalance) {
        super(accountHolderName, initialBalance);
    }

    public CreditAccount(String accountHolderName){
        super(accountHolderName);
    }

    @Override
    public void chargeAccountFees() {
        this.balance += balance * INTEREST_RATE;
    }

    public double getTotalCreditLimit() {
        return creditLimit;
    }

    public double getRemainingCreditLimit() {
        return creditLimit - balance;
    }
}
