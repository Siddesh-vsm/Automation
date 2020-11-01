package generic;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;

public class CommonMethods {

	public static String randomString() {

		String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 6;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphaNumeric.length());
			char randomChar = alphaNumeric.charAt(index);
			sb.append(randomChar);
		}
		String randomString = sb.toString();
		return randomString;
	}

	public static int extractNumber(String s1) {

		String number = s1.replaceAll("[^0-9]", "");
		int n = Integer.parseInt(number);
		return n;

	}

	public static void takeScreenshot(WebDriver driver, String s1) throws IOException {
		try {
			TakesScreenshot sc = (TakesScreenshot) driver;
			File src = sc.getScreenshotAs(OutputType.FILE);
			File dest = new File("./Screenshots/"+s1 +" error.png");
			FileUtils.copyFile(src, dest);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static String rgbtoHexa(String s1) {
		String Hexaclr= Color.fromString(s1).asHex();
		return Hexaclr;
	}
}
