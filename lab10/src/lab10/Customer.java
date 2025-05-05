package lab10;

public class Customer {
    private String firstName;
    private String lastName;
    private Account[] acct;
    private int numOfAccount;
    
    public Account getAccount(int index){
        return this.acct[index];
    }
    
    public void addAccount(Account acct){
        for (int i = 0; i <= 9; i++){
            if (this.acct[i] == null){
                this.acct[i] = acct;
                break;
            }
        }
        this.numOfAccount += 1;
    }
    
    public int getNumOfAccount(){
        return this.numOfAccount;
    }
   
    public Customer(){
        this("", "");
    }
    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        acct = new Account[5];
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
        return "Name: " + this.firstName + "LastName: " + this.lastName + "NumOfAccount: " + this.numOfAccount;
    }
    

    public boolean equals(Customer c){
        return c.firstName.equals(this.firstName) && c.lastName.equals(this.lastName);
    }
    
}
