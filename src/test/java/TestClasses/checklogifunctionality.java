package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClass.BaseClass1;
import PomClasses.LoginPage;
import UtilClass.UtilClass1;
import listenerclass.ListenerClass1;

public class checklogifunctionality {
	static WebDriver driver;
	LoginPage lp;
	static ExtentHtmlReporter htmlreporter;
	static ExtentReports reports;
	static ExtentTest extenttest;
	
	
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) {
		
		htmlreporter = BaseClass1.gethtmlreport();
		 reports = BaseClass1.getextentreport();
		extenttest = BaseClass1.getextenttest("checklogifunctionality");
		driver = BaseClass1.initialize(browser);
	}
	@BeforeMethod
	
	public void beforeMethod()
	{
	
		lp = new LoginPage(driver);
	}
		@Test
	public void Checklogifunctionality() throws InterruptedException, IOException 
	{
		Thread.sleep(3000);
		
		lp.Mobilenumber();
		extenttest.log(Status.INFO, "Enter Mobile number");
		Reporter.log("Enter Mobile number");
		lp.Password();
		extenttest.log(Status.INFO, "Enter Password");
		Reporter.log("Enter password");
		lp.Submitbutton();
		Thread.sleep(3000);
		lp.Profilename();
		
		if(lp.Profilename().equals("Abhijit"))
		{
			System.out.println("user log in into flipkart Test case pass");
		}else
		{
			System.out.println("Test case fail");
		}
	}
		@AfterMethod
		public void afterMethod(ITestResult result) throws IOException {
			if(result.getStatus() == ITestResult.SUCCESS) {
			
			String path=UtilClass1.screenshot(driver,result.getName());
			extenttest.log(Status.PASS,"Test :"+ result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build() );	
			}else if(result.getStatus() == ITestResult.FAILURE) {
				extenttest.log(Status.FAIL, "Test :"+result.getName());	
				}else if(result.getStatus() == ITestResult.SKIP) {
					extenttest.log(Status.SKIP, "Test :"+result.getName());	
					}
		}
		@AfterClass
		public void afterClass() {
			reports.flush();
		}
}
