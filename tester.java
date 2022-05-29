import java.util.Arrays;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stores store = new Stores(1);
		API api = new API();
		String globalLoc = api.toGlobal(store.getPosition());
		Stores store2 = new Stores(0);
		String globalLoc2 = api.toGlobal(store2.getPosition());
		System.out.println(globalLoc2);
		String[] strarr = new String[]{globalLoc, globalLoc2};
		System.out.println("Total Travel duration: "+ api.travelTime(strarr) + " mins");
		

	}

}
