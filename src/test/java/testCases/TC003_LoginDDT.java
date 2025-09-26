package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataPRovider;

public class TC003_LoginDDT extends BaseClass
{
@Test (dataProvider="LoginData",dataProviderClass=DataPRovider.class, groups="Datadriven")//getting data provider from different class
	public void verify_login_DDT(String email,String Password,String exp)
	{
		logger.info("***Starting  TC003_LoginDDT ***");
		
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
				
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(Password);
		lp.clickLogin();
				
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean tergate_page=macc.isMyAccountPageExist();
	
		
		/*
		  Validation
		 Data is Valid-->Login Pass-->test pass-->logout
		 			  -->Login Failed-->test Failed	 
		 */
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(tergate_page==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}	
		
		/*
		 	Validation
		 Data is Invalid-->Login Pass-->test Fail-->logout
		 				-->Login Failed-->test pass
		 */
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(tergate_page==false)
			{
				macc.clickLogout();
				Assert.assertTrue(true);	
			}
			else
			{
				Assert.assertTrue(false);
			}
		}		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Finished	 TC003_LoginDDT ***");
	}
}