package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(500f, 1);
    }
    @Test
    void deposit() {
        bankAccount.deposit(500f);
        assertEquals(1000f, bankAccount.getBalance());
    }

    @Test
    void withdraw() {
        bankAccount.withdraw(500f);
        assertEquals(0f, bankAccount.getBalance());
    }

    @Test
    void checkBalance() {
        assertFalse(bankAccount.checkBalance(600f), "Check balance failed");

    }

    @Test
    void cashbackPayment() {
        bankAccount.cashbackPayment(500f, 10);
        assertEquals(50f, bankAccount.getBalance());
    }

    @Test
    void transferMoney() {
        BankAccount dest = new BankAccount(500f, 2);
        bankAccount.transferMoney(500f, dest);
        assertAll(() -> assertEquals(1f, bankAccount.getBalance()),
                () -> assertEquals(1001f, dest.getBalance()));


    }
}