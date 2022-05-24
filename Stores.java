import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author yuhanchiang, deanchenn
 * @version 2022/5/23
 * @changes
 * added: JSONObject info
 * changed: setters,
 * 			business time -> JSONObject (might change later)
 * 
 */

public class Stores {
	//助教提供的商家資訊的規格定義
	
	private String account; //帳號
	private String password; //密碼
	private String email; //email
	private int discount_threshold; //滿額x元後可得到折扣
	private int discount_amount; //滿額後得到的折扣金額
	
	//店家其他資訊（提供json檔）
	
	private static JSONObject info;	//  New: info contains all the data of the store
	private String name;
	private Position position;
	private String phone;
	private String store_description;
	private String order_description;
	private String[] type;
	private Items[] itemList; //商品清單, retrieves one dish from menu
	private JSONObject businessTime; //營業時間
	
	private Orders[] orderList; // 訂單的list
	private Orders[] historyOrders; // 歷史訂單的list
	
	// constructor
	
	public Stores(int index) {
		this.info = Stores.Loader(index);  
		this.name = Stores.setName();
		this.position = Stores.setPosition();	// no problem writing here

		this.phone = Stores.setPhone();			// problem
		this.store_description = Stores.setStoreDescription();
		this.order_description = Stores.setOrderDescription();
		this.type = Stores.setType();			// problem
		this.itemList = Stores.setItemList();	// problem
		this.businessTime = Stores.setBusinessTime();
		
	}
	
	//getters
	public String getAccount() {
		return account;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public int getDiscountThreshold() {
		return discount_threshold;
	}
	public int getDiscountAmount() {
		return discount_amount;
	}
	public String getName() {
		return name;
	}
	public Position getPosition() {
		System.out.println("----------- this is the position ------------");
		System.out.println("address: "+this.position.getAddress());
		System.out.println("latitude: "+this.position.getLatitude());
		System.out.println("longitude: "+this.position.getLongtitude());
		return this.position;
	}
	public String getPhone() {
		return phone;
	}
	public String getStoreDescription() {
		return store_description;
	}
	public String getOrderDescription() {
		return order_description;
	}
	public String[] getType() {
		System.out.println("----------- this is the type ------------");
		for (int i = 0; i<this.type.length; i++) {
			System.out.println(this.type[i]);
		}
	    return this.type;
	}
	public Items[] getItemList() {
		System.out.println("----------- this is the menu ------------");
		for (int i = 0; i < this.itemList.length; i++) {
			Items out = this.itemList[i];
			System.out.println("price: " + out.getPrice());
			System.out.println("name: " + out.getName());
		}
	    return this.itemList;
	}
	public JSONObject getBusinessTime() {
		System.out.println("----------- this is buisness time ------------");
		JSONObject copy = this.businessTime;
		// iterate through the json object
		Set<String> set =  new LinkedHashSet<String>();  
		set.add("mon");
		set.add("tue");
		set.add("wed");
		set.add("thu");
		set.add("fri");
		set.add("sat");
		set.add("sun");
		Iterator keys = set.iterator();
		while(keys.hasNext()) {
			String str = (String) keys.next();
			System.out.println(str + " :" + copy.get(str));
;		}
		// 
	    return copy;
	}
	public Orders[] getOrderList() {
		Orders[] copy = new Orders[this.orderList.length];
	    System.arraycopy(this.orderList, 0, copy, 0, copy.length);
	    return copy;
	}
	public Orders[] getHistoryOrders() {
		Orders[] copy = new Orders[this.orderList.length];
	    System.arraycopy(this.orderList, 0, copy, 0, copy.length);
	    return copy;
	}
	
	
	//setters
	
	// loads specific store data 
	public static JSONObject Loader(int index) {	
		StoreReader stores = new StoreReader("stores_detail.json");
		JSONObject store = (JSONObject) stores.jsonarr.get(index) ;
		return store;		// returns json store
	}
	
	public static String setName() {
		String name = null;
		name = (String) info.get("name");
		
		return name;
	}
	
	// 
	public static Position setPosition() {
		Position position = new Position();
		JSONObject loc = (JSONObject) info.get("position");
		position.setAddress((String) loc.get("address"));
		position.setLatitude(loc.get("latitude"));
		position.setLongitude(loc.get("longitude"));
		return position;
	}
	// needs work
	
	// get phone number
	public static String setPhone() {
		String phone = null;
		phone = (String) info.get("phone");;
		return phone;
	}
	public static String setStoreDescription() {
		String store_description = null;
		store_description = (String) info.get("store_description");
		return store_description;
	}
	public static String setOrderDescription() {
		String order_description = null;
		order_description = (String) info.get("order_description");;
		return order_description;
	}
	public static String[] setType() {
		JSONArray emparr = (JSONArray) info.get("type");
		int size = emparr.size();
	    String[] copy = new String[size];
	    for (int i = 0; i < size; i++) {
	    	copy[i] = (String) emparr.get(i);
	    }
	    return copy;
	}
	
	
	public static Items[] setItemList() {
		JSONArray emparr = (JSONArray) info.get("menu");
		int size = emparr.size();
		Items[] items = new Items[size];
	    for (int i = 0; i < size; i++) {
	    	Items item = new Items();
	    	JSONObject obj = (JSONObject) emparr.get(i);
	    	item.setName((String) obj.get("name"));
	    	item.setPrice((String) obj.get("price"));
	    	items[i] = item;
	    }
		return items;
	}
	public static JSONObject setBusinessTime() {
		JSONObject empobj = (JSONObject) info.get("business_time");
	    return empobj;
	}
	public Orders[] setOrderList() {
		Orders[] copy = new Orders[this.orderList.length];
	    System.arraycopy(this.orderList, 0, copy, 0, copy.length);
	    return copy;
	}
	public Orders[] setHistoryOrders() {
		Orders[] copy = new Orders[this.orderList.length];
	    System.arraycopy(this.orderList, 0, copy, 0, copy.length);
	    return copy;
	}
	
	
}



/*
 * 問題：
 * 1.我們要做的是面向店家的程式對嗎？那如何和助教提供的json一起使用？
 * 2.前端的部分？
 */

