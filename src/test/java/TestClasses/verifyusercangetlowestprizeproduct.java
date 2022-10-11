package TestClasses;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClass.BaseClass1;
import PomClasses.HomePage;
import PomClasses.LoginPage;
import UtilClass.UtilClass1;

public class verifyusercangetlowestprizeproduct {
	static WebDriver driver;
	LoginPage lp;
	HomePage hp;
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest extenttest;
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String Browser) {
		htmlreporter = BaseClass1.gethtmlreport();
		 reports = BaseClass1.getextentreport();
		extenttest = BaseClass1.getextenttest("verifyusercangetlowestprizeproduct");
		
		driver = BaseClass1.initialize(Browser);
		
		
	}
	@BeforeMethod
	public void beforeMethod()
	{
	
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
	}
		@Test(priority = 1)
	public void verifyusercansearchproduct() throws InterruptedException  
	{
				
		hp.Searchtab();Thread.sleep(1000);
		hp.Searchbutton();Thread.sleep(3000);
		System.out.println(hp.Mobileresult());
		if(hp.Mobileresult().contains("Showing 1 – 24"))
		{
			System.out.println("user able to search product on flipkart test case pass");
		}else
		{
			System.out.println("test case failed");
		}Thread.sleep(2000);

}
		@Test(priority = 2)
		public void Verifyusercangetlowestprizeproduct() throws InterruptedException
		{
			
			Map <Integer, String> lowprizeproduct = new HashMap<>();
			for(int i=1; i<=5; i++)
			{
				if(i!=1) 
				{
				hp.switchtopage(i);
				}
			
				//lowestprizeproduct.add(hp.getlowestprizeofproduct());
				lowprizeproduct.put(i, hp.getlowestprizeofproduct());
				
			}System.out.println(lowprizeproduct);
		
			
		}
		@AfterMethod
		public void afterMethod(ITestResult result) throws IOException {
			if(result.getStatus() == ITestResult.SUCCESS) {
				String path=UtilClass1.screenshot(driver,result.getName());
				extenttest.log(Status.PASS,"Test :"+ result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build() );	
			}else if(result.getStatus() == ITestResult.FAILURE) {
				extenttest.log(Status.FAIL, "Test :"+ result.getName());	
				}else if(result.getStatus() == ITestResult.SKIP) {
					extenttest.log(Status.SKIP, "Test :"+ result.getName());	
					}
		}
		@AfterClass
		public void afterClass() {
			reports.flush();
		}
}
