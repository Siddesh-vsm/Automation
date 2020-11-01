package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import generic.CommonMethods;

public class Testcase4 {

	public static void verifyErrormessages(WebDriver driver) {
		try {
			driver.findElement(By.className("login")).click();
			driver.findElement(By.id("email_create")).sendKeys(CommonMethods.randomString() + "@test.com");
			driver.findElement(By.name("SubmitCreate")).click();
			driver.findElement(By.id("customer_firstname")).sendKeys("1233");
			driver.findElement(By.id("customer_lastname")).sendKeys("84569");
			driver.findElement(By.id("passwd")).sendKeys("785");
			WebElement select = driver.findElement(By.id("id_state"));
			Select s1 = new Select(select);
			s1.selectByVisibleText("Indiana");
			driver.findElement(By.id("postcode")).sendKeys("ytgfrff");
			driver.findElement(By.id("phone_mobile")).sendKeys("jekdfqgdb");
			driver.findElement(By.xpath("//span[text()=\"Register\"]")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			Assert.assertTrue(driver.findElement(By.xpath("//b[text()=\"lastname\"]")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//b[text()=\"firstname\"]")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//b[text()=\"passwd\"]")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),\"phone_mobile\")]")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),\"Zip/Postal\")]")).isDisplayed());
		} catch (Exception e) {

			System.out.println("Error not displyed");
			Reporter.log("Error not displyed");
			Assert.fail();

		}
	}

}
