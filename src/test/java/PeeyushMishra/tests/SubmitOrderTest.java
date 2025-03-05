package PeeyushMishra.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PeeyushMishra.AbstractComponents.AbstractComponents;
import PeeyushMishra.TestComponents.BaseTest;
import PeeyushMishra.pageobjects.CartPage;
import PeeyushMishra.pageobjects.CheckOutPage;
import PeeyushMishra.pageobjects.ConfirmationPage;
import PeeyushMishra.pageobjects.LandingPage;
import PeeyushMishra.pageobjects.OrderPage;
import PeeyushMishra.pageobjects.ProductCatalogue;


public class SubmitOrderTest extends BaseTest{
	
	String productName = "ADIDAS ORIGINAL";

	//public static void main(String[] args) throws InterruptedException 
	@Test
	public void SubmitOrder() throws IOException, InterruptedException
	
	{
		
		 
		String Country = "united";
		ProductCatalogue productcatalogue = landingpage.loginApplication("mishrapiyush27@gmail.com", "Test@123");
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addToCart(productName);
		CartPage cartpage = productcatalogue.goToCart();
		boolean match = cartpage.VerifyProductDisplay(productName);
		AssertJUnit.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.checkOut();
		checkoutpage.selectCountry(Country);
		ConfirmationPage confirmationpage = checkoutpage.submitOrder();
		String finalpagetext = confirmationpage.verifyText();
		AssertJUnit.assertEquals("THANKYOU FOR THE ORDER.", finalpagetext);
		Thread.sleep(3000);
		
	}
	
	@Test(dependsOnMethods= {"SubmitOrder"})
	
	public void OrderHistoryTest()
	{
		ProductCatalogue productcatalogue = landingpage.loginApplication("mishrapiyush27@gmail.com", "Test@123");
		OrderPage orderpage = productcatalogue.gotoOrders();
		Assert.assertTrue(orderpage.verifyOrderDisplayed(productName));
	}

}
