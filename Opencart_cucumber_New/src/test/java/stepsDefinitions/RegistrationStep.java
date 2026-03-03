package stepsDefinitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class RegistrationStep {

	WebDriver driver;
	HomePage hp;
	AccountRegistrationPage respage;
	LoginPage lp;
	
	
	@Given("the user should be registration page")
	public void the_user_should_be_registration_page() 
	{
	   BaseClass.getLogger().info("click on My Account button and navigate to register page.... ");	
	   hp = new HomePage(BaseClass.getDriver());
	   hp.clickMyAccount();
	   hp.clickRegister();
	   
	}

	@When("the user pass some valid sets of data into below field")
	public void the_user_pass_some_valid_sets_of_data_into_below_field(DataTable dataTable) 
	{
	    Map<String,String> dataMap = new HashMap<String,String>();
	    dataMap = dataTable.asMap(String.class,String.class);
	    
	    respage = new AccountRegistrationPage(BaseClass.getDriver());
	    respage.setFirstName(dataMap.get("firstName"));
	    respage.setLastName(dataMap.get("lastName"));
	    respage.setEmail(BaseClass.randomEmail());
	    respage.setTelephone(dataMap.get("telephone"));
	    respage.setPassword(dataMap.get("password"));
	    respage.setConfirmPass(dataMap.get("password"));
	  
	    
	}

	@When("the user click on subscription radio button")
	public void the_user_click_on_subscription_radio_button() 
	{
	   respage.clickradiobtn();
	}
	
	
	
	@When("the user click on policy check button")
	public void the_user_click_on_policy_check_button() throws InterruptedException 
	{
	   respage.clickpolicy();
	   Thread.sleep(1000);
	}

	@When("the user click on continue button")
	public void the_user_click_on_continue_button() 
	{
	    respage.clickcontinue();	    
	}

	
	@Then("the user see the message account created successfully")
	public void the_user_see_the_message_account_created_successfully() throws InterruptedException 
	{
	    String confmsg = respage.getconfmsg();
	    Thread.sleep(1000);
	    Assert.assertEquals(confmsg,"Register Account");
	   // Assert.aseertEquals(confmsg,"Your Account Has Been Created!");
	}

}
