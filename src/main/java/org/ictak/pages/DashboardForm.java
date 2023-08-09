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

public class DashboardForm {

	WebDriver driver;
	WebDriverWait wait;
	
	public DashboardForm(WebDriver driver,WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}


	@FindBy(name = "todo")
	WebElement taskfield;

	@FindBy(name = "sds")
	WebElement plusbutton;

	List<WebElement> items;
	
    @FindBy(xpath = "//ul[@class='list-unstyled']") 
    WebElement list;
    
    @FindBy(xpath="//a[@href='#ProfileNav']")
	WebElement ICTAKAdmin;

	@FindBy(xpath="//*[@id=\"ProfileNav\"]/ul/li/a")
	WebElement LOGOUT;

	public int listSize() 
	{
		items = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(list, By.tagName("li")));

		System.out.println("Count :" + items.size());
		
		return items.size();
	}

	public void addItem() throws IOException, InterruptedException
	{
		taskfield.sendKeys(ExcelUtility.getDashBoardData(0, 0));
		Thread.sleep(3000);
		plusbutton.click();
	}

	public void deleteItem()
	{
		WebElement deletebtn = items.get(0).findElement(By.tagName("i"));

		deletebtn.click();
	}
	
	public boolean Logout()
	{
		ICTAKAdmin.click();

		wait.until(ExpectedConditions.visibilityOf(LOGOUT));

		LOGOUT.click();

		return true;
	}
	
}