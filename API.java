import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * 
 * @author yuhanchiang
 * @version 2022/5/27
 */

public class API {
	private Position[] storeLocation;
	private String[] globalStoreloc;	// store position in global code
	private String globalagentloc;		// delivery man position in global code
	private double time;			// trasnportation time
	
	public API() {
		this.globalagentloc = "7QQ33G8H%2BRX5";		// 先預設
	}
	
	// this method converts the latitude and longitude of the position to global code
	// the output is suited for api request format 
	public String toGlobal(Position storePosition){
		
		String globalLoc = null;
		String lat = Double.toString(storePosition.getLatitude());		// latitude
		String lng = Double.toString(storePosition.getLongtitude());	// longitude
		String APIkey = "AIzaSyDoUlM151mrLPY77zLQKSzcUM89NzpJOfs";
		String message = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lng+"&key="+APIkey;
		
		try {
			
			URL url = new URL(message);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();
                
                //JSON simple library Setup with Maven is used to convert strings to JSON
                JSONParser parse = new JSONParser();
                JSONObject dataObject = (JSONObject) parse.parse(String.valueOf(informationString));

                // get stuff in plus code
                JSONObject plusCode = (JSONObject) dataObject.get("plus_code");
                String str = (String) plusCode.get("global_code");
                globalLoc = str.replace("+", "%2B");
     
                
            }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return globalLoc;
		
	}
	
	// this method will get the total transportation time of every destination
	// the input is in api request format, i.e. it is converted by toGlobal()
	public int travelTime(String[] strarr) {
		int travelTime = 0;
		for (int i = 0; i < strarr.length; i++ ) {
			String APIkey = "AIzaSyDoUlM151mrLPY77zLQKSzcUM89NzpJOfs";
        	String globaldes = strarr[i];
        	String message = "https://maps.googleapis.com/maps/api/distancematrix/json"
        			+ "?destinations=" + globaldes 
        			+ "&origins=" + this.globalagentloc
        			+ "&key=" + APIkey;
        	try {
        		URL url = new URL(message);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                //Check if connect is made
                int responseCode = conn.getResponseCode();

                // 200 OK
                if (responseCode != 200) {
                    throw new RuntimeException("HttpResponseCode: " + responseCode);
                } else {

                    StringBuilder informationString = new StringBuilder();
                    Scanner scanner = new Scanner(url.openStream());

                    while (scanner.hasNext()) {
                        informationString.append(scanner.nextLine());
                    }
                    //Close the scanner
                    scanner.close();
                    
                    System.out.println("-------------- raw data ---------------");
                    System.out.println(informationString);


                    //JSON simple library Setup with Maven is used to convert strings to JSON
                    JSONParser parse = new JSONParser();
                    JSONObject dataObject = (JSONObject) parse.parse(String.valueOf(informationString));
                    JSONArray rows = (JSONArray) dataObject.get("rows");
                    JSONObject first = (JSONObject) rows.get(0);
                    JSONArray elements = (JSONArray) first.get("elements");
                    JSONObject firstelement = (JSONObject) elements.get(0);
                    JSONObject distance = (JSONObject) firstelement.get("distance");
                    String text = (String) distance.get("text");
                    JSONObject duration = (JSONObject) firstelement.get("duration");
                    String text2 = (String) duration.get("text");
                    System.out.println("distance: " + text);
                    System.out.println("duration: " + text2);
                    String time = text2.split(" ")[0];
                    travelTime += Double.parseDouble(time);

                }
        	}
        	catch (Exception e) {
        		e.printStackTrace();
        	}
		}
		return travelTime;
	}
	


}
