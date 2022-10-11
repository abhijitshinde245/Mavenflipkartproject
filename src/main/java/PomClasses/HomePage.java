package PomClasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.BaseClass1;
import UtilClass.UtilClass1;

public class HomePage extends UtilClass1{
	static WebDriver driver;
	@FindBy(xpath=("(//div[@class='xtXmba'])[3]")) private WebElement mobilefieldbutton ;
	@FindBy(xpath=("//input[@type='text']")) private WebElement searchtab ;
	@FindBy(xpath=("//button[@type='submit']")) private WebElement searchbutton;
	@FindBy(xpath=("(//div[@class='_4rR01T'])[1]")) private WebElement mobile;
	@FindBy(xpath=("//span[@class='_10Ermr']")) private WebElement mobileresult;
	@FindBy(xpath=("//div[@class='_30jeq3 _1_WHN1']")) private List<WebElement> productlist;
	@FindBy(xpath=("(//div[@class='_3vhnxf'])[1]")) private WebElement myprofilebutton;
	@FindBy(xpath=("//div[@class='_1ruvv2']")) private WebElement profilename;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void Mobilefieldbutton() throws InterruptedException 
	{
		Thread.sleep(2000);
		
		mobilefieldbutton.click();
		
	
	}
	public void Searchtab()
	{
		searchtab.sendKeys("realme");
		}
		public void Searchfield(String mobilename) throws InterruptedException
		{
			searchtab.sendKeys(mobilename);	
			searchtab.sendKeys(Keys.ENTER);Thread.sleep(2000);
			//mobile.click();Thread.sleep(1000);
			searchtab.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		
	}
	public void Searchbutton()
	{
		searchbutton.click();
		
	}
	public void Mobile()
	{
		mobile.click();
	}
public String Mobileresult() {
	String Mresult=mobileresult.getText();
	return Mresult;
}
public String getlowestprizeofproduct()
{
	List <Integer> list = new ArrayList<>();
	
	for(WebElement list1 : productlist )
	{
		list.add(Integer.parseInt(list1.getText().replace("₹","").replace(",", "")));
	}System.out.println(list);
	
	Collections.sort(list);
	return list.get(0).toString();

}

public void switchtopage(int a) {
	
	driver.findElement(By.xpath("//a[@class='ge-49M' and text()="+a+"]")).click();
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='ge-49M _2Kfbh8' and text()='"+a+"']")));
	
}
public void hoverprofilename()
{
	BaseClass1 driver2 = new BaseClass1();
	Actions act = new Actions (driver);
	WebElement profileName = driver.findElement(By.xpath("(//div[@class='exehdJ'])[1]"));
	act.moveToElement(profileName).perform();
}
public void Myprofilebutton() {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", myprofilebutton);
	//myprofilebutton.click();
}
public String Profilename() {
	String Pname = profilename.getText();
	System.out.println("profile name : " +Pname);
	return Pname;
}

}
