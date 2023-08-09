package org.ictak.pages;

import java.io.IOException;
import java.util.List;

import org.ictak.utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Events {

	WebDriver driver;
	WebDriverWait wait;

	public Events(WebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	//Events web elements

	@FindBy(xpath = "//a[contains(text(), 'Events')]")
	WebElement events;

	@FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[5]/ul/div[1]/ul")
	List<WebElement> eventlist;

	@FindBy(xpath = "//button[contains(text(), ' Apply Now ')]")
	WebElement applybutton;

	@FindBy(xpath = "//input[@name='name']")
	WebElement eventName;

	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement eventEmail;

	@FindBy(xpath = "//input[@name='phoneno']")
	WebElement eventPhone;

	@FindBy(xpath = "//button[contains(text(), 'Register')]")
	WebElement eventRegister;

	List<WebElement> eventsElements; 

	//Events functionalities

	public boolean Eventsclick()
	{
		events.click();

		return true;

	}

	public boolean Eventlist()
	{
		eventsElements = eventlist;

		System.out.println("Count :" + eventsElements.size());

		WebElement selectElement = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//*[@id=\"navigation\"]/ul/li[5]/ul/div[1]/ul/li[1]")));
		selectElement.click();

		return true;
	}

	public String Eventsstatus()
	{
		driver.navigate().refresh();

		wait.until(ExpectedConditions.elementToBeClickable(applybutton));

		if(applybutton.getText().equalsIgnoreCase("Apply Now"))
			applybutton.click();

		return applybutton.getText();

	}

	public boolean Eventsregister(int i)
	{		
		boolean status = false;

		wait.until(ExpectedConditions.elementToBeClickable(eventName));

		try
		{
			eventName.sendKeys(ExcelUtility.getEvents(i, 0));
			eventEmail.sendKeys(ExcelUtility.getEvents(i, 1));
			eventPhone.sendKeys(ExcelUtility.getEvents(i, 2));

			status = eventRegister.isEnabled();

			if(eventRegister.isEnabled())
				eventRegister.click();

		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}
}
