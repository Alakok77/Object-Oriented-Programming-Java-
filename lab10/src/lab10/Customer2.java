package lab10;

import java.util.*;

public class Customer2 {
    private String firstName;
    private String lastName;
    private ArrayList acct;
    
    public Account getAccount(int index){
        return (Account) this.acct.get(index);
    }
    
    public void addAccount(Account acct){
        this.acct.add(acct);
    }
    
    public int getNumOfAccount(){
        return this.acct.size();
    }
   
    public Customer2(){
        this("", "");
    }
    public Customer2(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        acct = new ArrayList();
    }

    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
   
    public String getFirstName(){
        return this.firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    
    @Override
    public String toString(){
        return "Name: " + this.firstName + "LastName: " + this.lastName + "NumOfAccount: " + this.acct.size();
    }
    

    public boolean equals(Customer2 c){
        return c.firstName.equals(this.firstName) && c.lastName.equals(this.lastName);
    }
    
}
