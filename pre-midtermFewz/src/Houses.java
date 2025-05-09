public abstract class Houses {
    private String name;
    private String color;
    
    public Houses(){
        this("", "");
    }
    public Houses(String name, String color){
        this.name = name;
        this.color = color;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return "[House] : " + this.name + " , Color : " + this.color;
    }
}
