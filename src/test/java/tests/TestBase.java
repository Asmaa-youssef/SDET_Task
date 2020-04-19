package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;

	@BeforeSuite
	public void startDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://www.phptravels.net/register");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@AfterMethod
	public void takeScreenShootFailure(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot scr = ((TakesScreenshot) driver);
			File srcfile = scr.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File("C:\\Users\\Omar\\eclipse-workspace-GROOVY\\SEDT\\screenshot\\"+result.getName() + ".png"));
		}
	}

	@AfterSuite
	public void stopDriver() {
		if (driver != null) {
			driver.quit();
		}

	}

}
