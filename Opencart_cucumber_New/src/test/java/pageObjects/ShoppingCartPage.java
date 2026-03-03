package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

	public ShoppingCartPage(WebDriver driver)
	{
        super(driver);		
	}
	
	
	// locator
	
    @FindBy(xpath = "//div[@id = 'cart']/button")
    WebElement Itembtn;
	
    @FindBy(xpath="//strong[normalize-space()='View Cart']") 
    WebElement lnkviewCart;
	
	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[4]/td[2]")
	WebElement txtPrice;
	
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btncheckout;	
	
	
	//Action methods

	public void clickItembtn()
	{
		Itembtn.click();
	}
	
	public void clickAddToCart()
	{
		lnkviewCart.click();
	}
	
	public String getTotalPrice()
	{
		try
		{
		  return (txtPrice.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	
	public void Clickcheckout()
	{
		btncheckout.click();
	}
	
	
	
	
}
