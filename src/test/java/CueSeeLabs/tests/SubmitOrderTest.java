package CueSeeLabs.tests;

import org.testng.annotations. DataProvider;
Run All
public class SubmitOrderTest extends BaseTest{
String productName = "ZARA COAT 3";
@Test(dataProvider="getData", groups= {"Purchase"})
Run Debug
public void submitOrder (HashMap<String, String> input) throws IOException, InterruptedException
{
ProductCatalogue productCatalogue landing Page.loginApplication(input.get("email"), input.get("password")
List<WebElement> products = productCatalogue.getProductList();
productCatalogue.addProductToCart(input.get("product"));
CartPage cartPage productCatalogue.goToCartPage();
Boolean match cartPage.VerifyProductDisplay(input.get("product"));
Assert.assertTrue(match);
Checkout Page checkoutPage = cartPage.goToCheckout();
checkoutPage.selectCountry("india");
ConfirmationPage confirmationPage
String confirmMessage = confirmationPage.getConfirmationMessage();
Assert.assertTrue(confirmMessage.equalsIgnoreCase ("THANKYOU FOR THE ORDER."));
}
@Test(depends0nMethods= {"submitOrder"})