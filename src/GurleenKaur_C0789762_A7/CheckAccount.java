package GurleenKaur_C0789762_A7;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckAccount {
    static ArrayList<BankAccount> bankAccounts = new ArrayList();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;
        while (option != 5) {
            System.out.println("Enter 1 to create an account.");
            System.out.println("Enter 2 to deposit money.");
            System.out.println("Enter 3 to withdraw money.");
            System.out.println("Enter 4 to check Balance.");
            System.out.println("Enter 5 to quit");
            System.out.print("Select any option from the given one: ");
            option = s.nextInt();
            switch (option) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Kindly select a valid option!!");
                    break;
            }
        }
    }

    public static void createAccount() {
        long accountNo;
        String name;
        boolean exists = false;
        System.out.print("Enter the account number: ");
        accountNo = s.nextLong();
        while (String.valueOf(accountNo).length() != 5 || accountNo < 0) {
            System.out.println("Kindly enter a valid account number.");
            System.out.print("Try again! Enter the account number: ");
            accountNo = s.nextLong();
        }
        System.out.print("Enter the name of the account holder: ");
        s.nextLine();
        name = s.nextLine();
        if (bankAccounts.size() > 0) {
            for (BankAccount a : bankAccounts) {
                if (a.accountNumber == accountNo) {
                    exists = true;
                    System.out.println("Given bank account already exists.");
                }
            }
            if (!exists) {
                bankAccounts.add(new BankAccount(accountNo, name));
                System.out.println("Bank account created successfully!!");
            }
        }

        else {
            bankAccounts.add(new BankAccount(accountNo, name));
            System.out.println("Bank account created successfully!!");
        }
    }

    public static void depositMoney() {
        double amount;
        long accountNo;
        boolean exists = false;
        if (bankAccounts.size() > 0) {
            System.out.print("Enter the number of bank account: ");
            accountNo = s.nextLong();
            for (BankAccount a : bankAccounts) {
                if (a.accountNumber == accountNo) {
                    exists = true;
                    System.out.print("Enter the amount you want to deposit: ");
                    amount = s.nextDouble();
                    while (amount <= 0) {
                        System.out.println("Please enter a valid amount to be deposited in the account.");
                        System.out.print("Enter the amount you want to deposit: ");
                        amount = s.nextDouble();
                    }
                    a.deposit(amount);
                    System.out.println(a.toString());
                    System.out.println("Amount has been deposited to the account successfully");
                }
            }
        }
    }

    private static void withdrawMoney() {
        double amount;
        System.out.print("Enter the account number from which you want to withdraw the money: ");
        long accountNo = s.nextLong();
        for (BankAccount a : bankAccounts) {
            if (a.accountNumber == accountNo) {
                System.out.println(a.toString());
                System.out.print("Enter the amount of money you want to withdraw: ");
                amount = s.nextDouble();
                a.withdraw(amount);
                System.out.println(a.toString());
            }
        }
    }

    private static void checkBalance() {
        System.out.print("Enter the account number: ");
        long accountNo = s.nextLong();
        for (BankAccount a : bankAccounts) {
            if (a.accountNumber == accountNo) {
                System.out.println(a.toString());
            }
        }
    }

}

