/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab10;

/**
 *
 * @author lenovo
 */
public class Bank {
    private Account[] acct;
    private int numAcct;
    
    public Bank(){
        this.acct = new Account[10];
    }
    
    public void addAccount(Account ac){
        for (int i = 0; i <= 9; i++){
            if (this.acct[i] == null){
                this.acct[i] = ac;
                break;
            }
        }
        this.numAcct += 1;
    }
    
    public Account getAccount(int index){
        return this.acct[index];
    }
    
    public int getNumAccount(){
        return this.numAcct;
    }
    
}
