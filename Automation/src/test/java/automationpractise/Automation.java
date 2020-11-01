package automationpractise;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic.CommonMethods;
import testcases.*;


public class Automation {

	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 15);

	}

	@Test(priority=1)
	public static void userValidate() throws InterruptedException {
		Testcase1.userValidation(driver);
	}

	@Test(priority=2)
	public static void verifyEmail() {
		Testcase2.verifyInvliadEmail(driver, wait);
	}

	@Test(priority=3)
	public static void mandataryFeilds() {
		Testcase3.validateMandatoryFields(driver);
	}

	@Test(priority=4)
	public static void changeQuantity() throws InterruptedException {
		 Testcase4.verifyErrormessages(driver);
	}

	@Test(priority=5)
	public static void searchProduct() {
		Testcase5.searchProduct(driver, wait);
	}

	
	@Test(priority=6)
	public static void buyProduct() {

		Testcase6.buyProduct(driver, wait);
	}

	@Test(priority=7)
	public static void errorMessage() {

		Testcase7.verifyErrorMessage(driver);
	}

	@Test(priority=8)
	public static void wishList() {

		Testcase8.productInWishList(driver);
	}

	@Test(priority=9)
	public static void quantity() throws InterruptedException, IOException  {

		Testcase9.changeQuantity(driver);
		
	}
	
	
	@AfterMethod
	public static void closeBrowser(ITestResult res) throws IOException {
		String name = res.getName();
		int Status = res.getStatus();
		
		if(Status ==2) {
			CommonMethods.takeScreenshot(driver, name);
		}
		driver.quit();
	}
	

}
