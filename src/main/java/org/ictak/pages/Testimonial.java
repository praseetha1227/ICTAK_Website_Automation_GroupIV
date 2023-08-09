package org.ictak.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.ictak.utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Testimonial
{
	WebDriver driver;
	WebDriverWait wait;

	public Testimonial(WebDriver driver, WebDriverWait wait)	
	{
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@routerlink='/adminpage/testimony']")
	WebElement testimonial;

	@FindBy(xpath = "//a[contains(text(),'New Testimony')]")
	WebElement newtestimony;

	@FindBy(xpath="//input[@name='name']")
	WebElement testimoniname;

	@FindBy(xpath="//input[@name='nam']")
	WebElement etestimoniname;

	@FindBy(xpath = "//input[@name='org']")
	WebElement organization;

	@FindBy(xpath = "//textarea[@formcontrolname='testi']")
	WebElement description;

	@FindBy(xpath = "//select[@formcontrolname='title']")
	Select coursetitle;

	@FindBy(xpath = "//input[@formcontrolname='img']")
	WebElement chooseImage;

	@FindBy(xpath = "//button[@title='Next']")
	WebElement addBtn;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement successbtn;

	@FindBy(xpath = "//input[@id='listSearch']")
	WebElement searchfield;

	@FindBy(xpath = "//table[@class='table align-items-center mb-0']")
	WebElement testimonytable;

	@FindBy(xpath = "//button[contains(text(),'Yes, Delete it!')]")
	WebElement confirmdelete;

	@FindBy(xpath = "//button[contains(text(),'No, Cancel please!')]")
	WebElement canceldelete;


	List<WebElement> testimonylist;

	@FindBy(xpath="//a[@href='#ProfileNav']")
	WebElement ICTAKAdmin;

	@FindBy(xpath="//*[@id=\"ProfileNav\"]/ul/li/a")
	WebElement LOGOUT;
	
	@FindBy(xpath = "//span[contains (text(), 'Please enter testimonial')]")
	WebElement descriptionerror;
	
	@FindBy(xpath = "//span[contains (text(), 'Please enter testimoni name')]")
	WebElement nameerror;
	
	@FindBy(xpath = "//span[contains (text(), 'Please enter Organisation')]")
	WebElement orgnznerror;
	
	@FindBy(xpath = "//span[contains (text(), 'Please insert image')]")
	WebElement imageerror;
	

	public boolean TestimonialClick()
	{	
		wait.until(ExpectedConditions.visibilityOf(testimonial));
		
		testimonial.click();
		
		return true;
	}

	public boolean NewTestimonialclick()
	{
		wait.until(ExpectedConditions.visibilityOf(newtestimony));
		
		newtestimony.click();
		
		return true;
	}

	public void SetValues()
	{
		for(int i=0; i<=3; i++)
		{
			try {
				testimoniname.sendKeys(ExcelUtility.getTestimonial(i, 0));
				organization.sendKeys(ExcelUtility.getTestimonial(i, 1));
				description.sendKeys(ExcelUtility.getTestimonial(i, 2));

				JavascriptExecutor js = (JavascriptExecutor) driver;
				//Scroll down till the bottom of the page
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

				coursetitle = new Select(driver.findElement(By.xpath("//select[@formcontrolname='title']")));
				coursetitle.selectByIndex(Integer.parseInt(ExcelUtility.getTestimonial(i, 3)));

				if(i != 3)
					chooseImage.sendKeys(ExcelUtility.getTestimonial(i, 4));

				switch(i)
				{
					case 0:
						addBtn.click();
						
						wait.until(ExpectedConditions.visibilityOf(successbtn));
						
						Assert.assertEquals(true, successbtn.isDisplayed());
						
						successbtn.click();
						
						wait.until(ExpectedConditions.visibilityOf(newtestimony));

						newtestimony.click();
						
						break;
	
					case 1:
						wait.until(ExpectedConditions.visibilityOf(descriptionerror));
						
						Assert.assertEquals(true, descriptionerror.isDisplayed());
						
						addBtn.click();
						
						wait.until(ExpectedConditions.visibilityOf(successbtn));

						successbtn.click();
						
						Boolean visibility = successbtn.isDisplayed();

						wait.until(ExpectedConditions.visibilityOf(newtestimony));

						newtestimony.click();
						
						Assert.assertEquals(false, visibility);
						
						break;
	
					case 3:
						
						Boolean visibility1 = addBtn.isEnabled();
						
						Assert.assertEquals(false, visibility1);

						break;
	
					case 2:
						addBtn.click();
						
						wait.until(ExpectedConditions.visibilityOf(successbtn));

						Boolean visibility2 = successbtn.isDisplayed();

						successbtn.click();

						wait.until(ExpectedConditions.visibilityOf(newtestimony));

						newtestimony.click();
						
						Assert.assertEquals(false, visibility2);
					
						break;
	
				}
				
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			catch (AssertionError e) 
			{
				e.printStackTrace();
			}
		}
	}

	

	public boolean Edit()
	{

		testimonylist = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(testimonytable, By.tagName("tbody")));

		for(int i = 0; i<testimonylist.size()-1; i++)
		{
			WebElement row = testimonylist.get(i).findElement(By.tagName("tr"));
			
			List<WebElement> columns = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(row, By.tagName("td")));
			
			WebElement editbtn = testimonylist.get(i).findElement(By.xpath("//i[@routerlink='/adminpage/edit-testimony']"));

			WebElement title = columns.get(1).findElement(By.tagName("p"));
			
			try 
			{
				if(title.getText().equalsIgnoreCase(ExcelUtility.getTestimonial(0, 0)))
				{
					editbtn.click();
					
					return true;
				}
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	public void SetNewValues()
	{
		try 
		{
			etestimoniname.clear();
			organization.clear();
			description.clear();

			etestimoniname.clear();

			etestimoniname.sendKeys(ExcelUtility.getTestimonial(4, 0));
			organization.sendKeys(ExcelUtility.getTestimonial(4, 1));
			description.sendKeys(ExcelUtility.getTestimonial(4, 2));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			//Scroll down till the bottom of the page
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			Thread.sleep(1000);

			coursetitle = new Select(driver.findElement(By.name("title")));
			coursetitle.selectByIndex(Integer.parseInt(ExcelUtility.getTestimonial(1, 3)));

			chooseImage.sendKeys(ExcelUtility.getTestimonial(4, 4));
			

		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean UpdateClick()
	{
		addBtn.click();

		wait.until(ExpectedConditions.visibilityOf(successbtn));

		Boolean result = successbtn.isDisplayed();

		successbtn.click();

		return result;
	}

	public boolean Delete()
	{
		testimonylist = new WebDriverWait(driver, Duration.ofMillis(10)).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(testimonytable, By.tagName("tbody")));

		for(int i = 0; i<testimonylist.size()-1; i++)
		{
			WebElement row = testimonylist.get(i).findElement(By.tagName("tr"));
			
			List<WebElement> columns = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(row, By.tagName("td")));
			
			WebElement title = columns.get(1).findElement(By.tagName("p"));

			WebElement deletebtn = testimonylist.get(i).findElement(By.xpath("//i[@title='Delete the Course']"));

			try 
			{
				if(title.getText().equalsIgnoreCase(ExcelUtility.getTestimonial(0, 0)))
				{
					deletebtn.click();

					return true;
				}
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	public boolean ConfirmDelete()
	{
		wait.until(ExpectedConditions.visibilityOf(confirmdelete));

		confirmdelete.click();

		wait.until(ExpectedConditions.visibilityOf(successbtn));

		Boolean result = successbtn.isDisplayed();

		successbtn.click();

		return result;
	}

	public boolean CancelDelete()
	{
		wait.until(ExpectedConditions.visibilityOf(canceldelete));

		canceldelete.click();

		wait.until(ExpectedConditions.visibilityOf(successbtn));

		Boolean result = successbtn.isDisplayed();

		successbtn.click();

		return result;
	}
	
	public String Search()
	{
		String title = "";

		try 
		{		
			wait.until(ExpectedConditions.visibilityOf(searchfield));

			searchfield.clear();

			searchfield.sendKeys(ExcelUtility.getTestimonial(0, 0));	
			
			testimonylist = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(testimonytable, By.tagName("tbody")));

			WebElement row = testimonylist.get(0).findElement(By.tagName("tr"));
			
			List<WebElement> columns = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(row, By.tagName("td")));
			
			WebElement testtitle = columns.get(1).findElement(By.tagName("p"));
			
			title = testtitle.getText();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return title;

	}

	public boolean ViewTestimony()
	{
		testimonylist = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(testimonytable, By.tagName("tbody")));

		WebElement viewbtn  = testimonylist.get(0).findElement(By.xpath("//i[@class='fas fa-eye text-info' and @title='View the Course']"));

		viewbtn.click();
		
		return true;
		
	}
	
	public boolean Logout()
	{
		ICTAKAdmin.click();

		wait.until(ExpectedConditions.visibilityOf(LOGOUT));

		LOGOUT.click();

		return true;
	}

}
