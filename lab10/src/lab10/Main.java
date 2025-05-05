/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab10;

/**
 *
 * @author lenovo
 */
public class Main {
//    public static void main(String[] args) {
//        Bank myBank = new Bank();
//        Account acct1 = new Account(5000, "Sommai");
//        Account acct2 = new Account(3000, "Somchai");
//        Account acct3 = new Account(900, "Somsri");
//        
//        myBank.addAccount(acct1);
//        myBank.addAccount(acct2);
//        myBank.addAccount(acct3);
//        
//        
//        System.out.println("Number of Account: " + myBank.getNumAccount());
//        myBank.getAccount(0).showAccount();
//        System.out.println("Deposit 500...");
//        myBank.getAccount(0).deposit(500);
//        myBank.getAccount(0).showAccount();
//        System.out.println("Show all accounts");
//        System.out.println("==============================");
//        for(int i=0; i<myBank.getNumAccount(); i++){
//            myBank.getAccount(i).showAccount();
//        }
//
//    }
    
//    customer1
//    public static void main(String[] args) {
//        Customer cust = new Customer();
//        Account acct1 = new Account(5000, "a");
//        Account acct2 = new Account(3000, "b");
//        
//        cust.addAccount(acct1);
//        cust.addAccount(acct2);
//        
//        cust.getAccount(0).withdraw(3000);
//        cust.getAccount(1).deposit(3000);
//        System.out.println(cust);
//        for (int i = 0; i < cust.getNumOfAccount(); i++) {
//            cust.getAccount(i).showAccount();
//        }
//    }
    
//    customer2
    public static void main(String[] args) {
        Customer2 cust = new Customer2();
        Account acct1 = new Account(5000, "champ");
        Account acct2 = new Account(3000, "tonnam");
        
        cust.addAccount(acct1);
        cust.addAccount(acct2);
        
        cust.getAccount(0).withdraw(3000);
        cust.getAccount(1).deposit(3000);
        System.out.println(cust);
        for (int i = 0; i < cust.getNumOfAccount(); i++) {
            cust.getAccount(i).showAccount();
        }
    }
}
