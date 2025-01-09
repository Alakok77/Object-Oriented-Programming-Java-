public class Food {
    private static double price = 50;
    private static final int energy = 10;
    
    public static int getEnergy(){
        return energy;
    }
    
    public static double getPrice(){
        return price;
    }
    
    public static void setPrice(double price){
        if (price > Food.price){
            Food.price = price;
        } else {
            System.out.println("Cannot update the food price.");
        }
    }
}
