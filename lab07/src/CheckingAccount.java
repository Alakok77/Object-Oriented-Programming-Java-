public class CheckingAccount extends Account{
    private double credit;
    
    public CheckingAccount(){
        super(0, "");
        this.credit = 0;
        
    }
    public CheckingAccount(double balance, String name, double credit){
        super(balance, name);
        this.credit = credit;
    }
    
    public void setCredit(double credit){
        if (credit > 0){
            this.credit = credit;
        } else {
            System.out.println("Input number must be a positive integer.");
        }
    }
    
    public double getCredit(){
        return this.credit;
    }
    
    @Override
    public void withdraw(double a){
        if (a > 0 && balance - a > 0){
            this.balance -= a;
            System.out.println(a + " baht is withdrawn from " + this.name + " and your credit balance is " + this.credit + ".");
        } else if (a > 0 && balance - a < 0 && (balance - a) + credit > 0){
            this.balance = 0;
            this.credit -= (balance - a);
            System.out.println(a + " baht is withdrawn from " + this.name + " and your credit balance is " + this.credit + ".");
        } else if (a > 0 && balance - a < 0 && (balance - a) + credit < 0){
            System.out.println("Not enough money!");
        }
    }
    
    public void withdraw(String a){
        double x = Double.parseDouble(a);
        this.withdraw(x);
    }
    
    @Override
    public String toString(){
        return "The " + this.name + " account has " + this.balance + " baht and " + this.credit + " credits.";
    }
}
