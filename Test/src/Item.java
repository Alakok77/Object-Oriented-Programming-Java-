
import java.io.Serializable;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class Item implements Serializable{
    private int Id;
    private String name;
    private double price;
    private Date created_on;
    
    public Item(){
    }
    
    public Item(int Id, String name, double price, Date created_on){
        this.Id = Id;
        this.name = name;
        this.price = price;
        this.created_on = created_on;
    }
    
    public int getId(){
        return this.Id;
    }
    
    public void setId(int Id){
        this.Id = Id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public Date getCreated_on(){
        return this.created_on;
    }
    
    public void setCreated_on(Date c){
        this.created_on = c;
    }
}
