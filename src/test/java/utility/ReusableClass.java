package utility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class ReusableClass {

	WebDriver driver;

	public ReusableClass(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToFirstChildWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		iterator.next();
		driver.switchTo().window(iterator.next());
	}
}
