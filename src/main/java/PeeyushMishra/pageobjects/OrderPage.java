package PeeyushMishra.pageobjects;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PeeyushMishra.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="div[class='cartSection'] h3") 
	List<WebElement> selectedProds;
	
	//@FindBy(css="tr td:nth-child(3)")
	//List<WebElement> orderedProducts;
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> orderedProducts;

	public boolean verifyOrderDisplayed(String productname)
	{
		boolean match = orderedProducts.stream().anyMatch(p->p.getText().equalsIgnoreCase(productname));
		return match;
		
	}
	
}