package UtilClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilClass1 {
	static WebDriver driver;
	public static String getdata(String key) throws IOException {
		FileInputStream file = new FileInputStream ("C:\\Users\\Abhijit shinde\\eclipse-workspace\\FlipkartProject\\Configuration\\config.properties");
	  Properties p = new Properties();
	  p.load(file);
	  String property = p.getProperty(key);
	  return property;
	}
	public static String screenshot(WebDriver driver, String methodname) throws IOException {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = ""+methodname+".jpg";
		File destination = new File (path);
		FileHandler.copy(screenshot, destination);
		return path;
	}
	public static void hovertoelement(WebDriver driver, WebElement element) {
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
	
	}
	public static void waitmethod() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(null));
	}
	
}
