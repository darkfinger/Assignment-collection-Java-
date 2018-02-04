/*
 * Prof: Dr. Dehkhoda
 * Student's Name: Kapanga David
 * Date: 06/05/2017
 * Assignment: CS 56 Project on singleton bank management
 * bank class code source
 */
package bankapplication;

import java.util.ArrayList;

/**
 *
 * @author kapanga_david_wa_kap
 */
//CREAT A singleton with the key word enum
//enum has a private constructor and can be created only once by calling INSTANCE in a static way 
public enum Bank {
    INSTANCE;
    //the code can be rewrite with a traditional singleton code, in that case we will need the static field bank under the following comment
    //static Bank bank;
    private ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();
    private ArrayList<Customer> customerList = new ArrayList<Customer>();

    /*if you want to impliment a singleton without enum keyword uncomment the following line and change enum to class */
        /*    private Bank() {
        //    }
        //    public static synchronized Bank getInstance(){
        //        if(bank==null){
        //            bank=new Bank();}
        //    return bank;}
        */
    
    //getter and setter
    public ArrayList<BankAccount> getAccountList() {
        return accountList;
    }
    public void setAccountList(ArrayList<BankAccount> accountList) {
        this.accountList = accountList;
    }
    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
    //aadCustomer method will add a new customer in the array
    public void addCustomer(Customer customer) {
        ArrayList<Customer> cust = this.getCustomerList();
        cust.add(customer);
        this.setCustomerList(cust);
    }
    //addAccount method will add a new customer in the array
    public void addAccount(BankAccount bankAccount) {
        ArrayList<BankAccount> accounts = this.getAccountList();
        accounts.add(bankAccount);
        this.setAccountList(accounts);
    }
}
