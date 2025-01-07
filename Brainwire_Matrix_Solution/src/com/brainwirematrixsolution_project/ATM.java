package com.brainwirematrixsolution_project;

import java.util.Scanner;

public class ATM {
    private double balance;
    private String accountHolderName;
    private int pin;

    public ATM(String accountHolderName, double initialBalance, int pin) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.pin = pin;
    }

    // Display the main menu
    private void showMenu() {
        System.out.println("\n--- Welcome to the ATM ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");
    }

    // Check balance
    private void checkBalance() {
        System.out.printf("\nYour current balance is: $%.2f\n", balance);
    }

    // Deposit money
    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("\nYou successfully deposited $%.2f\n", amount);
            System.out.printf("Your new balance is: $%.2f\n", balance);
        } else {
            System.out.println("\nDeposit amount must be positive.");
        }
    }

    // Withdraw money
    private void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("\nYou successfully withdrew $%.2f\n", amount);
            System.out.printf("Your new balance is: $%.2f\n", balance);
        } else if (amount > balance) {
            System.out.println("\nInsufficient funds. Please try a smaller amount.");
        } else {
            System.out.println("\nWithdrawal amount must be positive.");
        }
    }

    // Verify the PIN
    private boolean verifyPin(int enteredPin) {
        return enteredPin == pin;
    }

    // Run the ATM
    public void start() {
        Scanner scanner = new Scanner(System.in);

        // Prompt for PIN
        System.out.print("Enter your 4-digit PIN: ");
        int enteredPin = scanner.nextInt();

        if (!verifyPin(enteredPin)) {
            System.out.println("\nIncorrect PIN. Access denied.");
            return;
        }

        System.out.println("\nWelcome, " + accountHolderName + "!");

        boolean continueUsingATM = true;

        while (continueUsingATM) {
            showMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("\nEnter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("\nEnter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("\nThank you for using the ATM. Have a great day!");
                    continueUsingATM = false;
                    break;
                default:
                    System.out.println("\nInvalid option. Please choose again.");
            }
        }

        scanner.close();
    }

    // Main method to initialize the ATM and start it
    public static void main(String[] args) {
        ATM atm = new ATM("John Doe", 1000.00, 1234);
        atm.start();
    }
}

