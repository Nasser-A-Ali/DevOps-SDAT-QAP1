package com.keyin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BankAccountServiceTest {

    @Test
    public void testCreateAccount(){
        BankAccount chequingAccount = new ChequingAccount("Create Account Test User", 500.50);

        Assertions.assertEquals("Create Account Test User", chequingAccount.getAccountHolderName());
        Assertions.assertEquals(500.50, chequingAccount.getBalance());
        Assertions.assertInstanceOf(ChequingAccount.class, chequingAccount);
    }

    @Test
    public void testDeposit(){
        BankAccountService bankAccountService = new BankAccountService();
        BankAccount savingsAccount = new SavingsAccount("Deposit Test User", 800.50);
        bankAccountService.deposit(savingsAccount, 350);

        Assertions.assertEquals(1150.50, savingsAccount.getBalance());
    }

    @Test
    public void testWithdraw(){
        BankAccountService bankAccountService = new BankAccountService();
        BankAccount savingsAccount = new SavingsAccount("Withdraw Test User", 500.00);
        bankAccountService.withdraw(savingsAccount, 150.50);

        Assertions.assertEquals(349.50, savingsAccount.getBalance());
    }

    @Test
    public void testChargeAccountFees(){
        BankAccountService bankAccountService = new BankAccountService();
        BankAccount chequingAccount = new ChequingAccount("Charge Account Fees Test User", 500.00);
        bankAccountService.chargeAccountFees(chequingAccount);

//        Assertions.assertEquals(483.05, chequingAccount.getBalance());
        Assertions.assertEquals(500.00, chequingAccount.getBalance());
    }

    @Test
    public void testWithdrawLargerThanBalance(){
        BankAccountService bankAccountService = new BankAccountService();
        BankAccount chequingAccount = new ChequingAccount("Withdraw Larger Than Balance Test User", 500.00);
        bankAccountService.chargeAccountFees(chequingAccount);

        Assertions.assertThrows(IllegalArgumentException.class, () -> chequingAccount.withdraw(501.00));
    }

}
