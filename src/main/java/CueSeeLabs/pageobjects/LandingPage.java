package CueSeeLabs.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
  WebDriver driver;
	public LandingPage(WebDriver Driver) 
	
	{
		//Intialization 
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	
	//WebElement userEmail = driver.findElement(By.id("UserEmail"));
	//PageFactory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	public void loginApplication(String email,String password)
	{
		WebElement passwordEle = driver.findElement(By.id("password"));

		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
	
     }

	public static void goTo() {
		// TODO Auto-generated method stub
		
	}
}
