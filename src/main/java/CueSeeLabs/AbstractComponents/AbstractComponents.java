package CueSeeLabs.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
    
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize WebDriver and WebDriverWait
    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Example Method: Get all products
    public List<WebElement> getProducts() {
        return driver.findElements(By.cssSelector(".mb-3"));
    }

    // Example Method: Wait for an element to be visible
    public WebElement waitForElement(By locator) {
        return wait.until(driver -> driver.findElement(locator));
    }
}
