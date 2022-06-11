import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.Object;

import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

 
 public class RestaurantName {
	 
	 public static void main(String[] args) throws ParseException, JSONException, org.json.simple.parser.ParseException {
		 JSONParser parser = new JSONParser();
			FileReader fileReader;
			try {
				File file = new File("C:\\Users\\User\\eclipse-workspace\\FoodOrder\\src\\stores_detail.json");
				fileReader = new FileReader(file);
				JSONArray array = (JSONArray) parser.parse(fileReader);
				for(int i=0;i<(array).size();i++)
				{
					JSONObject obj =  (JSONObject)array.get(i);
					parseObject(obj);
					
				}
	 }
			catch(FileNotFoundException e)
			{
				System.out.println(e.getStackTrace()+ " :File Not Found");
			}
			catch(IOException e)
			{
				System.out.println(e.getStackTrace()+ " :IOException");
			}
	 }
			private static void parseObject(JSONObject obj) throws JSONException {
				String name = (String)obj.get("name");
				System.out.println("Name: "+ name);
				
				}
			
 }
	
