package testcases;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Testcase5 {

	public static void searchProduct(WebDriver driver, WebDriverWait wait) {

		Actions an = new Actions(driver);
		WebElement el = driver.findElement(By.xpath("//a[@title=\"Women\"]"));
		an.moveToElement(el);
		an.perform();
		driver.findElement(By.xpath("//a[@title=\"Summer Dresses\"]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement el1 = driver.findElement(By.xpath("//div[@class=\"product-container\"]"));
		js.executeScript("arguments[0].scrollIntoView();", el1);
		java.util.List<WebElement> l1 = driver.findElements(By.xpath("//div[@class=\"product-container\"]"));
		WebElement product = l1.get(l1.size() - 1);
		String s1[] = product.getText().split("\n");
		System.out.println(s1[0] + s1[1]);
		driver.findElement(By.name("search_query")).sendKeys(s1[0]);
		driver.findElement(By.name("submit_search")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"product-container\"]")));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement el2 = driver.findElement(By.xpath("//div[@class=\"product-container\"]"));
		js1.executeScript("arguments[0].scrollIntoView();", el2);
		java.util.List<WebElement> l2 = driver.findElements(By.xpath("//div[@class=\"product-container\"]"));
		WebElement productSearch = l2.get(0);
		String s2[] = productSearch.getText().split("\n");
		System.out.println(s2[0] + s2[1]);
		if (s1[0].equals(s2[0]) && s1[1].equals(s2[1])) {

			System.out.println("Search working properly");
			Reporter.log("Search working properly");
		} else {

			System.out.println("failed Test case");
			Reporter.log("Search not working properly");
			Assert.fail();
		}

	}

}
