package org.ictak.pages;

import java.io.IOException;
import java.util.List;

import org.ictak.utilities.ExcelUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Courses
{
	WebDriver driver;
	WebDriverWait wait;

	public Courses(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	// Courses web elements
	@FindBy(xpath = "//*[@id=\"dropdownMenuBlocks\"]")
	WebElement course;

	@FindBy(xpath = "//ul[@aria-labelledby='dropdownMenuBlocks']")
	List<WebElement> courselist;

	@FindBy(xpath = "//button[contains(text(),' Apply Now ')]")
	WebElement statusButton;

	@FindBy(xpath = "//input[@name='name']")
	WebElement candidateName;

	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement candidateEmail;

	@FindBy(xpath = "//input[@name='phoneno']")
	WebElement candidatePhone;

	@FindBy(xpath = "//button[contains(text(), 'Register')]")
	WebElement courseRegister;

	@FindBy(xpath = "//input[@id='listSearch']")
	WebElement searchtext;

	@FindBy(xpath = "//h5[contains(text(),'No Results Found')]")
	WebElement searchresult;

	List<WebElement> courseElements;



	// Course functionalities
	public boolean Courseclick()
	{
		course.click();

		return true;
	}

	public boolean SearchCourse(int i) throws IOException
	{
		searchtext.sendKeys(ExcelUtility.getCourses(i, 0));

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");

		if(i == 0)
		{
			wait.until(ExpectedConditions.visibilityOf(searchtext));
			searchtext.clear();
			
			return searchtext.isDisplayed();
		}
		else
			return false;
	}

	public boolean Courselist()
	{
		courseElements = courselist;

		courseElements.get(0).click();

		return true;
	}

	public String Coursestatus()
	{
		wait.until(ExpectedConditions.visibilityOf(statusButton));

		if(statusButton.getText().equalsIgnoreCase("Apply Now"))
			statusButton.click();

		return statusButton.getText();
	}

	public boolean Courseregister(int i)
	{	
		boolean status = false;

		wait.until(ExpectedConditions.visibilityOf(candidateName));

		try
		{
			candidateName.sendKeys(ExcelUtility.getCourses(i, 0));
			candidateEmail.sendKeys(ExcelUtility.getCourses(i, 1));
			candidatePhone.sendKeys(ExcelUtility.getCourses(i, 2));

			status = courseRegister.isEnabled();

			if(courseRegister.isEnabled())
				courseRegister.click();

		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 

		return status;
	}
}