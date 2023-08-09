package org.ictak.pages;

import java.io.IOException;

import org.ictak.utilities.ExcelUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUS {

	WebDriver driver;
	WebDriverWait wait;
	
	public ContactUS(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath ="//a[@href='/LandingPage/contactus']")
	WebElement contactusicon;

	@FindBy(name="name")
	WebElement name;

	@FindBy(xpath="//input[@placeholder='Email id']") 
	WebElement email;

	@FindBy(name="coursename") 
	WebElement lookingfor;

	@FindBy(name="subject")
	WebElement message;

	@FindBy(xpath="//button[contains(text(),'Send Message')]")
	WebElement sendmessage;
	
	@FindBy(xpath = "//i[@class='fab fa-facebook text-lg text-white me-4']")
	WebElement facebook;
	
	@FindBy(xpath = "//i[@class='fab fa-instagram text-lg text-white me-4']")
	WebElement instagram;

	public boolean iconclick()
	{	
		contactusicon.click();
		
		return true;
	}

	public boolean validcontactusform()
	{	
		boolean status = false;

		try
		{     

			name.sendKeys(ExcelUtility.getContactusdata(0, 0));
			email.sendKeys(ExcelUtility.getContactusdata(0, 1));
			lookingfor.sendKeys(ExcelUtility.getContactusdata(0, 2));
			message.sendKeys(ExcelUtility.getContactusdata(0, 3));

			((JavascriptExecutor)driver).executeScript("scroll(0,600)");
			 
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(sendmessage));

			status = sendmessage.isEnabled();
			
			sendmessage.click();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean invalidcontactusform()
	{		
		
		boolean status = false;

		try
		{     
			name.clear();
			email.clear();
			lookingfor.clear();
			message.clear();
			
			name.sendKeys(ExcelUtility.getContactusdata(1, 0));
			email.sendKeys(ExcelUtility.getContactusdata(1, 1));
			lookingfor.sendKeys(ExcelUtility.getContactusdata(1, 2));
			message.sendKeys(ExcelUtility.getContactusdata(1, 3));
			
			((JavascriptExecutor)driver).executeScript("scroll(0,600)");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(sendmessage));

			status = sendmessage.isEnabled();
			
			sendmessage.click();

		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public String facebookclick()
	{
		wait.until(ExpectedConditions.elementToBeClickable(facebook));

		facebook.click();
		return driver.getTitle();
	}
	
	public String instaclick()
	{
		wait.until(ExpectedConditions.elementToBeClickable(instagram));

		instagram.click();
		return driver.getTitle();
	}

}