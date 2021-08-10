package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MiProductsPage {

	public WebDriver driver;
	private String txtpriceValue = "//span[@id='priceblock_ourprice']";
	private String txtManufacturer = "//table[contains(@id,'productDetails_techSpec_section')]//th[contains(text(),'Manufacturer')]/../td";
	private String txtDateFirstAvailable = "//table[contains(@id,'productDetails_detailBullets_sections')]//th[contains(text(),'Date First Available')]/../td";
	private String txtItemModelNmber = "//table[contains(@id,'productDetails_techSpec_section')]//th[contains(text(),'Item model number')]/../td";
	private String txtProductDimension = "//table[contains(@id,'productDetails_techSpec_section')]//th[contains(text(),'Product Dimensions')]/../td";
	private String btnAddToCart = "//input[@title='Add to Shopping Cart']";

	public MiProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void validateMiWatchbandProductDetails() {

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
		
	}
	
	public AddToCartPage clickOnAddToCart() {
		driver.findElement(By.xpath(btnAddToCart)).click();
		return new AddToCartPage(driver);
	}
	
	
}
