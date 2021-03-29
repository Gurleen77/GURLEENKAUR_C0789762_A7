package GurleenKaur_C0789762_A7;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    //Class member variables
    long accountNumber;
    String holderName;
    double balance;

    //Parameterised Constructor
    public BankAccount(long accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
    }
    //Getters
    public long getAccountNo() { return accountNumber; }
    public String getAccountHolder() { return holderName; }
    public double getBalance() { return balance; }

    //Setters
    public void setAccountNo(long accountNo) { this.accountNumber = accountNo; }
    public void setAccountHolder(String accountHolder) { this.holderName = accountHolder; }
    public void setBalance(double balance) { this.balance = balance; }

    //Deposit
    void deposit(double money){ this.balance += money; }
    //Withdraw money
    void withdraw(double money){ this.balance -= money; }
    @Override
    public String toString(){
        //return String.format("%-20s : %d\n%-20s : %s\n%-20s : %.2f\n","Account No. ",accountNo,"Account Holder " ,accountHolder,"Balance ",this.balance);
        return String.format("Account Number:  " + accountNumber +"\nAccount Holder:   " + holderName + "\nAccount Balance:   " + this.balance);
    }
}
