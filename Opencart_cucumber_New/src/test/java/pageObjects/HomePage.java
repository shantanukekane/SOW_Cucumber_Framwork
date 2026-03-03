package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	// locators
     
     @FindBy(xpath="//span[normalize-space()='My Account']") 
     WebElement lnkmyAccount;
     
     @FindBy(xpath="//a[normalize-space()='Register']") 
     WebElement lnkregister;
     
     @FindBy(xpath="//a[normalize-space()='Login']") 
     WebElement lnklogin;
	

     @FindBy(xpath="//input[@placeholder='Search']")
     WebElement txtInputsearch;
     
     @FindBy(xpath="//button[@class='btn btn-default btn-lg']")
     WebElement btnsearch;
     
	
	//Action methods
	
	
     public void clickMyAccount()
     {
    	 lnkmyAccount.click();
     }
     
     
     public void clickRegister()
     {
    	 lnkregister.click();
     }
     
     
     public void clickLogin()
     {
    	 lnklogin.click();
    	 
     }
     
     public void searchProductName(String productName)
     {
    	 txtInputsearch.sendKeys(productName);
     }
     
     public void clicksearchbtn()
     {
    	 btnsearch.click();
     }
     
}
