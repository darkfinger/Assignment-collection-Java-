/*
 * Prof: Dr. Dehkhoda
 * Student's Name: Kapanga David
 * Date: 06/05/2017
 * Assignment: CS 56 Project on singleton bank management
 * BankAccount class code source
 */
package bankapplication;

/**
 *
 * @author kapanga_david_wa_kap
 */
public abstract class BankAccount {
    private int accountNo;
    private Customer owner;
    private int balance=0;
    //constructor for the extend class
    public BankAccount(int accountNo, Customer owner, int balance) {
        this.accountNo = accountNo;
        this.owner = owner;
        this.balance = balance;
    }
    //getter and setter
    public int getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
    public Customer getOwner() {
        return owner;
    }
    public void setOwner(Customer owner) {
        this.owner = owner;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    //signature of the deposite methode, will be overide in the child class
    public abstract void deposite(int money, Customer customer);
    
}
