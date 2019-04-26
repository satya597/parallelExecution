import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FileDownload {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}

	@Test
	public void openApp() throws InterruptedException{
		FirefoxOptions option=new FirefoxOptions();
		
	    option.addArguments("--disable-notifications");
		WebDriver driver=new FirefoxDriver(option);
		//WebDriver driver=new ChromeDriver(option);
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com");
		
		Thread.sleep(1000);
		int i=0;
		String parentwindow = driver.getWindowHandle();
		Set<String> wh = driver.getWindowHandles();
		for(String allwhs:wh){
			driver.switchTo().window(allwhs);
			if(i>0){
				driver.close();
			}
			i++;
		}
		driver.switchTo().window(parentwindow);
		System.out.println(driver.getTitle());
		//driver.switchTo().parentFrame();
		driver.findElement(By.id("login_Layer")).click();
		Set<String> whs = driver.getWindowHandles();
		for(String w:whs){
			driver.switchTo().window(w);
		}
		driver.findElement(By.name("email")).sendKeys("satyavanibasa@gmail.com");
		driver.findElement(By.name("PASSWORD")).sendKeys("satya@597");
		driver.findElement(By.xpath("//button[@value='Login']")).click();
		
		String parent = driver.getWindowHandle();
		
		driver.switchTo().window(parent);
		
		Thread.sleep(1000);
		
		String xp1 = "/html/body/div[2]/div/div/span/div/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div[2]/a";
		
		driver.findElement(By.xpath(xp1)).click();
//		String xp2="(//input[@class='fileUpload waves-effect waves-light btn-large'])[1]";
//		driver.findElement(By.xpath(xp2)).click();
		driver.findElement(By.xpath("//*[@id='attachCV']")).click();
		//driver.close();
		
		
	}
	
	
}
