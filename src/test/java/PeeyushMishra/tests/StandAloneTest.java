package PeeyushMishra.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

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

import PeeyushMishra.pageobjects.LandingPage;


public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String producttobeSelected = "BANARSI SAREE";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("mishrapiyush27@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@123");
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		//WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("BANARSI SAREE")).findFirst().orElse(null);
		//prod.findElement(By.cssSelector(".w-10")).click();
		
		for (WebElement prod : products)
		{
			if (prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(producttobeSelected))
			{
				prod.findElement(By.cssSelector(".w-10")).click();
			}
		}
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".toast-container"))));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='/cart']")).click();
		List<WebElement> selectedProds = driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
		boolean match = selectedProds.stream().anyMatch(sp->sp.getText().equalsIgnoreCase(producttobeSelected));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("United");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[class*='list-group-item'] span"))));
		List<WebElement> countries = driver.findElements(By.cssSelector("button[class*='list-group-item'] span"));
		WebElement selectedCountry = countries.stream().filter(country->country.getText().equalsIgnoreCase("United States")).findFirst().orElse(null);
		selectedCountry.click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".toast-bottom-right"))));
		System.out.println(driver.findElement(By.cssSelector(".toast-bottom-right")).getText());
		String tqMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(tqMessage, "THANKYOU FOR THE ORDER.");
		Thread.sleep(3000);
		driver.close();
		
		//for (WebElement a : selectedProds)
		//	Assert.assertEquals(a.getText(), producttobeSelected);
		
	}

}
