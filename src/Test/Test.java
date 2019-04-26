package Test;

import org.testng.Reporter;

import guru99.BaseTest;
import script.LoginPage;

public class Test extends BaseTest {
	

	@org.testng.annotations.Test
	public void testaPP(){
		LoginPage lp=new LoginPage(driver);
		lp.setUSerName("mngr190686");
		lp.setPassword("Ujedaze");
		lp.clickOnLogin();
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("Guru99 Bank Manager HomePage")){
			Reporter.log("home page is displayed",true);
		
		}
		else
			Reporter.log("home page is not displayed",true);
	
		

		
	}
	
	
	
	
	

}
