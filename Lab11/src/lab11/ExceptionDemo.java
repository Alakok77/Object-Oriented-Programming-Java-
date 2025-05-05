/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab11;
import java.lang.Math;
/**
 *
 * @author lenovo
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        double a, b, c, x1, x2;
        
        try {
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
            c = Double.parseDouble(args[2]);
            
            x1 = ((-b) + Math.sqrt((b*b) - (4 * a * c)))/(2 * a);
            x2 = ((-b) - Math.sqrt((b*b) - (4 * a * c)))/(2 * a);
        
        System.out.println("X1 : " + x1);
        System.out.println("X2 : " + x2);
        } catch (NumberFormatException e){
            System.out.println("Please input data in number format only.");
        } catch (ArithmeticException e){
            System.out.println("division by zero.");
        } catch (Exception e){
            System.out.println("Please enter 3 numbers as a, b, and c, respectively.");
        }
        
        
    }
}
