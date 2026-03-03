package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logger;
	public static Properties p;
	
	
	public static WebDriver initializeBrowser() throws IOException
	{
		p = getProperties();
		
		String executionenv = p.getProperty("execution_env");
		String browser = p.getProperty("browser").toLowerCase();
		String os = p.getProperty("os").toLowerCase();
		
		
		// os
		if(executionenv.equals("remote"))
		{
		
			DesiredCapabilities capability = new DesiredCapabilities();
			
			//os
			switch(os)
			{
			   case "windows": capability.setPlatform(Platform.WIN11);break;
			   case "Mac":  capability.setPlatform(Platform.MAC);break;
			   case "Linux":capability.setPlatform(Platform.LINUX);
			   default:System.out.print("No matching OS");
			   return null;
			}
			
			switch(browser)
			{
			   case "chrome":capability.setBrowserName("chrome");break;
		       case "edge":capability.setBrowserName("MicrosoftEdge");break;
			   default:System.out.print("No matching browser");
			   return null;
			}
			
        	driver = new RemoteWebDriver(new URL("http://192.168.31.240:4444/wd/hub"),capability);
		}
		else if(executionenv.equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase())
			{
			case "chrome":driver = new ChromeDriver();break;
			case "edge":driver = new EdgeDriver();break;
			case "firefox":driver = new FirefoxDriver();break;
			default:System.out.print("No matching browser");
			driver=null;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	
	
	public static Properties getProperties() throws IOException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);
	    
		return p;
	}
	
	
	public static Logger getLogger()
	{
		logger = LogManager.getLogger();
		return logger;
		
	}
	
	
	public static String randomNames()
    {
       String generaterandomName = RandomStringUtils.randomAlphabetic(6);
	   return generaterandomName;
    }


	public static String randomNumber()
	{
		String generaterandomNumber = RandomStringUtils.randomNumeric(10);
	    return generaterandomNumber;
	}
	
    public static String randomPassword()
    {
    	 String generaterandomName = RandomStringUtils.randomAlphabetic(6);
    	 String generaterandomNumber = RandomStringUtils.randomNumeric(10);
    	 
		     return (generaterandomName+"@"+generaterandomNumber);
    }
    
    public static String randomEmail()
    {
    	String generaterandomEmail =  RandomStringUtils.randomAlphabetic(5).toLowerCase()
                + RandomStringUtils.randomNumeric(3)
                + "@gmail.com";
    	return generaterandomEmail;
    }
	
	
	
}
