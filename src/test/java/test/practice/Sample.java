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

import basepage.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AddToCartPage;
import pages.HomePage;
import pages.MiProductsPage;

public class Sample extends BaseClass {

	@Test
	public void test() {
		HomePage homePage = new HomePage(driver);
		MiProductsPage miProductsPage = homePage.searchForMIProduct();
		miProductsPage.validateMiWatchbandProductDetails();
		AddToCartPage addToCartPage = miProductsPage.clickOnAddToCart();
		addToCartPage.cartpage();
		Assert.assertEquals(homePage.productName,
				"Mi Smart Band 5 – India’s No. 1 Fitness Band, 1.1-inch AMOLED Color Display, Magnetic Charging, 2 Weeks Battery Life, Personal Activity Intelligence (PAI), Women’s Health Tracking");

	}
}
