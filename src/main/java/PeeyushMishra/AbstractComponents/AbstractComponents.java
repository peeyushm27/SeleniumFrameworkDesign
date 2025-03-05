package PeeyushMishra.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PeeyushMishra.pageobjects.CartPage;
import PeeyushMishra.pageobjects.OrderPage;

public class AbstractComponents {
	
	@FindBy(css="[routerlink*='/cart']")
	WebElement cartButton;
	
	@FindBy(css="button[routerlink*='/myorders']")
	WebElement ordersbutton;
	
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	public void waitForElementToDisAppear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	public void waitForWebElementToAppear(WebElement elem)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(elem));
		
	}
	
	public CartPage goToCart()
	{
		cartButton.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
		
	}
	public OrderPage gotoOrders()
	{
		ordersbutton.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
		
		
	}
}
