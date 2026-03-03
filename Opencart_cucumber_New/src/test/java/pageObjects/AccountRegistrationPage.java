package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
		
	// locators
	   
	@FindBy(xpath="//input[@id='input-firstname']") 
	private WebElement txtfirstName;
    
    @FindBy(xpath="//input[@id='input-lastname']") 
    WebElement txtlastName;
    
    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtEMail;
    
    @FindBy(xpath="//input[@id='input-telephone']") 
    WebElement txttelephone;
    
    @FindBy(xpath="//input[@id='input-password']") 
    WebElement txtpassword;
    
    @FindBy(xpath="//input[@id='input-confirm']") 
    WebElement txtpasswordConfirm;
    
    @FindBy(xpath="//label[1][@class = 'radio-inline']/input")
    WebElement newsletter;
    
    @FindBy(xpath="//input[@name='agree']")
    WebElement chkboxpolicy;
	
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btn_continue;
	
	@FindBy(xpath = "//div[@id = 'content']/h1")
	WebElement confimsg;
	
	// Action Method
	
	public void setFirstName(String Fname)
	{
		txtfirstName.sendKeys(Fname);
	}
	
	public void setLastName(String Lname)
	{
		txtlastName.sendKeys(Lname);
	}

	public void setEmail(String email)
	{
		txtEMail.sendKeys(email);
	}
	
	
	public void setTelephone(String Tel)
	{
		txttelephone.sendKeys(Tel);
	}
	
	public void setPassword(String pwd)
	{
}
	
	public void setConfirmPass(String pwd)
	{
		txtpasswordConfirm.sendKeys(pwd);
	}
	
	public void clickradiobtn()
	{
		newsletter.click();
	}
	
	public void clickpolicy()
	{
		chkboxpolicy.click();
	}
	
	public void clickcontinue()
	{
		btn_continue.click();
	}
	
	public String getconfmsg()
	{
		try
		{
		    return (confimsg.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());		
		}
	}
	
	
	
	
	
	
	
}
