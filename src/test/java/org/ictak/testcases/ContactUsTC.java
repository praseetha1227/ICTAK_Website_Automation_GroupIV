package org.ictak.testcases;
import org.ictak.base.BaseClass;
import org.ictak.pages.ContactUS;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ContactUsTC extends BaseClass {

	ContactUS contact;

	@Test(priority=0)
	public void iconclick()
	{
		contact = new ContactUS(driver,wait);
		
		boolean contactclick = contact.iconclick();
        
	    Assert.assertEquals(true, contactclick);
	}

	// verifying submitting contact us form with valid details

	@Test(priority=1)
	public void validcontactusform() {

		boolean status = contact.validcontactusform();
		
		Assert.assertEquals(true, status);

		// Switch to the alert
		Alert alert = driver.switchTo().alert();
		// Get the text of the alert
		String alertMessage = alert.getText();
		// Perform your assertion with the expected alert message
		String expectedAlertMessage = "Message Send! Our Expert Team will Contact you Soon!";
		Assert.assertEquals(alertMessage, expectedAlertMessage);
		alert.accept();
		System.out.println("Test Case Passed");
	}
	//checking if invalid contact us form is getting submitted by entering invalid emailId

	@Test(priority = 2)
	public void invalidcontactusform() throws AssertionError, InterruptedException
	{
		Thread.sleep(2000);
		
		boolean status = contact.invalidcontactusform();
		
		String expectedErrortMessage = "Message cannot be send ,please enter a valid emailId";
		Alert alert = driver.switchTo().alert();
		String actualerrormessage = alert.getText();
		alert.accept();
		
		Assert.assertEquals(false, status);

		Assert.assertEquals(actualerrormessage,expectedErrortMessage);
		System.out.println("Test Case Failed");
	}
	@Test(priority=3)
	public void socialmediaclick()
	{
		String expectedfbtitle = "ICT Academy of Kerala | Thiruvananthapuram";
		String expectedinstatitle = "ICT Academy of Kerala (@ictkerala) • Instagram photos and videos";
		
		String actualfbtitle = contact.facebookclick();
		Assert.assertEquals(actualfbtitle,expectedfbtitle);
		
		driver.navigate().back();
		
		String actualinstatitle = contact.instaclick();
		Assert.assertEquals(actualinstatitle,expectedinstatitle);
		
	}
	
	@AfterClass
	public void Quit()
	{
		driver.close();
	}

}

