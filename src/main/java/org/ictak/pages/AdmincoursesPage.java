package org.ictak.pages;
import java.io.IOException;
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

public class AdmincoursesPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public AdmincoursesPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='navbar-brand m-0']")
	WebElement ICTAKAdmin;

	@FindBy(xpath="//a[@href='/adminpage/courses']")
	WebElement AdminCourses;

	@FindBy(xpath="//a[@href='/adminpage/addcourses']")
	WebElement NewCourse;

	@FindBy(xpath="//input[@type='text' and @formcontrolname='title' and @name='title']")
	WebElement CourseTitle;

	@FindBy(xpath="//input[@type='text' and @formcontrolname='name' and @required and @name='title']")
	WebElement CourseShortName;

	@FindBy(xpath="//input[@type='text' and @formcontrolname='type' and @required and @name='title']")	
	WebElement CourseType;

	@FindBy(xpath="//div[@class='e-content e-lib e-keyboard' and @id='richtexteditor_2023600528_0_rte-edit-view' ]")
	WebElement ShortDescription;

	@FindBy(xpath="//select[@name='reg']")
	WebElement RegistraionStatus;

	@FindBy(xpath="//select[@name='cat']")
	WebElement CourseCategory;

	@FindBy(xpath="//div[@id='richtexteditor_2023600528_1_rte-edit-view']")//..
	WebElement AboutCourse;

	@FindBy(xpath="//input[@formcontrolname='entrance']")
	WebElement EntranceExamDate;

	@FindBy(xpath="//input[@formcontrolname='commencement']")
	WebElement CommencementDate;

	@FindBy(xpath="//input[@formcontrolname='orientation']")
	WebElement OrientationDate;

	@FindBy(xpath="//input[@formcontrolname='sdate']")
	WebElement LastDateForRegistration;

	@FindBy(xpath="//input[@formcontrolname='fee']")
	WebElement CourseFee;

	@FindBy(xpath="//input[@formcontrolname='regfee']")
	WebElement CourseRegistrationFee;

	@FindBy(xpath="//input[@formcontrolname='duration']")
	WebElement CourseDuration;

	@FindBy(xpath="//div[@id='richtexteditor_2023600528_2_rte-edit-view']")
	WebElement Objectives;

	@FindBy(xpath="//input[@name='que']")
	WebElement SampleEntranceQuestion;

	@FindBy(xpath="//input[@name='placelist']")
	WebElement PlacementList;

	@FindBy(xpath="//input[@name='intern']")
	WebElement InternshipCertificate;

	@FindBy(xpath="//input[@name='image']")
	WebElement ChooseImage;

	@FindBy(xpath="//input[@id='flexSwitchCheckDefault']")
	WebElement ActiveStatus;

	@FindBy(xpath="/html/body/app-root/app-courses/div/main/div/div/div/div/div[2]")
	WebElement CourseTble;

	@FindBy(xpath="//button[@class='btn bg-gradient-primary w-100 my-4 mb-2']")
	WebElement AddCourse;

	@FindBy(xpath="//button[@class='swal2-confirm swal2-styled']")
	WebElement SUCCESSBUTTON;
	
	@FindBy(xpath="//input[@id='listSearch']")
	WebElement searchfield;

	@FindBy(xpath="//i[@title='View the Course']")
	WebElement View;

	@FindBy(xpath="//i[@title='Edit the Course']")
	WebElement Edit;

	@FindBy(xpath="//button[@class='btn bg-gradient-success w-25 my-4 mb-2 m-3']")
	WebElement UpdateEdit;

	@FindBy(xpath="//button[@class='swal2-confirm swal2-styled']")
	WebElement EditSuccess;

	@FindBy(xpath="//i[@title='Delete the Course']")
	WebElement Delete;
	
	@FindBy(xpath="//*[@id=\"ProfileNav\"]/ul/li/a")
	WebElement LOGOUT;

	List<WebElement> Courselist;

	public boolean coursesClick()
	{
		wait.until(ExpectedConditions.visibilityOf(AdminCourses));

		AdminCourses.click();
		
		return true;
	}


	public boolean NewCourseslick()
	{
		wait.until(ExpectedConditions.visibilityOf(NewCourse));

		NewCourse.click();
		
		return true;
	}

	public void ValidDetails()
	{

		try {
			CourseTitle.sendKeys(ExcelUtility.getCoursesData(0, 0));
			CourseShortName.sendKeys(ExcelUtility.getCoursesData(0,1));
			CourseType.sendKeys(ExcelUtility.getCoursesData(0, 2));
			ShortDescription.sendKeys(ExcelUtility.getCoursesData(0, 3));
			RegistraionStatus.sendKeys(ExcelUtility.getCoursesData(0, 4));
			CourseCategory.sendKeys(ExcelUtility.getCoursesData(0, 5));
			AboutCourse.sendKeys(ExcelUtility.getCoursesData(0, 6));
			EntranceExamDate.sendKeys("18-08-2023");
			CommencementDate.sendKeys("20-07-2023");
			OrientationDate.sendKeys("12-08-2023");
			LastDateForRegistration.sendKeys("24-09-2023");
			CourseFee.sendKeys(ExcelUtility.getCoursesData(0,10));
			CourseRegistrationFee.sendKeys(ExcelUtility.getCoursesData(0,11));
			CourseDuration.sendKeys(ExcelUtility.getCoursesData(0, 12));
			Objectives.sendKeys(ExcelUtility.getCoursesData(0, 13));
			SampleEntranceQuestion.sendKeys(ExcelUtility.getCoursesData(0, 14));
			PlacementList.sendKeys(ExcelUtility.getCoursesData(0, 15));
			InternshipCertificate.sendKeys(ExcelUtility.getCoursesData(0, 16));
			ChooseImage.sendKeys(ExcelUtility.getCoursesData(0, 17));


			JavascriptExecutor js = (JavascriptExecutor) driver;
			//Scroll down till the bottom of the page
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean activeStatus()
	{
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		wait.until(ExpectedConditions.visibilityOf(ActiveStatus));
				
		ActiveStatus.click();
		
		boolean status = ActiveStatus.isSelected();

		return status;
	}

	public boolean AddcourseClick()
	{	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		wait.until(ExpectedConditions.elementToBeClickable(AddCourse));
		
		AddCourse.click();

		wait.until(ExpectedConditions.visibilityOf(SUCCESSBUTTON));

		boolean status = SUCCESSBUTTON.isDisplayed();

		SUCCESSBUTTON.click();
		
		return status;

	}
	
	public String Search()
	{
		String coursetitle = "";
		
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(searchfield));

			searchfield.sendKeys(ExcelUtility.getCoursesData(0, 0));
			
			Courselist = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(CourseTble, By.tagName("tbody")));

			WebElement row = Courselist.get(0).findElement(By.tagName("tr"));
			
			List<WebElement> columns = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(row, By.tagName("td")));
			
			WebElement title = columns.get(1).findElement(By.tagName("p"));

			coursetitle = title.getText();


		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return coursetitle;

	}


	public boolean Viewcourse()
	{
		Courselist = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(CourseTble, By.tagName("tbody")));

		View  = Courselist.get(0).findElement(By.xpath("//i[@class='fas fa-eye text-info' and @title='View the Course']"));

		View.click();
		
		return true;
	}



	public void InvalidDetails()
	{

		try {
			CourseTitle.sendKeys(ExcelUtility.getCoursesData(1, 0));
			CourseShortName.sendKeys(ExcelUtility.getCoursesData(1,1));
			CourseType.sendKeys(ExcelUtility.getCoursesData(1, 2));
			ShortDescription.sendKeys(ExcelUtility.getCoursesData(1, 3));
			RegistraionStatus.sendKeys(ExcelUtility.getCoursesData(1, 4));
			CourseCategory.sendKeys(ExcelUtility.getCoursesData(1, 5));
			AboutCourse.sendKeys(ExcelUtility.getCoursesData(1, 6));
			EntranceExamDate.sendKeys("18-08-2023");
			CommencementDate.sendKeys("20-07-2023");
			OrientationDate.sendKeys("12-08-2023");
			LastDateForRegistration.sendKeys("24-09-2023");
			CourseFee.sendKeys(ExcelUtility.getCoursesData(1,10));
			CourseRegistrationFee.sendKeys(ExcelUtility.getCoursesData(1,11));
			CourseDuration.sendKeys(ExcelUtility.getCoursesData(1, 12));
			Objectives.sendKeys(ExcelUtility.getCoursesData(0, 13));
			SampleEntranceQuestion.sendKeys(ExcelUtility.getCoursesData(1, 14));
			PlacementList.sendKeys(ExcelUtility.getCoursesData(1, 15));
			InternshipCertificate.sendKeys(ExcelUtility.getCoursesData(1, 16));
			ChooseImage.sendKeys(ExcelUtility.getCoursesData(1, 17));


			JavascriptExecutor js = (JavascriptExecutor) driver;
			//Scroll down till the bottom of the page
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public boolean Logout()
	{
		wait.until(ExpectedConditions.visibilityOf(ICTAKAdmin));

		ICTAKAdmin.click();

		wait.until(ExpectedConditions.visibilityOf(LOGOUT));

		LOGOUT.click();

		return true;
	}

}




