package Uap;

import Uap.app.BankAccount;

import java.util.Scanner;
import java.util.ArrayList;

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. View All Accounts");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Account ID: ");
                    String id = sc.next();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    accounts.add(new BankAccount(name, id, balance));
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account ID: ");
                    String depId = sc.next();
                    BankAccount depAcc = findAccount(accounts, depId);
                    if (depAcc != null) {
                        System.out.print("Enter deposit amount: ");
                        double depAmt = sc.nextDouble();
                        depAcc.deposit(depAmt);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account ID: ");
                    String withId = sc.next();
                    BankAccount withAcc = findAccount(accounts, withId);
                    if (withAcc != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withAmt = sc.nextDouble();
                        withAcc.withdraw(withAmt);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account ID: ");
                    String balId = sc.next();
                    BankAccount balAcc = findAccount(accounts, balId);
                    if (balAcc != null) {
                        System.out.println("Balance: " + balAcc.getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account ID: ");
                    String detId = sc.next();
                    BankAccount detAcc = findAccount(accounts, detId);
                    if (detAcc != null) {
                        System.out.println(detAcc);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                    } else {
                        for (BankAccount acc : accounts) {
                            System.out.println(acc);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static BankAccount findAccount(ArrayList<BankAccount> accounts, String id) {
        for (BankAccount acc : accounts) {
            if (acc.id.equals(id)) {
                return acc;
            }
        }
        return null;
    }
}
