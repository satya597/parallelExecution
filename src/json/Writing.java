package json;

import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Writing {
	public static void main(String[] args) {
		JSONObject obj=new JSONObject();
		obj.put("name","satyavani");
		obj.put("location", "Amalapuram");
		JSONArray list=new JSONArray();
		list.add("java");
		list.add("selenium");
		list.add("aql");
		list.add("manual testing");
		
		obj.put("courses", list);
		
		
		try(FileWriter file=new FileWriter("D:testjson.json")){
			file.write(obj.toString());
			file.flush();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(obj);
	}

}
