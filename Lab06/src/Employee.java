public class Employee {
    private int energy;
    private String name;
    private Wallet wallet;
    private static String nationality = "Thai";
    
    public int getEnergy(){
        return energy;
    }
    
    public String getName(){
        return name;
    }
    
    public static String getNationality(){
        return nationality;
    }
    
    public Wallet getWallet(){
        return wallet;
    }
    
    public void setEnergy(int energy){
        this.energy = energy;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public static void setNationality(String nationality){
        Employee.nationality = nationality;
    }
    
    public void setWallet(Wallet wallet){
        this.wallet = wallet;
    }
    
    public boolean buyFood(Seller s){
        Food o = s.sell(this);
        if (o != null){
            this.eat(o);
            return true;
        } else {
            return false;
        }
    }
    
    public void eat(Food f){
        this.energy += f.getEnergy();
    }
    
    public boolean equals(Employee e){
        return e.name.equals(this.name);
    }
    
    @Override
    public String toString(){
        return "My name is " + this.name + ". \n"
                + "I have " + this.energy + " energy left.\n"
                + "I have a balance of " + this.getWallet().getBalance() + " baht.";
    }
}



