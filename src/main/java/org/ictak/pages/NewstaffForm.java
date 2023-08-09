package org.ictak.pages;
import java.io.IOException;
import java.util.List;

import org.ictak.utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewstaffForm {

	WebDriver driver;
	WebDriverWait wait;
 
	public NewstaffForm(WebDriver driver,WebDriverWait wait)
	{
		this.driver = driver;

		this.wait = wait;
		
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//a[@routerlink='/adminpage/admin-user']")
	WebElement adminusers;
	
	@FindBy(xpath = "//ul[@id='myDiv']")
	WebElement menu;
	
	List<WebElement> items;


	@FindBy(xpath = "//a[@href='/adminpage/staffs']")
	WebElement stafficon;

	@FindBy(xpath = "//a[@href='/adminpage/add-staffs']")
	WebElement addstaff;

	@FindBy(name = "name")
	WebElement staffname;

	@FindBy(xpath = "//select[@name='des']")
	WebElement dropdownElement;

	@FindBy(name = "about")
	WebElement aboutstaff;

	@FindBy(name = "image")
	WebElement image;

	@FindBy(xpath = "//button[@title='Next']")
	WebElement addstaffbutton;
	
	@FindBy(xpath="//span[@class='mb-2']")
	WebElement errormessage;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement successbtn;

	@FindBy(xpath="//a[@href='#ProfileNav']")
	WebElement ICTAKAdmin;

	@FindBy(xpath="//*[@id=\"ProfileNav\"]/ul/li/a")
	WebElement LOGOUT;
	
	@FindBy(xpath="//span[contains (text(),'Please enter staff name')]")
	WebElement stafferrormsg;
	
	@FindBy(xpath = "//table[@class='table align-items-center mb-0']")
	WebElement usertable;

	List<WebElement> userlist;
	
	@FindBy(xpath = "//input[@id='listSearch']")
	WebElement searchfield;

	public boolean stafficonclick()
	{
		items = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(menu, By.tagName("li")));

		System.out.println(items.size());
		
		WebElement stafficon = items.get(11).findElement(By.tagName("a"));
		
		WebElement staff = stafficon.findElement(By.tagName("div"));

		staff.click();
		
		return true;
	}

	public boolean NewStaffclick()
	{
		wait.until(ExpectedConditions.visibilityOf(addstaff));

		addstaff.click();
		
		return true;
	}
	
	public void validstaffform() throws IOException {
				
		staffname.sendKeys(ExcelUtility.getStaffData(0, 0));
		
		// Initialize the Select class with the drop down element
		Select dropdowndesignation = new Select(dropdownElement);
		
		// Interact with the drop down list
		dropdowndesignation.selectByVisibleText("CEO");
		
		aboutstaff.sendKeys(ExcelUtility.getStaffData(0, 1));
		
		String imagePath = "C:\\Users\\91994\\Desktop\\1.png";

		image.sendKeys(imagePath);
	}
	
	public boolean AddStaffClick() throws TimeoutException
	{	
		wait.until(ExpectedConditions.elementToBeClickable(addstaffbutton));
	
		addstaffbutton.click();

		try
		{
			wait.until(ExpectedConditions.visibilityOf(successbtn));
			
			boolean status = successbtn.isEnabled();

			successbtn.click();

			return status;

		}
		catch (TimeoutException e)
		{
			return false;
		}
	}

	public void emptyimagefield() throws IOException
	{
		staffname.sendKeys(ExcelUtility.getStaffData(0, 0));
		
		// Initialize the Select class with the drop down element
		Select dropdowndesignation = new Select(dropdownElement);
		
		// Interact with the drop down list
		dropdowndesignation.selectByVisibleText("CEO");
		aboutstaff.sendKeys(ExcelUtility.getStaffData(0, 1));
	}
	
	
	public String Search()
	{
		String stafftitle = "";
		
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(searchfield));

			searchfield.sendKeys(ExcelUtility.getStaffData(0, 0));
			
			userlist = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(usertable, By.tagName("tbody")));

			WebElement row = userlist.get(0).findElement(By.tagName("tr"));
			
			List<WebElement> columns = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(row, By.tagName("td")));
			
			WebElement title = columns.get(1).findElement(By.tagName("p"));

			stafftitle = title.getText();


		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stafftitle;

	}


	public boolean ViewStaff()
	{
		userlist = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(usertable, By.tagName("tbody")));

		WebElement viewBtn = userlist.get(0).findElement(By.xpath("//i[@title='View the Course']"));

		viewBtn.click();
		
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
