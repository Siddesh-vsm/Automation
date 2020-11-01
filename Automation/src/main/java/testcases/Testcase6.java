package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Testcase6 {

	public static void buyProduct(WebDriver driver, WebDriverWait wait) {

		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("siddesh@yahoo.com");
		driver.findElement(By.id("passwd")).sendKeys("Pass@123");
		driver.findElement(By.id("SubmitLogin")).click();
		Actions an = new Actions(driver);
		WebElement el = driver.findElement(By.xpath("//a[@title=\"Women\"]"));
		an.moveToElement(el);
		an.perform();
		driver.findElement(By.xpath("(//a[@title=\"Dresses\"])[1]")).click();
		WebElement el1 = driver.findElement(By.xpath("(//form[@class=\"compare-form\"])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", el1);
		Actions an2 = new Actions(driver);
		List<WebElement> s1 = driver.findElements(By.xpath("//div[@class=\"product-container\"]"));
		an2.moveToElement(s1.get(s1.size() - 1));
		an2.perform();
		List<WebElement> more = driver.findElements(By.xpath("//span[text()=\"More\"]"));
		more.get(more.size() - 1).click();
		driver.findElement(By.className("icon-plus")).click();
		WebElement select = driver.findElement(By.id("group_1"));
		Select s2 = new Select(select);
		s2.selectByVisibleText("L");
		driver.findElement(By.xpath("//a[@title=\"Green\"]")).click();
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.xpath("//a[@title=\"Proceed to checkout\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Proceed to checkout\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Proceed to checkout\"]")).click();
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.name("processCarrier")).click();
		driver.findElement(By.className("bankwire")).click();
		driver.findElement(By.xpath("//span[text()=\"I confirm my order\"]")).click();
		String reference = driver.findElement(By.className("box")).getText();
		driver.findElement(By.className("account")).click();
		driver.findElement(By.xpath("//a[@title=\"Orders\"]")).click();
		String reference2 = driver.findElement(By.xpath("(//a[@class=\"color-myaccount\"])[1]")).getText();

		if (reference.contains(reference2)) {

			System.out.println("order placed");
			Reporter.log("order placed");
		} else {
			System.out.println("ordeer not placed");
			Reporter.log("order not placed");
			Assert.fail();
		}

	}

}
