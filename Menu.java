package food_delivery_platform;

import java.util.Scanner;

public class Menu {
    public double subTotal;
    public static double runningTotal;
    private static double itemPrice;
    static boolean ordering = true;
    static Scanner input = new Scanner(System.in);

    public static void menu() {
        System.out.println("Welcome \n1. Burger (NT75.00) \n2. Fries (NT30)\n3. Soda (NT20) \n4. Done");
    }

    public static double itemPrice(int foodItem) {
        if (foodItem == 1) {
            // burger= NT75.00
            System.out.println("You've ordered a burger");
            itemPrice = 75.00;
        }
        if (foodItem == 2) {
            // fries = NT30
            System.out.println("You've ordered fries");
            itemPrice = 30;
        }
        if (foodItem == 3) {
            // soda = NT20
            System.out.println("You've ordered a soda");
            itemPrice = 20;
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
        double subTotal = quantity * itemPrice;
        System.out.println("Subtotal: " + subTotal);
        return subTotal;
    }

    public static void done(double runningTotal) {
        ordering = false;
        System.out.println(runningTotal);
        System.out.println("Enjoy your meal");
    }

    public static void main(String[] args) {
    	  int menuOption;
    	  int foodItem = 0;
    	  input = new Scanner(System.in);
    	  double runningTotal=0;
    	  do{
    	    menu();
    	    menuOption = input.nextInt();
    	    switch(menuOption){
    	      case 1:
    	        foodItem = 1;
    	        runningTotal += itemPrice(foodItem);
    	        break;
    	      case 2:
    	        foodItem = 2;
    	        runningTotal += itemPrice(foodItem);
    	        break;
    	      case 3:
    	        foodItem = 3;
    	        runningTotal += itemPrice(foodItem);
    	        break;
    	      case 4:
    	        done(runningTotal);
    	        break;
    	      default:
    	        System.out.println("Invalid option.");
    	    }
    	  } while(ordering);
    	  System.out.println("Total amount: " + runningTotal);
    	}
}
