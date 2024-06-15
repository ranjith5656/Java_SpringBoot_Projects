package com.atmWithAccount;

import java.util.Scanner;

public class SimpleATM_WithArrays {
    public static void main(String[] args) {
        ATMWithArrays atm = new ATMWithArrays();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the ATM Simulator");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current balance: $" + atm.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 4:
                    atm.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println();

        } while (choice != 5);

        scanner.close();
    }
}

class ATMWithArrays {
    private double balance;
    private double[] transactions;
    private int transactionCount;

    public ATMWithArrays() {
        balance = 0;
        transactions = new double[100];
        transactionCount = 0;
    }

    public double checkBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions[transactionCount++] = amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            balance -= amount;
            transactions[transactionCount++] = -amount;
            System.out.println("Withdrawal successful!");
        }
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (int i = 0; i < transactionCount; i++) {
            if (transactions[i] > 0) {
                System.out.println("Deposit: $" + transactions[i]);
            } else {
                System.out.println("Withdraw: $" + (-transactions[i]));
            }
        }
    }
}
