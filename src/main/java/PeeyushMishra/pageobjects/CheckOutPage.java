package PeeyushMishra.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PeeyushMishra.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
	
WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item")
	List<WebElement> countries;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	public void selectCountry(String c) throws InterruptedException
	{
		country.sendKeys(c);
		Thread.sleep(1000);
		WebElement selectedCountry = countries.stream().filter(country->country.getText().equalsIgnoreCase("United States")).findFirst().orElse(null);
		selectedCountry.click();
		
	}
	
	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
}