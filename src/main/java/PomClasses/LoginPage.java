package PomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClass.UtilClass1;

public class LoginPage extends UtilClass1{
	static WebDriver driver;
	
	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")private WebElement mobilenumber;

	@FindBy(xpath= "(//input[@autocomplete='off'])[3]")private WebElement password;

	@FindBy(xpath= "(//span[text()='Login'])[2]")private WebElement submitbutton;
	@FindBy(xpath= "(//div[@class='exehdJ'])[1]") private WebElement profilename;

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		

	}
	public void Mobilenumber() throws IOException
	{
		mobilenumber.sendKeys(getdata("mobile"));
		
		}
	public void Password() throws IOException
	{
		password.sendKeys(getdata("password"));
		
		}
	public void Submitbutton()
	{
		submitbutton.click();
		
		}
	public String Profilename() {
		String name = profilename.getText();
		return name;
	}
}
