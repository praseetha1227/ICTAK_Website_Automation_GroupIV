package org.ictak.testcases;

import org.ictak.base.BaseClass;
import org.ictak.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LoginPageTC extends BaseClass
{
	LoginPage loginpage;
	
	@Test(priority=0)
	public void verifyInvalidLogin()
	{
		loginpage = new LoginPage(driver, wait);
		
        boolean loginclick = loginpage.login();
        
        Assert.assertEquals(true, loginclick);
        
        boolean result = loginpage.signin(0);
        
        Assert.assertEquals(true, result);
    }
	
	@Test(priority=1)
	public void verifyValidLogin()
	{
        boolean result = loginpage.signin(1); 

        Assert.assertEquals(true, result);

        String Title = driver.getTitle();
        
        Assert.assertEquals(Title,"ICT Academy of Kerala");
	}

	@AfterClass
	public void Quit()
	{
		driver.close();
	}
}
