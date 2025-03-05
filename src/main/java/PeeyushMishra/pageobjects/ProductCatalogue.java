package PeeyushMishra.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PeeyushMishra.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	

	
	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".w-10");
	By toastContainer = By.id("toast-container");

	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productBy);
		return products;
	}
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastContainer);
		//waitForElementToDisAppear(spinner);
		Thread.sleep(1000);
	}
	

}
