package Uap.app;

public class BankAccount {
    public String name;
    public String id;
    public double balance;

    // Constructor
    public BankAccount(String name, String id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public void deposit(double depAmount) {
        if (depAmount > 0) {
            balance += depAmount;
            System.out.println("Successfully deposited " + depAmount);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public void withdraw(double withAmount) {
        if (withAmount > 0 && balance >= withAmount) {
            balance -= withAmount;
            System.out.println("Successfully withdrawn " + withAmount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String toString() {
        return "Account Holder: " + name + ", ID: " + id + ", Balance: " + balance;
    }
}