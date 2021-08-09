package test.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	public WebDriver driver;
	private String txtInputSearchBox = "//input[@id='twotabsearchtextbox']";
	private String btnGo = "//input[@value='Go']";
	private String product = "//span[contains(text(),'Mi Smart Band 5')]";
	private String txtpriceValue = "//span[@id='priceblock_dealprice']";
	private String txtManufacturer = "//table[contains(@id,'productDetails_techSpec_section')]//th[contains(text(),'Manufacturer')]/../td";
	private String txtDateFirstAvailable = "//table[contains(@id,'productDetails_detailBullets_sections')]//th[contains(text(),'Date First Available')]/../td";
	private String txtItemModelNmber = "//table[contains(@id,'productDetails_techSpec_section')]//th[contains(text(),'Item model number')]/../td";
	private String txtProductDimension = "//table[contains(@id,'productDetails_techSpec_section')]//th[contains(text(),'Product Dimensions')]/../td";
	private String btnAddToCart = "//input[@title='Add to Shopping Cart']";
	private String imgAddToCart = "//a[@id='nav-cart']";

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath(txtInputSearchBox)).sendKeys("mi watch band 5");
		driver.findElement(By.xpath(btnGo)).click();
		driver.findElement(By.xpath(product)).click();
		String productName = driver.findElement(By.xpath(product)).getText();
		System.out.println(productName);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		iterator.next();
		driver.switchTo().window(iterator.next());
		String price = driver.findElement(By.xpath(txtpriceValue)).getText();
		System.out.println("price: " + price);
		String manufacturer = driver.findElement(By.xpath(txtManufacturer)).getText();
		System.out.println("manufacturer name: " + manufacturer);
		String productDimension = driver.findElement(By.xpath(txtProductDimension)).getText();
		System.out.println("Porduct Dimention: " + productDimension);
		String dateFirstAvailability = driver.findElement(By.xpath(txtDateFirstAvailable)).getText();
		System.out.println("Product first date availability : " + dateFirstAvailability);
		String itemModelNumber = driver.findElement(By.xpath(txtItemModelNmber)).getText();
		System.out.println("product item model number : " + itemModelNumber);
		driver.findElement(By.xpath(btnAddToCart)).click();
		driver.findElement(By.xpath(imgAddToCart)).click();
		Assert.assertEquals(productName,
				"Mi Smart Band 5 – India’s No. 1 Fitness Band, 1.1-inch AMOLED Color Display, Magnetic Charging, 2 Weeks Battery Life, Personal Activity Intelligence (PAI), Women’s Health Tracking");

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
