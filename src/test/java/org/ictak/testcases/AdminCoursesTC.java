package org.ictak.testcases;

import java.io.IOException;

import org.ictak.base.BaseClass;
import org.ictak.pages.AdmincoursesPage;
import org.ictak.pages.LoginPage;
import org.ictak.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminCoursesTC extends BaseClass{

	AdmincoursesPage admincourses;
	LoginPage loginPage;

	@BeforeClass
	public void Login()
	{
		loginPage = new LoginPage(driver, wait);
		loginPage.login();
		loginPage.signin(1);
	}

	@Test(priority=0)
	public void VerifyvalidCoursesubmission() 
	{	
		admincourses=new AdmincoursesPage(driver,wait);

		boolean courseclick = admincourses.coursesClick();

		Assert.assertEquals(true, courseclick);

		boolean newcourseclick = admincourses.NewCourseslick();

		Assert.assertEquals(true, newcourseclick);

		admincourses.ValidDetails();
		
		boolean statusclick = admincourses.activeStatus();

		Assert.assertEquals(true, statusclick);

		boolean addresult = admincourses.AddcourseClick();
        
        Assert.assertEquals(true, addresult);
	}

	@Test(priority=1)
	public void VerifyInvalidCourseSubmission()
	{
		boolean courseclick = admincourses.coursesClick();

		Assert.assertEquals(true, courseclick);

		boolean newcourseclick = admincourses.NewCourseslick();

		Assert.assertEquals(true, newcourseclick);

		admincourses.InvalidDetails();
		
		boolean statusclick = admincourses.activeStatus();

		Assert.assertEquals(true, statusclick);

		boolean addresult = admincourses.AddcourseClick();
        
        Assert.assertEquals(false, addresult);

	}

	@Test(priority=2)
	public void VerifySerchfield() throws IOException
	{	
		String actual = ExcelUtility.getCoursesData(0, 0);
		
		String expected = admincourses.Search();
		
		Assert.assertEquals(actual, expected);
		
		boolean viewClick = admincourses.Viewcourse();
      
       Assert.assertEquals(true, viewClick);
		
	}
	
	@AfterClass
	public void Logout() throws InterruptedException
	{
		Thread.sleep(1000);

		boolean logoutclick = admincourses.Logout();

		Assert.assertEquals(true, logoutclick);
		
		driver.close();
	}
}



