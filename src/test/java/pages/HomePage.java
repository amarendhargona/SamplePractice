package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.ReusableClass;

public class HomePage {

	public WebDriver driver;
	private String txtInputSearchBox = "//input[@id='twotabsearchtextbox']";
	private String btnGo = "//input[@value='Go']";
	private String product = "//span[contains(text(),'Mi Smart Band 5')]";
	private String txtProductName = "//div[@id='titleSection']//span[contains(text(),'Mi Smart Band 5')]";
	public String productName;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	public MiProductsPage searchForMIProduct() {
		driver.findElement(By.xpath(txtInputSearchBox)).sendKeys("mi watch band 5");
		driver.findElement(By.xpath(btnGo)).click();
		driver.findElement(By.xpath(product)).click();
		ReusableClass reusableClass = new ReusableClass(driver);
		reusableClass.switchToFirstChildWindow();
		this.productName = driver.findElement(By.xpath(txtProductName)).getText();
		return new MiProductsPage(driver);
	}

}
