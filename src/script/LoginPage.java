package script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	@FindBy(name="uid")
	private WebElement usernameTB;
	@FindBy(name="password")
	private WebElement passwordTB;
	
	@FindBy(name="btnLogin")
	private WebElement loginBTN;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void setUSerName(String un){
		usernameTB.sendKeys(un);
	}
	public void setPassword(String pw){
		passwordTB.sendKeys(pw);
	}
	public void clickOnLogin(){
		loginBTN.click();
	}

}
