package org.ictak.pages;
import java.io.IOException;
import org.ictak.utilities.ExcelUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class LoginPage
{
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement LOGIN;

	@FindBy(name="email")
	WebElement Email;

	@FindBy(name="password")
	WebElement Password;

	@FindBy(xpath="//button[@type='submit']")
	WebElement SignIn;

	@FindBy(xpath = "//h2[contains( text(),'Warning')]")
	WebElement warning;
	
	@FindBy(xpath = "//h2[contains( text(),'Successfully Logged In')]")
	WebElement successful;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement okbtn;
	
	
	
	public boolean login()
	{
		LOGIN.click();
		
		return true;
	}
	
	public boolean signin(int i)
	{
		Email.clear();
		Password.clear();
		
		try {
			Email.sendKeys(ExcelUtility.getCredential(i, 0));
			Password.sendKeys(ExcelUtility.getCredential(i, 1));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SignIn.click();
		
		boolean result = false;
		
		switch(i) 
		{
			case 0:
				wait.until(ExpectedConditions.visibilityOf(warning));
				result = warning.isDisplayed();
				break;
			
			case 1:
				wait.until(ExpectedConditions.visibilityOf(successful));
				result = successful.isDisplayed();
				break;
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

}












