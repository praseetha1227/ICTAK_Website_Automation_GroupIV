package org.ictak.testcases;

import java.io.IOException;

import org.ictak.base.BaseClass;
import org.ictak.pages.LoginPage;
import org.ictak.pages.Testimonial;
import org.ictak.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestimonyTC extends BaseClass
{
	Testimonial testimonial;
	LoginPage loginPage;

	@BeforeClass
	public void Login()
	{
		loginPage = new LoginPage(driver, wait);
		loginPage.login();
		loginPage.signin(1);
	}
	
	@Test(priority=0)
	public void TestimonialSearch() throws IOException
	{
		testimonial = new Testimonial(driver,wait);
		
		boolean testclick = testimonial.TestimonialClick();
        
        Assert.assertEquals(true, testclick);
        
        String actual = ExcelUtility.getTestimonial(0, 0);
		
		String expected = testimonial.Search();
		
		Assert.assertEquals(actual, expected);
		
		boolean viewClick = testimonial.ViewTestimony();
      
        Assert.assertEquals(true, viewClick);

	}
	
	@Test(priority=1)
	public void EditUser() throws IOException
	{
		boolean testclick = testimonial.TestimonialClick();
        
        Assert.assertEquals(true, testclick);
        
        String actual = ExcelUtility.getTestimonial(0, 0);
		
		String expected = testimonial.Search();
		
		Assert.assertEquals(actual, expected);
		
		boolean editclick = testimonial.Edit();
        
        Assert.assertEquals(true, editclick);
        
        testimonial.SetNewValues();
        
        boolean editresult = testimonial.UpdateClick();
        
        Assert.assertEquals(true, editresult);
		
	}
	
	@Test(priority=2)
	public void DeleteUser() throws InterruptedException, IOException
	{
		String actual = ExcelUtility.getTestimonial(0, 0);
		
		String expected = testimonial.Search();
		
		Assert.assertEquals(actual, expected);		
		
		boolean deleteclick1 = testimonial.Delete();
        
        Assert.assertEquals(true, deleteclick1);
                
        boolean canceldelete = testimonial.CancelDelete();
        
        Assert.assertEquals(true, canceldelete);
		
        Thread.sleep(2000);
        
        expected = testimonial.Search();
        
		Assert.assertEquals(actual, expected);		

        boolean deleteclick = testimonial.Delete();
        
        Assert.assertEquals(true, deleteclick);
                
        boolean confirmdelete = testimonial.ConfirmDelete();
        
        Assert.assertEquals(true, confirmdelete);
        
	}
	
	@Test(priority=3)
	public void AddTestimony() throws InterruptedException
	{
		Thread.sleep(1000);
		
        boolean newtestclick = testimonial.NewTestimonialclick();
        
        Assert.assertEquals(true, newtestclick);
        
        testimonial.SetValues();
        
	}
	
	@AfterClass
	public void Logout() throws InterruptedException
	{
		Thread.sleep(1000);

		boolean logoutclick = testimonial.Logout();

		Assert.assertEquals(true, logoutclick);
		
		driver.close();
	}
}

