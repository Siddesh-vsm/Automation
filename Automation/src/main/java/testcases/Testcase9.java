package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class Testcase9 {

	public static void changeQuantity(WebDriver driver) throws InterruptedException {

		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("siddesh@yahoo.com");
		driver.findElement(By.id("passwd")).sendKeys("Pass@123");
		driver.findElement(By.id("SubmitLogin")).click();
		Actions an = new Actions(driver);
		WebElement el = driver.findElement(By.xpath("//a[@title=\"Women\"]"));
		an.moveToElement(el);
		an.perform();
		driver.findElement(By.xpath("//a[@title=\"Summer Dresses\"]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Actions an2 = new Actions(driver);
		List<WebElement> s1 = driver.findElements(By.xpath("//div[@class=\"product-container\"]"));
		an2.moveToElement(s1.get(1));
		an2.perform();

		List<WebElement> more = driver.findElements(By.xpath("//span[text()=\"More\"]"));
		more.get(1).click();
		WebElement select = driver.findElement(By.id("group_1"));
		Select s2 = new Select(select);
		s2.selectByVisibleText("L");
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.xpath("//a[@title=\"Proceed to checkout\"]")).click();
		js.executeScript("window.scrollBy(0,400)");
		String price = driver.findElement(By.id("total_product")).getText().replace("$", "");
		float n1 = Float.parseFloat(price);
		System.out.println(n1);
		driver.findElement(By.className("icon-plus")).click();
		Thread.sleep(5000);
		String price2 = driver.findElement(By.id("total_product")).getText().replace("$", "");
		float n2 = Float.parseFloat(price2);
		System.out.println(n2);
		if (n2 >= (2 * n1)) {

			System.out.println("price changed");
			Reporter.log("price changed");

		} else {
			System.out.println("price didnt change");
			Reporter.log("price changed");
			Assert.fail();
		}

	}

}
