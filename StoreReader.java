import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author yuhanchiang
 * @version 2022/5/20
 * this class loads all the store information
 */

public class StoreReader {
	public JSONArray jsonarr;
	public StoreReader(String filename) {	
		JSONArray jsonarr = null;
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(filename)); // filename: stores_detail.json
			jsonarr = (JSONArray) obj;
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.jsonarr = jsonarr;		// returns json store
	}

}
