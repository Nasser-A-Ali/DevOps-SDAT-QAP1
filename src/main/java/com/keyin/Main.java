package com.keyin;

public class Main {
    public static void main(String[] args) {
        BankAccount chequing1 = new ChequingAccount( "Chequing User 1", 100.00);
        System.out.println("Created account for '" + chequing1.getAccountHolderName() +  "' with account ID: " + chequing1.getAccountId());
        BankAccount chequing2 = new ChequingAccount("Chequing User 2");
        System.out.println("Created account for '" + chequing2.getAccountHolderName() +  "' with account ID: " + chequing2.getAccountId());


        BankAccount savings1 = new SavingsAccount("Savings User 1", 500.00);
        System.out.println("Created account for '" + savings1.getAccountHolderName() +  "' with account ID: " + savings1.getAccountId());
        BankAccount savings2 = new SavingsAccount("Savings User 2");
        System.out.println("Created account for '" + savings2.getAccountHolderName() +  "' with account ID: " + savings2.getAccountId());

        BankAccount credit1 = new CreditAccount("Credit User 1", 5.00, 2000.00);
        System.out.println("Created account for '" + credit1.getAccountHolderName() +  "' with account ID: " + credit1.getAccountId());
        BankAccount credit2 = new CreditAccount("Credit User 2", 5.00);
        System.out.println("Created account for '" + credit2.getAccountHolderName() +  "' with account ID: " + credit2.getAccountId());
        BankAccount credit3 = new CreditAccount("Credit User 3");
        System.out.println("Created account for '" + credit3.getAccountHolderName() +  "' with account ID: " + credit3.getAccountId());


        System.out.println("Number of Accounts Created: " + BankAccount.getNumberOfAccounts());

        System.out.println(chequing1.getBalance());
        System.out.println(chequing2.getBalance());

        System.out.println(savings1.getBalance());
        System.out.println(savings2.getBalance());

        System.out.println(credit1.getBalance());
        System.out.println(credit2.getBalance());
        System.out.println(credit3.getBalance());

        BankAccountService bankAccountService = new BankAccountService();
        bankAccountService.createBankAccount("chequing", "Service Chequing 1", 250.00);
//        bankAccountService.createBankAccount("chequing", "Service Chequing 2", 250.00, 2000.00);

        bankAccountService.createBankAccount("savings", "Service Savings 1", 550.00);
        bankAccountService.createBankAccount("credit", "Service Credit 1", 0.00, 750.00);

        System.out.println("Number of Accounts Created: " + BankAccount.getNumberOfAccounts());

        System.out.println("Deposit/Withdraw Test:");
        System.out.println(bankAccountService.getBalance(chequing1));
        bankAccountService.withdraw(chequing1, 15.75);
        System.out.println(bankAccountService.getBalance(chequing1));
        bankAccountService.deposit(chequing1, 10.50);
        System.out.println(bankAccountService.getBalance(chequing1));

        System.out.println("Account Fees Test:");
        System.out.println(bankAccountService.getBalance(chequing2));
        System.out.println(bankAccountService.getBalance(savings2));
        System.out.println(bankAccountService.getBalance(credit2));
        bankAccountService.chargeAccountFees(chequing2);
        bankAccountService.chargeAccountFees(savings2);
        bankAccountService.chargeAccountFees(credit2);
        System.out.println(bankAccountService.getBalance(chequing2));
        System.out.println(bankAccountService.getBalance(savings2));
        System.out.println(bankAccountService.getBalance(credit2));

        System.out.println("Number of Accounts Created: " + BankAccount.getNumberOfAccounts());

    }
}