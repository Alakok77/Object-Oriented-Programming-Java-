
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class Student implements Serializable{
    private String name;
    private int ID;
    private int money;
    
    public Student(){
        this("", 0, 0);
    }
    
    public Student(String name, int ID,int money){
        this.name = name;
        this.ID = ID;
        this.money = money;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setID(int id){
        this.ID = id;
    }
    
    public int getID(){
        return this.ID;
    }
    
    public void setMoney(int money){
        this.money = money;
    }
    
    public int getMoney(){
        return this.money;
    }
}
