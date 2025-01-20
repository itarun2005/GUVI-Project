package com.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("123456789", "John Doe");
    }

    @Test
    public void testDeposit() {
        account.deposit(500.0);
        assertEquals(500.0, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.deposit(500.0);
        account.withdraw(200.0);
        assertEquals(300.0, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        account.deposit(100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200.0);
        });
        assertEquals("Insufficient funds. Current balance: 100.0", exception.getMessage());
    }

    @Test
    public void testDepositNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100.0);
        });
        assertEquals("Deposit amount must be positive.", exception.getMessage());
    }

    @Test
    public void testWithdrawNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-100.0);
        });
        assertEquals("Withdrawal amount must be positive.", exception.getMessage());
    }
}
