package listenerclass;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClass.BaseClass1;
 



public class ListenerClass1  implements ITestListener {

	 ExtentTest extenttest;
	
		  public void onTestStart(ITestResult result) {
			  extenttest = BaseClass1.getalreadyexisttest();
			  extenttest.log(Status.INFO, result.getName());
		    System.out.println("Test Started" + result.getName());
		  }

		 
		  public  void onTestSuccess(ITestResult result) {
			  extenttest.log(Status.PASS, result.getName());
			  System.out.println("Test Passed" + result.getName());
		  }

		  public  void onTestFailure(ITestResult result) {
			  extenttest.log(Status.FAIL, result.getName());
			  System.out.println("Test Failed" + result.getName());
		  }

		 
		  public  void onTestSkipped(ITestResult result) {
			  extenttest.log(Status.SKIP, result.getName());
			  System.out.println("Test Skipped" + result.getName());
		  }
	

}
