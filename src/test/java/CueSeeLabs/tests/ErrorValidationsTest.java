package CueSeeLabs.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import CueSeeLabs.TestComponents.BaseTest;
import CueSeeLabs.pageobjects.LandingPage;
import CueSeeLabs.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void LoginErrorValidation() throws IOException {
        // Initialize the landing page
        LandingPage landingPage = launchApplication();

        // Attempt login with invalid credentials
        landingPage.loginApplication("anshika@gmail.com", "Iamki000");
        String errorMessage = landingPage.getErrorMessage();

        // Validate the error message
        Assert.assertEquals(errorMessage, "Incorrect email or password.", "Error message validation failed!");
    }

    @Test
    public void ProductErrorValidation() throws IOException {
        String productName = "IPHONE 13 PRO";

        // Login and initialize ProductCatalogue
        LandingPage landingPage = launchApplication();
        ProductCatalogue productCatalogue = landingPage.loginApplication("rahulshetty@gmail.com", "Iamki000");

        try {
            // Locate product and add to cart
            List<WebElement> products = productCatalogue.getProductList();
            WebElement button = driver.findElement(By.xpath("//b[text()='" + productName + "']/ancestor::div[contains(@class, 'mb-3')]//button[contains(text(),'Add To Cart')]"));
            button.click();

            // Locate and click the "Cart" button
            WebElement cartButton = driver.findElement(By.cssSelector(".btn.btn-custom")); // Corrected locator
            cartButton.click();

            // Wait for the "Buy Now" button to be clickable	
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement buyNowButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Buy Now')]")
            ));

            // Click the "Buy Now" button
            buyNowButton.click();
            System.out.println("Clicked on 'Buy Now' button successfully!");

        } catch (Exception e) {
            Assert.fail("Error occurred during product validation: " + e.getMessage());
        }
    }
}
