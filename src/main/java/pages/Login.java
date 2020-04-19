package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class Login extends PageBase {

	public Login(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
	}
	
	

	@FindBy(xpath = "//input[@type='email']")
	public WebElement Emaila;

	@FindBy(xpath = "//input[@type='password']")
	public WebElement passwordd;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;

	public void LoginUser(String email, String Password) throws InterruptedException {
		setTextElementText(Emaila, email);
		setTextElementText(passwordd, Password);
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", login);

	}

}
