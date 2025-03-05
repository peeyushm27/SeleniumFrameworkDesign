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
import PeeyushMishra.pageobjects.ProductCatalogue;


public class ErrorValidationTest extends BaseTest{

	//public static void main(String[] args) throws InterruptedException 
	@Test
	public void LoginErrorValidation() throws IOException, InterruptedException
	
	{
		
	 landingpage.loginApplication("mishrapiyush27@gmail.com", "Test@12345");
	 AssertJUnit.assertEquals("Incorrect email or password.", landingpage.verifyError());
		
		
		
	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	
	{
		
		String productName = "ADIDAS ORIGINAL";
		String Country = "united";
		ProductCatalogue productcatalogue = landingpage.loginApplication("mishrapiyush27@gmail.com", "Test@123");
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addToCart(productName);
		CartPage cartpage = productcatalogue.goToCart();
		boolean match = cartpage.VerifyProductDisplay(productName);
		AssertJUnit.assertTrue(match);
		
		
	}
}
