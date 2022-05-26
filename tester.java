import java.util.Arrays;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stores store = new Stores(3);
		System.out.println("name: "+store.getName());
		System.out.println("menu: "+ Arrays.toString(store.getItemList()));
		
		System.out.println("type: "+store.getType());
		System.out.println("position: "+store.getPosition()); // prints memory address of position
		System.out.println("Store description: "+store.getStoreDescription());
		System.out.println("business time: "+store.getBusinessTime());
		System.out.println("phone: "+store.getPhone());

	}

}
