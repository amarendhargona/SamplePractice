package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {

	public WebDriver driver;
	private String imgAddToCart = "//a[@id='nav-cart']";
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void cartpage() {
		driver.findElement(By.xpath(imgAddToCart)).click();
	}

}
