package PeeyushMishra.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PeeyushMishra.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="div[class='cartSection'] h3") 
	List<WebElement> selectedProds;
	
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	public boolean VerifyProductDisplay(String productname)
	{
		boolean match = selectedProds.stream().anyMatch(sp->sp.getText().equalsIgnoreCase(productname));
		return match;
	}
	
	public CheckOutPage checkOut()
	{
		checkout.click();	
		return new CheckOutPage(driver);
		
		
	}
}