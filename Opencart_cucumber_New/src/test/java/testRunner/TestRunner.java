package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		 
		      // features = {".//Features"},
		       //features = {".//Features/Login.feature"},
		         features = {".//Features/Login.feature",".//Features/Registration.feature"},
		       //features = {"@target/rerun.txt"},
		       //features = {".//Features/Registration.feature"},
		       //features = {".//Features/LoginDDT.feature"},
		       glue = "stepsDefinitions",
		       plugin = {"pretty","html:reports/myreport.html",
		    		    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		    	         "rerun:target/rerun.txt"	    
		                },
		       dryRun = false,   // check mapping between scenario and step definitions method are perfect or not
		       monochrome = true,  // to avoid junk character in output
		       publish = true // this publish cucumber report in console
		       
		       //tags = "@sanity" // will execute those scenario whose having sanity tag
		       //tags = "@sanity and @regression"
		     //  tags = "@regression"
		       //tags = "@sanity and not @regression",
		       //tags = "@sanity or @regression"
		       
		    
		       )



public class TestRunner {

}
