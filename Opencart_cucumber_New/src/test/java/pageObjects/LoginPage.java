package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//locators
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_loginEmail;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_loginPass;
	
	@FindBy(xpath="//input[@value='Login']") 
	WebElement loginbtn;
	
	//Action methods
	
	public void enterEmail(String email)
	{
		txt_loginEmail.sendKeys(email);
	}
	
	public void enterPass(String pwd)
	{
		txt_loginPass.sendKeys(pwd);
	}
	
	public void clickLoginbtn()
	{
		loginbtn.click();
	}
	
	
}
