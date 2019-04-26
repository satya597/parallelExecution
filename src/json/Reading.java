package json;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Reading {
	public static void main(String[] args) {
		JSONParser parser=new JSONParser();
	try{
	  Object obj=parser.parse(new FileReader("D:testjson.json"));
	  JSONObject json=(JSONObject)obj;
	  String name=(String)json.get("name");
	  String location=(String)json.get("location");
	  JSONArray coursearray=(JSONArray)json.get("courses");
	  Iterator<String> iterator=coursearray.iterator();
	  
	  while(iterator.hasNext()){
		  System.out.println("courses is:"+iterator.next());
	  }
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
}
