package PomClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClass.UtilClass1;

public class ProfilePage extends UtilClass1 {
	static WebDriver driver;
	@FindBy(xpath = "//div[text()='Manage Addresses']")private WebElement manageaddressbutton;
	@FindBy(xpath = "//div[@class='_1QhEVk']")private WebElement addaddressbutton;
	@FindBy(xpath = "//textarea[@name='addressLine1']") private WebElement area;
	@FindBy(xpath = "//button[text()='Save']")private WebElement savebutton;
	
	
	
	public ProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		

	}

	public void Manageaddressbutton() {
		manageaddressbutton.click();
	}

	
		
	

public void filladdress(List <String> list) throws InterruptedException {
	//browserinitialize.initialize();
	
	addaddressbutton.click();
	Thread.sleep(2000);
	for(int i=1; i<=4; i++) 
	{
		driver.findElement(By.xpath("//input[@tabindex='"+i+"']")).sendKeys(list.get(i-1));
		
	}
	area.sendKeys(list.get(4));
	//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	//wait1.until(ExpectedConditions.visibilityOf(savebutton));
	Thread.sleep(2000);
	savebutton.click(); 
	
	
}
}
