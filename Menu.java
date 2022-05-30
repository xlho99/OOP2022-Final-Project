package food_delivery_platform;
/**
 * 
 * @author xlho99
 * @version ver.0
 * @changes
 * added: 
 * changed: 
 * 
 */

import java.util.Scanner;

public class Menu {
	
public double subTotal;
public static double runningTotal;
private static double itemPrice;
static boolean ordering = true;
static Scanner input = new Scanner(System.in);

/**
 * 
 * menu still in process
 * 
 */
public static void menu(){
    System.out.println("1.(40) \n2.(25)\n3.(10) \n4. Done");
}
public static double itemPrice(int foodItem) {
    if (foodItem == 1) {
       
        System.out.println("You've ordered a burger");
        itemPrice = 40;
    }
    if (foodItem == 2) {
        
        System.out.println("You've ordered fries");
        itemPrice = 25;
    }
    if (foodItem == 3) {
        
        System.out.println("You've ordered a soda");
        itemPrice = 10;
    }
    quantity();
    return itemPrice;
} 

public static double quantity() {
    System.out.println("Enter quantity");       
    double quantity = input.nextDouble();
    subTotal(quantity, itemPrice);
    return quantity;
 }
public static double subTotal(double quantity, double itemPrice) {
    double subTotal = quantity*itemPrice;
    System.out.println("Subtotal: "+ subTotal);
    runningTotal += subTotal;
    return subTotal;
}
public static void done(){
    ordering = false;
    System.out.println(runningTotal);
    System.out.println("Enjoy your meal");
}
public static void main(String[] args) {
    int menuOption;
    int foodItem = 0;
    input = new Scanner(System.in); 
    do{
        
        menu();
        menuOption = input.nextInt();    
        switch(menuOption){
            case 1:
                foodItem = 1;
                itemPrice(foodItem);
                break;
            case 2:
                foodItem = 2;
                itemPrice(foodItem);
                break;
            case 3:
                foodItem = 3;
                itemPrice(foodItem);
                break;
            case 4:
                done();
                break;      
            default:
                System.out.println("Invalid option.");
        }

    } while(ordering); {
}
}
}
