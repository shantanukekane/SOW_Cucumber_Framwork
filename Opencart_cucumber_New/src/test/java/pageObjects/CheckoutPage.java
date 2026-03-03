package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
	
	public CheckoutPage(WebDriver driver)
	{
	   super(driver);
	}
	
	//locators

@FindBy(xpath="//input[@id='input-payment-firstname']") 
WebElement txtfirstName;

@FindBy(xpath="//input[@id='input-payment-lastname']") 
WebElement txtlastName;


@FindBy(xpath="//input[@id='input-payment-company']")
WebElement txtcompany;

@FindBy(xpath="//input[@id='input-payment-address-1']") 
WebElement txtaddress1;

@FindBy(xpath="//input[@id='input-payment-address-2']") 
WebElement txtaddress2;

@FindBy(xpath="//input[@id='input-payment-city']") 
WebElement txtcity;

@FindBy(xpath="//input[@id='input-payment-postcode']") 
WebElement txtpostCode;

@FindBy(xpath="//select[@id='input-payment-country']")
WebElement txtcountry;

@FindBy(xpath="//select[@id='input-payment-zone']") 
WebElement txtregion_State;
	


    public void setFirstName()
    {
    	
    }






}
