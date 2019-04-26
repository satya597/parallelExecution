package parallel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Actitime {
	public WebDriver driver;
	String name;
	String pwd;
	@Parameters("myBrowser")
	@BeforeMethod
	public void test1(String myBrowser){
		if(myBrowser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver=new FirefoxDriver();
			
		}else if(myBrowser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
	}
	
	@Parameters("myBrowser1")
	@BeforeMethod
	public void test2(String myBrowser){
		if(myBrowser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver=new FirefoxDriver();
			
		}else if(myBrowser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
	}
	
	@Test
	public void test2(){
		JSONParser parser=new JSONParser();
		try{
			Object obj = parser.parse(new FileReader("D:/test.json"));
			System.out.println(obj.toString());
			JSONObject json=(JSONObject)obj;
			name=(String)json.get("username");
			System.out.println(name);
			 pwd=(String)json.get("password");
			 System.out.println(pwd);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		driver.get("http://kishore-pc:8080/login.do");
		driver.findElement(By.name("username")).sendKeys(name);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginButton")).click();
		
		
	}
	@AfterMethod
	public void closeApp(ITestResult testresult){
		
	String name=testresult.getName();
	int status=testresult.getStatus();
	if(status==1){
		Reporter.log("test is passed",true);
	}
	else{
		Reporter.log("test is failed/skipped",true);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/error.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
		
		
		
		
		
		
		
		
	}

}
