package com.keyin;

public class ChequingAccount extends BankAccount{
    private static final double MONTHLY_FEE = 16.95;

    public ChequingAccount(String accountHolderName, double initialBalance) {
        super(accountHolderName, initialBalance);
    }

    public ChequingAccount(String accountHolderName) {
        super(accountHolderName);
    }

    @Override
    public void chargeAccountFees() {
        this.balance -= MONTHLY_FEE;
    }
}
