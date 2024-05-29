package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.FacebookPage;
import Objects.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethods_GoogleSearch {

	WebDriver driver;
	GoogleSearchPage object;

	@BeforeTest
	public void BeforeTestMethod() {
		// So before first test is ran, we need to launch the Chrome browser.
		// And since we are using webdriver manager, no need to setup
		// system.setproperty and all, we can directly launch chrome:
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

	}
	
	@Test (priority = 0)
	public void SearchOperation() throws InterruptedException
	{
		GoogleSearchPage page = new GoogleSearchPage(driver);
		page.searchGoogle("facebook");
	}
	
	@Test (priority = 1)
	public void verifyAndAccessFacebook()
	{
		object = new GoogleSearchPage(driver);
		object.clickFacebookLink();
	}
	
	@Test (priority = 2)
	public void verifyFacebookLogin()
	{
		FacebookPage page = new FacebookPage(driver);
		page.enterUsername();
		page.enterPassword();
		page.clickLoginButton();
	}
	
	@AfterTest
	public void afterTestMethod()
	{
		driver.quit();
	}
}
