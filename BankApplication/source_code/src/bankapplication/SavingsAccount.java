/*
 * Prof: Dr. Dehkhoda
 * Student's Name: Kapanga David
 * Date: 06/05/2017
 * Assignment: CS 56 Project on singleton bank management
 * SavingAccount class code source
 */
package bankapplication;

import javafx.scene.control.Alert;

/**
 *
 * @author kapanga_david_wa_kap
 */
public class SavingsAccount extends BankAccount {
    //calling contructor data from parent
    public SavingsAccount(int accountNo, Customer owner, int balance) {
        super(accountNo,owner,balance);
    }
    //overide the deposite methode
    @Override
    public void deposite(int money, Customer customer) {
        int balance=money+customer.getSavingAccount().getBalance();
        customer.getSavingAccount().setBalance(balance);
    }
    //write the withdraw method for saving account
     public void withdraw(int needBalance,Customer customer)
     {
         //save the actual amount in a variable
         int actualBalance=customer.getSavingAccount().getBalance();
         //if enpugh amount then withdraw 
         if(actualBalance>=needBalance)
         {
             int balance = actualBalance-needBalance;
             //update the new balance
             customer.getSavingAccount().setBalance(balance);
         }
         //else show alert message
         else
         {
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Operation can't be performed");
            alert.setContentText("Not enough balance in the current account");
            alert.showAndWait();
         }
     }
}
