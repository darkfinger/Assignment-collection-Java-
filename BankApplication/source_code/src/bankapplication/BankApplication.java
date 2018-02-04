/*
 * Prof: Dr. Dehkhoda
 * Student's Name: Kapanga David
 * Date: 06/05/2017
 * Assignment: CS 56 Project on singleton bank management
 * main class code source
 */
package bankapplication;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author kapanga_david_wa_kap
 */
public class BankApplication extends Application {
    //making an instance of Bank class
    Bank bank=Bank.INSTANCE;
    //this account are for demo (id:a1 and a2)
    //********************************************************//
    //creating customer
    Customer c1=new Customer("a1","Lisa");    
    Customer c2=new Customer("a2","Kapanga");
    //creating account
    CheckingAccount chck1=new CheckingAccount(1515,c1,50);
    CheckingAccount chck2=new CheckingAccount(2020,c2,60);
    SavingsAccount sv1=new SavingsAccount(1500,c1,150);
    SavingsAccount sv2=new SavingsAccount(2000,c2,10);
    //******************************************************//
    
    @Override
    public void start(Stage primaryStage) {
        //adding previous account to aech customer
        c1.addCheckingAccount(chck1);
        c1.addSavingAccount(sv1);
        c2.addCheckingAccount(chck2);
        c2.addSavingAccount(sv2);
        //adding the customer and the account in the bank's list
        bank.addAccount(chck1);bank.addAccount(chck2);bank.addAccount(sv1);bank.addAccount(sv2);
        bank.addCustomer(c1);bank.addCustomer(c2);
        
        //adding Tab for admin and user inside the TabPane root
        TabPane root = new TabPane();
	root.getTabs().add(userTab());
	root.getTabs().add(adminTab());
	//creat and setting up the scene
	Scene scene = new Scene(root, 800, 800);
	primaryStage.setScene(scene);
        primaryStage.setTitle("Bank Application By Kapanga David (CS56 Assignment)");
        primaryStage.setResizable(false);
	primaryStage.show();
    }
    //creating tab for user
     private Tab userTab() { 
        Tab userTab = new Tab("User Panel"); 
        userTab.setClosable(false); 

        VBox panel = new VBox(30); 
        panel.setStyle("-fx-padding: 200;");
        Label idLabel = new Label("Id"); 
        TextField loadField=new TextField();
        Button load=new Button("Load user");
        Label nameLabel=new Label("Name");
        Label nameDisp=new Label("------");
        Label balanceLabel=new Label("Balance checking : ");
        Label balanceDisp=new Label("-----");
        Label balanceLabel2=new Label("Balance saving : ");
        Label balanceDisp2=new Label("-----");
        Label AmountLabel=new Label("Amount");
        TextField savingDepositField=new TextField();        
        Button Transaction=new Button("Transaction");
        Label transType=new Label("Transaction Type");
        Label erreur=new Label("----");
        ObservableList<String> options = FXCollections.observableArrayList(
                    "Deposite in Chechking",
                    "Withdraw from Checking",
                    "Deposite to Saving",
                    "Withdraw from Saving"
                );
            final ComboBox comboBox = new ComboBox(options);
            
        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String id=loadField.getText();
                if(!bank.getCustomerList().isEmpty()){
                for(Customer cust:bank.getCustomerList())
                {
                    if(id.equalsIgnoreCase(cust.getId()))
                    {
                        nameDisp.setText(cust.getName());
                        balanceDisp.setText(String.valueOf(cust.getCheckingAccount().getBalance()));
                        balanceDisp2.setText(String.valueOf(cust.getSavingAccount().getBalance()));
                        erreur.setText("");
                        break;
                    }
                    else
                    {
                        erreur.setText("No such customer. please ask admin to add this ID");
                        nameDisp.setText("------");balanceDisp.setText("------");balanceDisp2.setText("------");
                    }
                }
                }
                else{erreur.setText("No such customer. please ask admin to add this ID");nameDisp.setText("------");balanceDisp.setText("------");balanceDisp2.setText("------");}
            }});
        
        Transaction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            if((!nameDisp.getText().equalsIgnoreCase("------"))&& !loadField.getText().isEmpty() && !savingDepositField.getText().isEmpty())
            {
                int amt=(int) Integer.parseInt(savingDepositField.getText());
                
                for(Customer cust:bank.getCustomerList())
                {
                    if(cust.getId().equalsIgnoreCase(loadField.getText()) && cust.getName().equalsIgnoreCase(nameDisp.getText())){
                    if(comboBox.getValue().equals("Deposite in Chechking"))
                    {
                        cust.getCheckingAccount().deposite(amt, cust);
                        balanceDisp.setText(String.valueOf(cust.getCheckingAccount().getBalance()));
                    }
                    else if(comboBox.getValue().equals("Deposite to Saving"))
                    {
                        cust.getSavingAccount().deposite(amt, cust);
                        balanceDisp2.setText(String.valueOf(cust.getSavingAccount().getBalance()));
                    }
                     else if(comboBox.getValue().equals("Withdraw from Checking"))
                    {
                        cust.getCheckingAccount().withdraw(amt, cust);
                        balanceDisp.setText(String.valueOf(cust.getCheckingAccount().getBalance()));
                        balanceDisp2.setText(String.valueOf(cust.getSavingAccount().getBalance()));
                    }
                    else if(comboBox.getValue().equals("Withdraw from Saving"))
                    {
                        cust.getSavingAccount().withdraw(amt,cust);
                        balanceDisp2.setText(String.valueOf(cust.getSavingAccount().getBalance()));
                    }  
                    break;                  
                    }
                    
                }
            }
            }});
        
        HBox namePan = new HBox(10); 
        namePan.getChildren().addAll(nameLabel,nameDisp);
        HBox balPan = new HBox(10); 
        balPan.getChildren().addAll(balanceLabel,balanceDisp,balanceLabel2,balanceDisp2);
        HBox loadPan = new HBox(10); 
        loadPan.getChildren().addAll(idLabel,loadField,load);
        HBox typePan = new HBox(10);
        typePan.getChildren().addAll(transType,comboBox);
        HBox transacPan = new HBox(10);
        transacPan.getChildren().addAll(AmountLabel,savingDepositField);
        
        

        panel.getChildren().addAll(erreur,loadPan,namePan,balPan,typePan,transacPan,Transaction); 
        userTab.setContent(panel); 

        return userTab; 
       } 
  
  //creat tab for admin
 private Tab adminTab() { 
  Tab adminTab = new Tab("Admin Panel"); 
  adminTab.setClosable(false); 
   
  VBox vbox = new VBox(10); 
  vbox.setStyle("-fx-padding: 200;");
   
  Label l = new Label(); 
  Label error = new Label(); 
  l.setStyle("-fx-background-color: white; -fx-padding-left: 10px;"); 
  l.setText("UserName 'DEHKHODA' password '123' "); 
  Label name = new Label("Username"); 
  Label password = new Label("Password"); 
  TextField username=new TextField();
  TextField pass=new TextField();
  Button login=new Button("Log In");
  login.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //if password and user are correct then show admin pan
                if((username.getText().equalsIgnoreCase("DEHKHODA"))&&(pass.getText().equalsIgnoreCase("123")))
                {
                    error.setText("");                    
                    vbox.setVisible(false);
                    adminTab.setContent(showAdminPan());
                }
                else
                {
                    error.setText("Wrong identification, try again please");
                }
            }
        });
  vbox.getChildren().addAll(l,name,username,password,pass,login,error);
  adminTab.setContent(vbox); 
   
  return adminTab; 
 }
    //method that return the HBox to be shown once login as admin
    public HBox showAdminPan()
    {
        VBox vbox2 = new VBox(10); 
//        vbox2.setStyle("-fx-padding: 200;");
//        vbox2.setVisible(true);
        Label error=new Label();
        
        Label id=new Label("*ID");
        Label name=new Label("*Name");
        Label checkingAccount= new Label("Chacking account");
        Label savingAccount=new Label("Saving account");
        TextField idField=new TextField();
        TextField nameField=new TextField();
        TextField checkingAccountField= new TextField();
        TextField savingAccountField=new TextField();
        Button AddCust=new Button("Add Customer");
        AddCust.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                int errorcount=0;
                int chckAccount=0;
                int svAccount=0;
                if((!idField.getText().equalsIgnoreCase(""))&&(!nameField.getText().equalsIgnoreCase("")))
                {
                    Customer newCust=new Customer(idField.getText(),nameField.getText());
                    
                    if(!checkingAccountField.getText().equalsIgnoreCase("")){
                    try 
                    {
                        chckAccount=(int)Integer.parseInt(checkingAccountField.getText());
                        if(chckAccount>0)
                        {
                            CheckingAccount chkAcc=new CheckingAccount(chckAccount,newCust,0);
                            bank.addAccount(chkAcc);
                            newCust.addCheckingAccount(chkAcc);
                        }
                                                
                    }catch(Exception e)
                    {
                        error.setText("invalide checking Account");
                        errorcount+=1;
                    }
                    }
                    
                    if(!savingAccountField.getText().equalsIgnoreCase("")){
                    try 
                    {
                        svAccount=(int)Integer.parseInt(savingAccountField.getText());
                        if(svAccount>0)
                        {
                        SavingsAccount savAcc=new SavingsAccount(svAccount,newCust,0);
                        bank.addAccount(savAcc);
                        newCust.addSavingAccount(savAcc); 
                        }
                    }catch(Exception e)
                    {
                        error.setText("invalide saving Account ");
                         errorcount+=1;
                    }
                    }
                    if( errorcount==0)
                    { 
                        bank.addCustomer(newCust);
                        idField.setText("");nameField.setText(""); checkingAccountField.setText(""); savingAccountField.setText("");
                        error.setText("");
                    }
                    else
                    {
                         errorcount=0;
                    }
                   
                }
                else
                {
                    error.setText("Fill all riquired field (*)");
                }
            }
        });
        Label head1=new Label("Add Customer");
        vbox2.getChildren().addAll(head1,id,idField,name,nameField,checkingAccount,checkingAccountField,savingAccount,savingAccountField,AddCust,error);
        
        VBox deleteBox = new VBox(10); 
        //ComboBox<Customer> listCust=new ComboBox<Customer>(FXCollections.observableArrayList(bank.getCustomerList()));
        Label idCust=new Label("Enter Customer ID");
         Label err=new Label("------");
        TextField idCustField=new TextField();
        Button delete=new Button("delete user");        
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                //Customer custToDelete=listCust.getValue();
                for(int i=0;i<bank.getAccountList().size();i++)
                {
                    if(bank.getAccountList().get(i).getOwner().getId().equalsIgnoreCase(idCustField.getText()))
                    {
                        bank.getAccountList().remove(i);
                    }
                    
                }                
                for(int i=0;i<bank.getCustomerList().size();i++)
                {
                    if(bank.getCustomerList().get(i).getId().equalsIgnoreCase(idCustField.getText()))
                    {
                        bank.getCustomerList().remove(i);
                        err.setText("user deleted");
                        idCustField.setText("");
                    }
                    else
                    {
                        err.setText("user not find");
                    }
                }
            }
        });
        Label head=new Label("Delete Customer");
        deleteBox.getChildren().addAll(head,idCust,idCustField,delete,err);
        
        HBox pan=new HBox(70);        
        pan.setStyle("-fx-padding: 100;");
        pan.setVisible(true);
        pan.getChildren().addAll(vbox2,deleteBox);
        return pan;
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
