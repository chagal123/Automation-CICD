package CueSeeLabs.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue {
  WebDriver driver;
	public ProductCatalogue(WebDriver Driver) 
	
	{
		//Intialization 
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	
	//WebElement userEmail = driver.findElement(By.cssSelector(".mb-3));
	//PageFactory
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	
	
}
