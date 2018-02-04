/*
 * Prof: Dr. Dehkhoda
 * Student's Name: Kapanga David
 * Date: 06/05/2017
 * Assignment: CS 56 Project on singleton bank management
 * checkingAccount class code source
 */
package bankapplication;

import javafx.scene.control.Alert;

/**
 *
 * @author kapanga_david_wa_kap
 */
public class CheckingAccount extends BankAccount {
    
    //calling constructor data from parent
    public CheckingAccount(int accountNo, Customer owner, int balance) {
        super(accountNo,owner,balance);
    }
    //overiding the deposite checking
    @Override
    public void deposite(int money, Customer customer) {
        int balance=money+customer.getCheckingAccount().getBalance();
        customer.getCheckingAccount().setBalance(balance);
    }
    //withdraw methode for checking account
    public void withdraw(int needBalance,Customer customer)
     {
         //save the customer current balance to variable, for both account
         int actualBalance=customer.getCheckingAccount().getBalance();
         int balanceInSaving=customer.getSavingAccount().getBalance();
         //if the balance needed in less or aqual the current checking account balance then withdraw from checking
         if(actualBalance>=needBalance)
         {
             int balance = actualBalance-needBalance;
             customer.getCheckingAccount().setBalance(balance);
         }
         //or if the total of both amount are superior or equal the needed balance then withdraw from checking and the rest from saving
         else if(actualBalance+balanceInSaving>=needBalance)
         {
             int balance=0;
             customer.getCheckingAccount().setBalance(balance);
             balance=needBalance-actualBalance;
             customer.getSavingAccount().setBalance(balanceInSaving-balance);
         }
         //otherwise show message alert, not enough balance in both account
         else
         {
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Operation can't be performed");
            alert.setContentText("Not enough balance in the Both account");
            alert.showAndWait();
         }
     }
}
