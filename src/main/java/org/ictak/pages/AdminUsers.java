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
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminUsers
{
	WebDriver driver;
	WebDriverWait wait;

	public AdminUsers(WebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@routerlink='/adminpage/admin-user']")
	WebElement adminusers;

	@FindBy(xpath = "//a[@routerlink='/adminpage/add-admin-user']")
	WebElement newadmin;

	@FindBy(xpath = "//input[@name='usrname']")
	WebElement username;

	@FindBy(xpath = "//input[@formcontrolname='Fname']")
	WebElement fname;

	@FindBy(xpath = "//input[@formcontrolname='Lname']")
	WebElement lname;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	WebElement email;

	@FindBy(xpath = "//input[@formcontrolname='designation']")
	WebElement designation;

	@FindBy(xpath = "//input[@formcontrolname='pwd']")
	WebElement password;

	@FindBy(xpath = "//input[@id='superAdmin']")
	WebElement fullaccess;

	@FindBy(xpath = "//input[@id='addAccess']")
	WebElement addaccess;

	@FindBy(xpath = "//input[@id='editAccess']")
	WebElement editaccess;

	@FindBy(xpath = "//input[@id='deleteAccess']")
	WebElement deleteaccess;

	@FindBy(xpath = "//button[@title='Next']")
	WebElement add;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement successbtn;

	@FindBy(xpath = "//input[@id='listSearch']")
	WebElement searchfield;

	@FindBy(xpath = "//table[@class='table align-items-center mb-0']")
	WebElement usertable;

	List<WebElement> userlist;

	@FindBy(xpath = "//input[@name='username']")
	WebElement eusername;

	@FindBy(xpath = "//input[@name='first']")
	WebElement efname;

	@FindBy(xpath = "//input[@name='last']")
	WebElement elname;

	@FindBy(xpath = "//input[@name='email']")
	WebElement editemail;

	@FindBy(xpath = "//input[@name='des']")
	WebElement edesignation;

	@FindBy(xpath = "//input[@name='pass']")
	WebElement epassword;

	@FindBy(xpath = "//button[contains(text(),'Yes, Delete it!')]")
	WebElement confirmdelete;

	@FindBy(xpath = "//button[contains(text(),'No, cancel please!')]")
	WebElement canceldelete;

	@FindBy(xpath = "/html/body/app-root/app-view-admin-user/body/main/div/div/div/div/div/div/div[2]/h3[2]")
	WebElement userName;

	@FindBy(xpath="//a[@href='#ProfileNav']")
	WebElement ICTAKAdmin;

	@FindBy(xpath="//*[@id=\"ProfileNav\"]/ul/li/a")
	WebElement LOGOUT;

	public boolean AdminClick()
	{
		adminusers = wait.until(ExpectedConditions.visibilityOf(adminusers));

		adminusers.click();

		return true;
	}

	public boolean NewAdminclick()
	{
		newadmin = wait.until(ExpectedConditions.
				visibilityOf(newadmin));

		newadmin.click();

		return true;

	}

	public void SetValues()
	{

		wait.until(ExpectedConditions.visibilityOf(username));


		try {
			username.sendKeys(ExcelUtility.getAdminusers(0, 0));
			fname.sendKeys(ExcelUtility.getAdminusers(0, 1));
			lname.sendKeys(ExcelUtility.getAdminusers(0, 2));
			email.sendKeys(ExcelUtility.getAdminusers(0, 3));
			designation.sendKeys(ExcelUtility.getAdminusers(0, 4));
			password.sendKeys(ExcelUtility.getAdminusers(0, 5));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			//Scroll down till the bottom of the page
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			wait.until(ExpectedConditions.visibilityOf(fullaccess));
			wait.until(ExpectedConditions.visibilityOf(addaccess));
			wait.until(ExpectedConditions.visibilityOf(editaccess));
			wait.until(ExpectedConditions.visibilityOf(deleteaccess));

			if(ExcelUtility.getAdminusers(0, 6).equalsIgnoreCase("1"))
				fullaccess.click();
			if(ExcelUtility.getAdminusers(0, 7).equalsIgnoreCase("1"))
				addaccess.click();
			if(ExcelUtility.getAdminusers(0, 8).equalsIgnoreCase("1"))
				editaccess.click();
			if(ExcelUtility.getAdminusers(0, 9).equalsIgnoreCase("1"))
				deleteaccess.click();

			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean AddUser()
	{
		add.click();

		wait.until(ExpectedConditions.visibilityOf(successbtn));


		boolean result = successbtn.isDisplayed();

		successbtn.click();

		return result;
	}

	public void SetInvalidValues()
	{
		wait.until(ExpectedConditions.visibilityOf(username));

		try {
			username.sendKeys(ExcelUtility.getAdminusers(1, 0));
			fname.sendKeys(ExcelUtility.getAdminusers(1, 1));
			lname.sendKeys(ExcelUtility.getAdminusers(1, 2));
			email.sendKeys(ExcelUtility.getAdminusers(1, 3));
			designation.sendKeys(ExcelUtility.getAdminusers(1, 4));
			password.sendKeys(ExcelUtility.getAdminusers(1, 5));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			//Scroll down till the bottom of the page
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			wait.until(ExpectedConditions.visibilityOf(fullaccess));
			wait.until(ExpectedConditions.visibilityOf(addaccess));
			wait.until(ExpectedConditions.visibilityOf(editaccess));
			wait.until(ExpectedConditions.visibilityOf(deleteaccess));

			if(ExcelUtility.getAdminusers(1, 6).equalsIgnoreCase("1"))
				fullaccess.click();
			if(ExcelUtility.getAdminusers(1, 7).equalsIgnoreCase("1"))
				addaccess.click();
			if(ExcelUtility.getAdminusers(1, 8).equalsIgnoreCase("1"))
				editaccess.click();
			if(ExcelUtility.getAdminusers(1, 9).equalsIgnoreCase("1"))
				deleteaccess.click();

			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean AddInvalidUser()
	{
		add.click();

		wait.until(ExpectedConditions.visibilityOf(successbtn));

		Boolean result = successbtn.isDisplayed();

		successbtn.click();

		return result;

	}

	public String Search(int i)
	{
		String title = "";

		try 
		{		
			wait.until(ExpectedConditions.visibilityOf(searchfield));

			searchfield.clear();

			searchfield.sendKeys(ExcelUtility.getAdminusers(i, 0));	
			
			userlist = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(usertable, By.tagName("tbody")));

			WebElement row = userlist.get(0).findElement(By.tagName("tr"));
			
			List<WebElement> columns = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(row, By.tagName("td")));
			
			WebElement testtitle = columns.get(1).findElement(By.tagName("p"));
			
			title = testtitle.getText();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return title;

	}

	public boolean Edit()
	{
		System.out.println("Inside edit");

		userlist = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(usertable, By.tagName("tbody")));

		System.out.println("Count : "+ userlist.size());

		for(int i = 0; i<userlist.size()-1; i++)
		{
			WebElement row = userlist.get(i).findElement(By.tagName("tr"));
			
			List<WebElement> columns = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(row, By.tagName("td")));
			
			WebElement title = columns.get(1).findElement(By.tagName("p"));	
			
			WebElement editbtn = userlist.get(i).findElement(By.xpath("//i[@title='Edit the Course']"));

			try 
			{

				if(title.getText().equalsIgnoreCase(ExcelUtility.getAdminusers(0, 0)))
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

	public void ResetValues()
	{
		eusername.clear();
		efname.clear();
		elname.clear();
		editemail.clear();
		edesignation.clear();
		epassword.clear();

		try {
			
			eusername.clear();
			efname.clear();
			elname.clear();
			editemail.clear();
			edesignation.clear();
			epassword.clear();

			eusername.sendKeys(ExcelUtility.getAdminusers(2, 0));
			efname.sendKeys(ExcelUtility.getAdminusers(2, 1));
			elname.sendKeys(ExcelUtility.getAdminusers(2, 2));
			editemail.sendKeys(ExcelUtility.getAdminusers(2, 3));
			edesignation.sendKeys(ExcelUtility.getAdminusers(2, 4));
			epassword.sendKeys(ExcelUtility.getAdminusers(2, 5));

			JavascriptExecutor njs = (JavascriptExecutor) driver;
			//Scroll down till the bottom of the page
			njs.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			wait.until(ExpectedConditions.elementToBeClickable(add));

		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean UpadateUser()
	{	
		System.out.println("Update click");

		add.click();

		wait.until(ExpectedConditions.visibilityOf(successbtn));

		Boolean result = successbtn.isDisplayed();

		successbtn.click();

		return result;
	}

	public boolean Delete()
	{

		userlist = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(usertable, By.tagName("tbody")));

		System.out.println("Inside click");

		for(int i = 0; i<userlist.size()-1; i++)
		{
			WebElement row = userlist.get(i).findElement(By.tagName("tr"));
			
			List<WebElement> columns = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(row, By.tagName("td")));
			
			WebElement title = columns.get(1).findElement(By.tagName("p"));		
			
			WebElement deletebtn = userlist.get(i).findElement(By.xpath("//i[@title='Delete the Course']"));

			try 
			{
				if(title.getText().equalsIgnoreCase(ExcelUtility.getAdminusers(1, 0)))
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

	public boolean ViewUser()
	{	
		userlist = new WebDriverWait(driver, Duration.ofMillis(10)).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(usertable, By.tagName("tbody")));

		WebElement viewbtn = userlist.get(0).findElement(By.xpath("//i[@title='View the Course']"));

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