package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Testcase2 {
	public static void verifyInvliadEmail(WebDriver driver, WebDriverWait wait) {

		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("test455tgg");
		driver.findElement(By.name("SubmitLogin")).click();
		try {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()=\"Invalid email address.\"]")));
			String s1 = driver.findElement(By.xpath("//div[@class='alert alert-danger']//li")).getText();

			if (s1.contains("Invalid")) {
				System.out.println("invalid user error showing up");
				Reporter.log("invalid user error showing up");
			} else {
				System.out.println("invalid user error not showing up");
				Reporter.log("invalid user error not showing up");
				Assert.fail();
			}
		} catch (Exception e) {
			System.out.println("error not found");
			Reporter.log("error not found");
			Assert.fail();

		}
	}

}
