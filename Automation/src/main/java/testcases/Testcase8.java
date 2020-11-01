package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

public class Testcase8 {

	public static void productInWishList(WebDriver driver) {

		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("siddesh@yahoo.com");
		driver.findElement(By.id("passwd")).sendKeys("Pass@123");
		driver.findElement(By.id("SubmitLogin")).click();
		Actions an = new Actions(driver);
		WebElement el = driver.findElement(By.xpath("//a[@title=\"Women\"]"));
		an.moveToElement(el);
		an.perform();
		driver.findElement(By.xpath("//a[@title=\"Summer Dresses\"]")).click();
		Actions an2 = new Actions(driver);
		List<WebElement> s1 = driver.findElements(By.xpath("//div[@class=\"product-container\"]"));
		an2.moveToElement(s1.get(1));
		String dress = s1.get(1).getText();
		an2.perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//a[@class='addToWishlist wishlistProd_6']")).click();
		if (driver.findElement(By.className("fancybox-error")).isDisplayed()) {
			driver.findElement(By.xpath("//a[@title=\"Close\"]")).click();
			driver.findElement(By.className("account")).click();
			driver.findElement(By.className("icon-heart")).click();
			WebElement el1 = driver.findElement(By.id("wishlist_25638"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView();", el1);
			driver.findElement(By.xpath("//tr[@id=\"wishlist_25638\"]//a[contains(text(),\"My wishlist\")]")).click();
			WebElement el2 = driver.findElement(By.id("s_title"));
			js1.executeScript("arguments[0].scrollIntoView();", el2);
			String st2 = driver.findElement(By.id("s_title")).getText();
			if (dress.contains(st2)) {

				System.out.println("item is present in wishList");
				Reporter.log("item is present in wishList");
			} else {

				System.out.println("item is not there in wishList");
				Reporter.log("item is not there in wishList");
				Assert.fail();
			}

			System.out.println("Error messages displyed");
			Reporter.log("Error messages displyed");
		} else {

			System.out.println("Error messages not displyed");
			Reporter.log("Error messages not displyed");
			Assert.fail();

		}
	}
}
