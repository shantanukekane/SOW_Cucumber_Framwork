package stepsDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class Loginsteps {

	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage mp;
	
	List<HashMap<String,String>> datamap;
	
	@Given("the user should navigate to login Page")
	public void the_user_should_navigate_to_login_Page() 
	{
	    BaseClass.getLogger().info("GoTo my account: click on Login");
	    hp = new HomePage(BaseClass.getDriver());
	    
	    hp.clickMyAccount();
	    hp.clickLogin();
	    
	}

	@When("the user should enter email as {string} and password as {string}")
	public void the_user_should_enter_email_as_and_password_as(String email, String password) 
	{
		BaseClass.getLogger().info("User Enters Email and password.....");
	    lp = new LoginPage(BaseClass.getDriver());
	    lp.enterEmail(email);
	    lp.enterPass(password);
	}
	
	@When("the user click on login button")
	public void the_user_click_on_login_button() 
	{
	    lp.clickLoginbtn();
	    BaseClass.getLogger().info("User Clicked on Login Button");
	}

	@Then("the user should be redirect to My Account page")
	public void the_user_should_be_redirect_to_my_account_page() 
	{
	   mp = new MyAccountPage(BaseClass.getDriver());
	   boolean targetpage = mp.isMyAccountPageExist();
	   Assert.assertEquals(targetpage, true);
	}
	
	// Data Driven Test using scenario Outline
	
	@Then("the user navigates to my account page by passing email and password with Excel row {string}")
	public void the_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_row(String rows) throws IOException 
	{
	
		try
		{
		   datamap = DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx","Sheet1");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	
		int index = Integer.parseInt(rows)-1;
		String email = datamap.get(index).get("username");
		String pwd = datamap.get(index).get("password");
		String exp_res = datamap.get(index).get("res");
	    
		lp = new LoginPage(BaseClass.getDriver());
		lp.enterEmail(email);
		lp.enterPass(pwd);
		lp.clickLoginbtn();
		
		mp = new MyAccountPage(BaseClass.getDriver());
		try
		{
			boolean targetpage = mp.isMyAccountPageExist();
			
			System.out.print("target page: "+ targetpage);
			
			if(exp_res.equalsIgnoreCase("valid"))
			{
				if(targetpage == true)
				{
			     	MyAccountPage myacc = new MyAccountPage(BaseClass.getDriver());
				    myacc.clickLogout();
				    Assert.assertTrue(true);
			    }
			    else
			    {
		    		Assert.fail();
	     		}
			}
			if(exp_res.equalsIgnoreCase("invalid"))
			{
				if(targetpage == true)
				{
					mp.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}

	
	
	
}
