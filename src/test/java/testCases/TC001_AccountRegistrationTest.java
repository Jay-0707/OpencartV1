package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("****Starting TC001_AccountRegistrationTest****");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link...");

		hp.clickRegistration();
		logger.info("Clicked on Register Link...");
		
		
		logger.info("Providing Customer Details...");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomString().toUpperCase());
		
		regpage.setLastName(randomString().toUpperCase());
		
		regpage.setEmail(randomString()+"@gmail.com");		//randomly generated email
		
		regpage.setTelephone(randomNumber());
		
		String randomPass=randomAlphaNumeric();
		
		regpage.setPassword(randomPass);
		regpage.setConfirmPassword(randomPass);
		
		regpage.clickPolicy();	

		regpage.clickContinue();
		 
		
		
		logger.info("Validating Expected Message...");
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed...");
			logger.debug("Debug Logs");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{	
			Assert.fail();
		}
		
		logger.info("****Finished TC001_AccountRegistrationTest****");

	}
	
	
}
