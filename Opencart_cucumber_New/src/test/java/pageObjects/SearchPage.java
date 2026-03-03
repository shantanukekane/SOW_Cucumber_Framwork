package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//locators
	@FindBy(xpath = "//div[@id = 'content']/div[3]//a/img")
	List<WebElement> searchProduct;
	
	@FindBy(xpath="//input[@id='input-quantity']") 
	WebElement passqty;
	
	@FindBy(xpath="//button[@id='button-cart']") 
	WebElement addToCart;
	
	@FindBy(xpath="//div[contains(text(),'Success: You have added ')]")
	WebElement confmsg;
	
	public boolean isProductExists(String productName)
	{

		boolean isExist = false;

		for(WebElement product:searchProduct)
		{
			if(product.getAttribute("title").equals(productName))
			{
				isExist = true;
				break;
			}
		}
		 return isExist;
	}
	
	public void selectProduct(String productName)
	{
		for(WebElement product:searchProduct)
		{
			if(product.getAttribute("title").equals(productName))
			{
				product.click();
			}
		}
	}
	
	
	
	public void setQuantity(String qty)
	{
		passqty.sendKeys(qty);
	}
	
	
	public void setAddToCart()
	{
		addToCart.click();
	}
	
	
	public boolean getConfmsg()
	{
		try
		{
		  return confmsg.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
}
