package org.ictak.testcases;
import java.io.IOException;

import org.ictak.base.BaseClass;
import org.ictak.pages.LoginPage;
import org.ictak.pages.NewstaffForm;
import org.ictak.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewstaffTC extends BaseClass {

	NewstaffForm newstaff;
	LoginPage loginPage;
	
	@BeforeClass
	public void Login()
	{
		loginPage = new LoginPage(driver, wait);
		loginPage.login();
		loginPage.signin(1);
	}
	
	@Test(priority=0)
	public void validstaffform() throws IOException
	{		
		newstaff = new NewstaffForm (driver, wait);
		
		boolean staffclick = newstaff.stafficonclick();

		Assert.assertEquals(true, staffclick);
		
		boolean newstaffclick = newstaff.NewStaffclick();

		Assert.assertEquals(true, newstaffclick);
		
		newstaff.validstaffform();
		
		boolean addresult = newstaff.AddStaffClick();
        
        Assert.assertEquals(true, addresult);
	}

	// checking form submission with empty image field
	@Test(priority = 1)
	public void emptyimagefield() throws IOException
	{
		boolean newstaffclick = newstaff.NewStaffclick();

		Assert.assertEquals(true, newstaffclick);
		
		newstaff.emptyimagefield();
		
		boolean addresult = newstaff.AddStaffClick();
        
        Assert.assertEquals(false, addresult);

	}
	
	@Test(priority=2)
	public void Search() throws IOException
	{	
		boolean staffclick = newstaff.stafficonclick();

		Assert.assertEquals(true, staffclick);
		
		String actual = ExcelUtility.getStaffData(0, 0);
		
		String expected = newstaff.Search();
		
		Assert.assertEquals(actual, expected);
		
		boolean viewClick = newstaff.ViewStaff();
      
       Assert.assertEquals(true, viewClick);
		
	}
	
	@AfterClass
	public void Logout() throws InterruptedException
	{
		Thread.sleep(1000);

		boolean logoutclick = newstaff.Logout();

		Assert.assertEquals(true, logoutclick);
		
		driver.close();
	}
}