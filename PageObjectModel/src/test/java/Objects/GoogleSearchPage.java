package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {

	WebDriver driver;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	By searchBox = By.xpath("//textarea[@id='APjFqb']");
	By searchBtn = By.xpath("(//input[@name='btnK'])[1]");
	By facebookLink = By.xpath("//h3[text()='Facebook - log in or sign up']");

	// Method to search:
	public void searchGoogle(String input) {
		// Instead of thread.sleep, we can use try and catch to handle the exceptions:
		try {

			driver.findElement(searchBox).sendKeys(input);
			Thread.sleep(1000);
			driver.findElement(searchBtn).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}

	public void clickFacebookLink() {
		try {
			driver.findElement(facebookLink).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
	}
}
