package org.ictak.testcases;

import org.ictak.base.BaseClass;
import org.ictak.pages.Events;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class EventsTC extends BaseClass {
	
	Events events;
	

	@Test(priority=0)
	public void Eventclick()
	{
		events = new Events(driver, wait);
		
		boolean eventclick = events.Eventsclick();

	    Assert.assertEquals(true, eventclick);
	    
	    boolean eventItemclick = events.Eventlist();
        
	    Assert.assertEquals(true, eventItemclick);
	    
	    String eventStatus= events.Eventsstatus();
        
	    Assert.assertEquals("APPLY NOW", eventStatus);
	}

	@Test(priority=1)
	public void EventsRegister()
	{
		for(int i = 0; i<= 5; i++)
		{
			boolean status = events.Eventsregister(i);

			switch(i)
			{
				case 0:
					Alert alert = driver.switchTo().alert();
					String alertMessage = alert.getText();
					String expectedAlertMessage = "Registration Successfull";
					Assert.assertEquals(alertMessage, expectedAlertMessage);
					alert.accept();
					break;
	
				case 1:
					Assert.assertEquals(false, status);
					driver.navigate().refresh();
					break;
	
				case 2:
					Assert.assertEquals(false, status);
					driver.navigate().refresh();
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
					Alert alert1 = driver.switchTo().alert();
					alert1.accept();
					driver.navigate().refresh();
					Assert.assertEquals(false, status);
					break;	
			}
			
			String eventStatus= events.Eventsstatus();
	        
		    Assert.assertEquals("APPLY NOW", eventStatus);
		}
	}

	@AfterClass
	public void Quit()
	{
		driver.close();
	}

}
