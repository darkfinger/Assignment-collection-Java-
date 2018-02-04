/*
 * Prof: Dr. Dehkhoda
 * Student's Name: Kapanga David
 * Date: 06/05/2017
 * Assignment: CS 56 Project on singleton bank management
 * Customer class code source
 */
package bankapplication;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author kapanga_david_wa_kap
 */
public class Customer {
    private String id;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingAccount;
    private String name;
    
    //constructor
    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }    
    //setter and getter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public SavingsAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingsAccount savingAccount) {
        this.savingAccount = savingAccount;
    }
    
    //addCheckingAccount methode take a checking account as param and add this account to the customer
    public void addCheckingAccount(CheckingAccount checkingAccount)
    {
        //if the user has already an account then show message tha yhe user cant have 2 chk account
        if(this.checkingAccount==null)
        {
        setCheckingAccount(checkingAccount);
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Operation can't be performed");
            alert.setContentText("The user already has a checking account");
            alert.showAndWait();
        }
    }
    //addSavingAccount methode take a saving account as param and add this account to the customer
    public void addSavingAccount(SavingsAccount savingAccount)
    {
        //if the user has already a saving account then show message tha yhe user cant have 2 chk account
        if(this.savingAccount==null)
        {
        setSavingAccount(savingAccount);
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Operation can't be performed");
            alert.setContentText("The user already has a saving account");
            alert.showAndWait();
        }
    }  
}
