package CueSeeLabs.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest {
    public static void main(String[] args) {
        // Set up WebDriverManager for ChromeDriver
        // new comments are added
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        try {
            // Set an implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Navigate to the URL
            driver.get("https://rahulshettyacademy.com/client");

            // Login to the application
	            driver.findElement(By.id("userEmail")).sendKeys("soubhagyapatra30@gmail.com");
	            driver.findElement(By.id("userPassword")).sendKeys("Qwerty@123");
	            driver.findElement(By.id("login")).click();

            // Get the list of products
            List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

            // Locate the specific product (ZARA COAT 3)
            WebElement prod = products.stream().filter(product ->
                    product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);

            // Add the specific product to the cart (IPHONE 13 PRO in this case)
            WebElement button = driver.findElement(By.xpath("//b[text()='IPHONE 13 PRO']/ancestor::div[contains(@class, 'mb-3')]//button[contains(text(),'Add To Cart')]"));
            
            button.click();
         // Locate and click the "Cart" button
            driver.findElement(By.xpath("btn btn-custom")).click();

            // Wait for the "Buy Now" button to become clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate the "Buy Now" button using XPath
            WebElement buyNowButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Buy Now')]")
            ));

            // Click the "Buy Now" button
            buyNowButton.click();

            System.out.println("Clicked on 'Buy Now' button successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        
        }
    }
}
