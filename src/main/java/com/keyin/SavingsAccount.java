package com.keyin;

public class SavingsAccount extends BankAccount {
    private static final double MONTHLY_INTEREST_RATE = 0.0025;

    public SavingsAccount(String accountHolderName, double initialBalance) {
        super(accountHolderName, initialBalance);
    }

    public SavingsAccount(String accountHolderName) {
        super(accountHolderName);
    }

    @Override
    public void chargeAccountFees() {
        this.balance += this.balance * MONTHLY_INTEREST_RATE;
    }
}
