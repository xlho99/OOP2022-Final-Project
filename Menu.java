import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;

public class Menu {
	    static Items[] Menu = new Items[100];
	    static boolean ordering = true;
	    static Scanner input = new Scanner(System.in);
	
	    public static void displayMenu() {
	    	Stores store = new Stores(3);
			System.out.println("name: "+store.getName());
			System.out.println("menu: "+ store.getItemList());
			
	    }
	    
	  
	    public static void main(String[] args) {
	    	Stores store = new Stores(3);
	    
	    	for(int i=0; i< store.getName().length(); i++){
	    		
	    		Menu[i] = new Items();
	    		Menu[i].name = getName()[i];
	    		Menu[i].price = price[i];
	    		
	    }
}
}
	


