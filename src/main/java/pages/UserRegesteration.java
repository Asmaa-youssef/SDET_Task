package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class UserRegesteration extends PageBase {

	public UserRegesteration(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
	}

	@FindBy(css = "input[name='firstname']")
	WebElement fnTxtBox;

	@FindBy(css = "input[name='lastname']")
	WebElement lnTxtBox;

	@FindBy(css = "input[name='phone']")
	WebElement phone;

	@FindBy(css = "input[name='email']")
	WebElement email;

	@FindBy(css = "input[name='password']")
	WebElement passwordTxtBox;

	@FindBy(css = "input[name='confirmpassword']")
	WebElement confirmPasswordTxtBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signup;

	@FindBy(xpath = "//*[@class='col-md-8']")
	public WebElement successMessage;

	@FindBy(css = "div[class='dropdown dropdown-login dropdown-tab']")
	public WebElement dropdown;

	@FindBy(xpath = "//*[@class='bx bx-user']")
	public WebElement Myaccount;

	@FindBy(xpath = "//a[@href='https://www.phptravels.net/account/logout/']")
	public WebElement Loginoutbtn;

	public void userRegistration(String firstName, String lastName, String phonee, String emaill, String password) {
		

		String firstname_upper_case = "";
		String lastname_upper_case = "";

		firstname_upper_case = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1) + " ";
		lastname_upper_case = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1) + " ";
		setTextElementText(fnTxtBox, firstname_upper_case);
		setTextElementText(lnTxtBox, lastname_upper_case);
		setTextElementText(phone, phonee);
		setTextElementText(email, emaill);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		
		
		clickButton(signup);
	}

	public void loginOutUser() throws InterruptedException {

		jse.executeScript("arguments[0].click();", Myaccount);
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", Loginoutbtn);

	}

}
