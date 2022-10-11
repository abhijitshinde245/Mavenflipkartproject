package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass1 {
	static  WebDriver driver;
	static ExtentHtmlReporter htmlreporter;
	static ExtentReports reports ;
	static ExtentTest extenttest;
	public static WebDriver initialize(String browser) {
		if(driver == null) 
		{
			if(browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Abhijit shinde\\Selenium\\chromedriver.exe");
				 driver = new ChromeDriver();
			}else {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\Abhijit shinde\\Selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");

				 driver = new FirefoxDriver();
			}
		
		driver.get("https://www.flipkart.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
			driver.manage().window().maximize();
			
		}
		return driver;
	

		}
		public static void unloaddriver() {
			driver=null;	
		}
		public static ExtentHtmlReporter gethtmlreport() 
		{  
			if(htmlreporter==null) 
			{
	 htmlreporter = new ExtentHtmlReporter("Flipkartreports.html");
			}
			return htmlreporter;
		}
		public static ExtentReports getextentreport()
		{
			if(reports == null) {
				 reports = new ExtentReports();
				reports.attachReporter(htmlreporter);
			 
			}return reports;
		}
		public static ExtentTest getextenttest(String testname ) {
			extenttest = reports.createTest(testname);
			return  extenttest;
		}
		public static ExtentTest getalreadyexisttest() {
			return  extenttest;
		}
}
