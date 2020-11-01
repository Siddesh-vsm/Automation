package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

public class Testcase7 {
	
	
	public static void verifyErrorMessage(WebDriver driver) {
		
		Actions an = new Actions(driver);
		WebElement el = driver.findElement(By.xpath("//a[@title=\"Women\"]"));
		an.moveToElement(el);
		an.perform();
		driver.findElement(By.xpath("(//a[@title=\"Summer Dresses\"])[1]")).click();
		Actions an2 = new Actions(driver);
		List<WebElement> s1= driver.findElements(By.xpath("//div[@class=\"product-container\"]"));
		an2.moveToElement(s1.get(0));
		an2.perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//a[@class=\"addToWishlist wishlistProd_5\"]")).click();
		if(driver.findElement(By.className("fancybox-error")).isDisplayed()) {
			
			System.out.println("Error messages displyed");
			Reporter.log("Error messages displyed");
		}
		else {
			
			System.out.println("Error messages not displyed");
			Reporter.log("Error messages not displyed");
			Assert.fail();
		}
	}
	
}