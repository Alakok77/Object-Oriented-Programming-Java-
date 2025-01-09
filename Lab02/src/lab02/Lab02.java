/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab02;

/**
 *
 * @author lenovo
 */
import java.util.*;

public class Lab02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please insert your monitor size : ");
        int size = input.nextInt();
        System.out.print("Do you want DVD-ROM? 1 is Yes / 0 is No : ");
        int optionDVD = input.nextInt();
        System.out.print("Do you want printer? 1 is Yes / 0 is No : ");
        int optionPrinter = input.nextInt();
        double totalPrice = 375.99;
        
        System.out.println("==========your order==========");
        System.out.println("Computer >>> " + totalPrice + "$");
        
        if (size == 38) {
            totalPrice += 75.99;
            System.out.println("38'Monitor >>> 75.99$");
        } else if (size == 43) {
            totalPrice += 99.99;
            System.out.println("43'Monitor >>> 99.99$");
        }

        if (optionDVD == 1){
            totalPrice += 65.99;
            System.out.println("DVD-ROM >>> 65.99$");
        }
        
        if (optionPrinter == 1){
            totalPrice += 125.00;
            System.out.println("Printer >>> 125.00$");
        }
        
        System.out.println("========== Total Price >>> " + totalPrice + "$ ==========");
    }

}
