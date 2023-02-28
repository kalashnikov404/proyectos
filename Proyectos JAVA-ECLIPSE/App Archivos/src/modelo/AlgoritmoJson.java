package modelo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class AlgoritmoJson {
	 
	public static void main(String[] args) {
	    try {
	        JSONParser parser = new JSONParser();
	        //Use JSONObject for simple JSON and JSONArray for array of JSON.
	        JSONObject data = (JSONObject) parser.parse(
	              new FileReader("C:\\Users\\Grudges\\Desktop\\paises.json"));//path to the JSON file.

	        String json = data.toJSONString();
	        System.out.println(json);
	        
	    } catch (IOException | ParseException e) {
	        e.printStackTrace();
	    }
	}
}
