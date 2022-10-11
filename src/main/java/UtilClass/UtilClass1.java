package UtilClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

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
}
