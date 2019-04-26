import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gobibo{
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	public static void main(String[] args) throws InterruptedException, AWTException  {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
//		WebDriverWait wait=new WebDriverWait(driver, 40);
//		wait.until(ExpectedConditions.alertIsPresent());
		
//	    Alert alert=driver.switchTo().alert();
//	   String text= alert.getText();
//	   System.out.println(text);
//	    alert.accept();
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
//		
		System.out.println("Alert is escaped");
	   driver.findElement(By.id("src")).sendKeys("Bangalore");
	   driver.findElement(By.xpath("//li[text()='Madiwala, Bangalore']")).click();
	 
	  driver.findElement(By.id("dest")).sendKeys("Hyderabad");
	  driver.findElement(By.xpath("//li[text()='Kukatpally, Hyderabad']")).click();
	WebElement strtdate = driver.findElement(By.xpath("//label[contains(text(),'Onward Date')]/.."));
//	 r.keyPress(KeyEvent.VK_ENTER);
//	  Actions action=new Actions(driver);
//	  action.moveToElement(strtdate).perform();
	//driver.findElement(By.xpath("c")).click();
	  
	  System.out.println("build is success");
	  
 Select s=new Select(strtdate);
//	 s.selectByVisibleText("Apr 2019");
//	 s.selectByIndex(23);
//		 
  LocalDateTime now=LocalDateTime.now();
  

		
		 
	}
	private static DateTimeFormatter DateTimeFormatter(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}