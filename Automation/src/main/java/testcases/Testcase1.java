package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import generic.CommonMethods;

public class Testcase1 {

	public static void userValidation(WebDriver driver) {
		try {
			driver.findElement(By.className("login")).click();
			driver.findElement(By.id("email_create")).sendKeys(CommonMethods.randomString()+"@test.com");
			driver.findElement(By.name("SubmitCreate")).click();
			driver.findElement(By.id("customer_firstname")).sendKeys("User");
			driver.findElement(By.id("customer_lastname")).sendKeys("Lastname");
			driver.findElement(By.id("passwd")).sendKeys("Pass@123");
			driver.findElement(By.id("city")).sendKeys("Banglore");
			driver.findElement(By.id("address1")).sendKeys("#dummy address");
			driver.findElement(By.id("address1")).sendKeys("#dummy address");
			driver.findElement(By.id("address1")).sendKeys("#dummy address");
			WebElement select = driver.findElement(By.id("id_state"));
			Select s1 = new Select(select);
			s1.selectByVisibleText("Indiana");
			driver.findElement(By.id("postcode")).sendKeys("85962");
			driver.findElement(By.id("phone_mobile")).sendKeys("8596237856");
			driver.findElement(By.id("alias")).sendKeys("#dummy refference");
			driver.findElement(By.xpath("//span[text()=\"Register\"]")).click();
			String etitle = "My account - My Store";
			String atitle = driver.getTitle();
			Assert.assertEquals(etitle, atitle);
			System.out.println("User created successfully");
			Reporter.log("User created successfully");
		} catch (Exception e) {
			System.out.println("Something went wrong with exception " + e);
			Reporter.log("Something went wrong with exception " + e);
		}
	}
}
