public class Pigeous extends Bird{

    @Override
    public void wingAttack(Animal a){
        a.setPower(a.getPower() - 5);
    }

    public void wingAttack(Animal a, int times){
        for (int i = 1; i <= times; i++){
            a.setPower(a.getPower() - 5);
        }
    }
    
    @Override
    public void fly(){
        System.out.println(this.getName() + " fly fly ....");
    }
    
    @Override
    public void eat(Food f){
        this.setPower((f.getPower() * 2) + this.getPower());
    }
    
    public Pigeous(){
        this("", 0);
    }
    
    public Pigeous(String name, int age){
        super(name, age);
        this.setPower(150);
    }
}
