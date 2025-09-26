package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass
{
	
	
	@Test(groups={"Sanity","Master"})
	public void verify_Login()
	{
		logger.info("*****Starting TC002_AccountLoginTest***");
		
		try 
		{
			
		logger.info("*****At Home Page***");
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("*****At Login Page***");
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean tergate_page=macc.isMyAccountPageExist();
				
		Assert.assertTrue(tergate_page);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Finished TC002_AccountLoginTest***");
	}
	
	
}
