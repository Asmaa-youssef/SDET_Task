package tests;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.regex.Pattern;
import org.testng.annotations.Test;
import bsh.ParseException;
import data.JsonDataReader;
import pages.Login;
import pages.UserRegesteration;

public class UserRegestrationTest extends TestBase {

	JsonDataReader jsonReader = new JsonDataReader();
	UserRegesteration registerObject;
	String phoneee = "^[0-9]*$";
	String pass = "^(?=.*?\\p{Lu})(?=.*?\\p{Ll})(?=.*?\\d)" + "(?=.*?[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?]).*$";

	@Test(priority = 3)
	public void checkphone() throws ParseException, IOException, org.json.simple.parser.ParseException {
		String phonee = JsonDataReader.phone;
		String validInput = phonee;
		assertTrue(Pattern.compile(phoneee).matcher(validInput).matches());
	}

	@Test(priority = 2)
	public void checkpassword() throws ParseException, IOException, org.json.simple.parser.ParseException {
		String passs = JsonDataReader.password;
		String validpass = passs;
		assertTrue(Pattern.compile(pass).matcher(validpass).matches());
	}

	@Test(priority = 1)
	public void userCanRegisterSuccessfully()
			throws InterruptedException, ParseException, IOException, org.json.simple.parser.ParseException {

		jsonReader.jsonReader();
		registerObject = new UserRegesteration(driver);
		Thread.sleep(7000);
		registerObject.userRegistration(jsonReader.firstname, jsonReader.lastname, jsonReader.phone, jsonReader.email,
				jsonReader.password);
		registerObject.loginOutUser();
		Thread.sleep(7000);
	}

	@Test(priority = 4)
	public void registeredUserCanLogin()
			throws InterruptedException, ParseException, IOException, org.json.simple.parser.ParseException {
		jsonReader = new JsonDataReader();
		jsonReader.jsonReader();
		Login loginobject = new Login(driver);
		loginobject.LoginUser(jsonReader.email, jsonReader.password);

		Thread.sleep(3000);
	}

}