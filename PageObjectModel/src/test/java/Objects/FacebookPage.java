package Objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookPage {
	
	WebDriver driver;

	public FacebookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Username = By.id("email");
	By Password = By.id("pass");
	By LoginBtn = By.name("login");
	
	public void enterUsername()
	{
		driver.findElement(Username).sendKeys("Testuser");
	}
	
	public void enterPassword()
	{
		driver.findElement(Password).sendKeys("Tester123");
	}
	
	public void clickLoginButton()
	{
		driver.findElement(LoginBtn).click();
		String title = driver.getTitle();
		assertEquals(title, "Log in to Facebook");
	}
	
	

}
