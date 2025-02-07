package com.keyin;

public class BankAccountService {
    public BankAccount createBankAccount (String bankAccountType, String accountHolderName, double initialBalance) {
        switch (bankAccountType.toLowerCase()){
            case "chequing":
                return new ChequingAccount(accountHolderName, initialBalance);
            case "savings":
                return new SavingsAccount(accountHolderName, initialBalance);
            case "credit":
                return new CreditAccount(accountHolderName, initialBalance);
            default:
                throw new IllegalArgumentException("Account type must be: 'chequing', 'savings', or 'credit'. Please try again.");
        }
    }

    public BankAccount createBankAccount (String bankAccountType, String accountHolderName) {
        switch (bankAccountType.toLowerCase()){
            case "chequing":
                return new ChequingAccount(accountHolderName);
            case "savings":
                return new SavingsAccount(accountHolderName);
            case "credit":
                return new CreditAccount(accountHolderName);
            default:
                throw new IllegalArgumentException("Account type must be: 'chequing', 'savings', or 'credit'. Please try again.");
        }
    }

    public BankAccount createBankAccount (String bankAccountType, String accountHolderName, double initialBalance, double creditLimit){
        if (!bankAccountType.equalsIgnoreCase("credit")){
            throw new IllegalArgumentException("Credit limit can only be provided for 'credit' accounts only. Please choose a different account type.");
        } else {
            return new CreditAccount(accountHolderName, initialBalance, creditLimit);
        }
    }

    public void deposit(BankAccount account, double amountToDeposit){
        account.deposit(amountToDeposit);
    }

    public void withdraw(BankAccount account, double amountToWithdraw){
        account.withdraw(amountToWithdraw);
    }

    public void chargeAccountFees(BankAccount account){
        account.chargeAccountFees();
    }

    public double getBalance(BankAccount account){
        return account.getBalance();
    }

}
