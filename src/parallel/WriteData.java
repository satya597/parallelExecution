package parallel;

import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.json.JsonOutput;

public class WriteData {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
	JSONObject obj=new JSONObject();
	obj.put("username","admin");
	obj.put("password", "admin");
	
	try(FileWriter file=new FileWriter("D:/test.json")){
      file.write(obj.toString());
	  file.flush();
	}
  catch(Exception e){
	  e.printStackTrace();
  }
	System.out.println(obj);
	}

}
