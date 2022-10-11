package TestClasses;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
import PomClasses.ProfilePage;
import UtilClass.UtilClass1;

public class verifyusercanopenprofiledeetail {
	static WebDriver driver;
	LoginPage lp;
	HomePage hp;
	ProfilePage pp;
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest extenttest;
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) {
		htmlreporter = BaseClass1.gethtmlreport();
		 reports = BaseClass1.getextentreport();
		extenttest = BaseClass1.getextenttest("verifyusercanopenprofiledeetail");
		driver = BaseClass1.initialize(browser);
		
		
	}
	@BeforeMethod
	public void beforeMethod()
	{
	
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		pp = new ProfilePage(driver);
		
	}
		@Test (priority=1)
		public void Verifyusercanopenprofiledeetail() throws InterruptedException {
			
			hp.hoverprofilename();Thread.sleep(1000);
			hp.Myprofilebutton();Thread.sleep(2000);
			if(hp.Profilename().equals("Abhijit Shinde"))
			{
				System.out.println("User able to open profile detail test case pass");
			}
		}
		@DataProvider(name = "getaddress")
		public Object[][] getaddress()
		{
			Object[] [] addressdetail = {{"Abhijit","9767524891","413304","pandharpur","Vidyut Puri Shiv Temple, Gajapati Nagar"},{"Abhi","8208160672","413304","Bhandishegaon","Vidyut Puri Shiv Temple, Gajapati Nagar"}};
			return addressdetail;
		}
		@Test (priority=2, dataProvider="getaddress")
		public void verifyusercanaddaddress(String name,String mobilenumber,String pincode, String locality, String area) throws InterruptedException 
		{
			pp.Manageaddressbutton();
			List <String> list = Arrays.asList(name,mobilenumber,pincode,locality,area);
			Thread.sleep(2000);
			pp.filladdress(list);
			
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
		public void afterclass() {
			reports.flush();
			BaseClass1.unloaddriver();
			
		}
}
