package org.ictak.testcases;
import java.io.IOException;

import org.ictak.base.BaseClass;
import org.ictak.pages.Courses;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CoursesTC extends BaseClass
{

	Courses courses;

	@Test(priority=0)
	public void Courseclick() throws IOException
	{
		courses = new Courses(driver,wait);
		
		boolean courseclick = courses.Courseclick();
	        
	    Assert.assertEquals(true, courseclick);
	}
	
	@Test(priority=1)
	public void CourseSearch() throws IOException, InterruptedException
	{		
		for(int i = 0;i <= 1; i++)
		{
			boolean status = courses.SearchCourse(i);
			
			if(i==0)
				Assert.assertEquals(true, status);
			else
				Assert.assertEquals(false, status);
		}
	}

	@Test(priority=2)
	public void CourseRegister()
	{
		boolean courseItemclick = courses.Courselist();
        
	    Assert.assertEquals(true, courseItemclick);
	    
	    String courseStatus = courses.Coursestatus();
        
	    Assert.assertEquals("APPLY NOW", courseStatus);
	    
		for(int i = 2;i<=8;i++)
		{
			boolean status = courses.Courseregister(i);
			
			switch(i)
			{
				case 2:
					Alert alert = driver.switchTo().alert();
					String alertMessage = alert.getText();
					String expectedAlertMessage = "Registration Successfull";
					Assert.assertEquals(alertMessage, expectedAlertMessage);
					alert.accept();
					break;
	
				case 3:
					Assert.assertEquals(false, status);
					driver.navigate().refresh();
					break;
	
				case 4:
					Assert.assertEquals(false, status);
					driver.navigate().refresh();
					break;
	
				case 5:
					Assert.assertEquals(false, status);
					driver.navigate().refresh();
					break;
	
				case 6:
					Assert.assertEquals(false, status);
					driver.navigate().refresh();
					break;
	
				case 7:
					Alert alert1 = driver.switchTo().alert();
					alert1.accept();
					driver.navigate().refresh();
					Assert.assertEquals(false, status);
					break;	
	
				case 8:
					Alert alert2 = driver.switchTo().alert();
					alert2.accept();
					driver.navigate().refresh();
					Assert.assertEquals(false, status);
					break;

			}
			
			if(i < 8)
			{
				courseStatus = courses.Coursestatus();
		        
			    Assert.assertEquals("APPLY NOW", courseStatus);
			}
			
		}
	}
	
	@AfterClass
	public void Quit()
	{
		driver.close();
	}

}	
