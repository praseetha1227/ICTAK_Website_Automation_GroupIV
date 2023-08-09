package org.ictak.testcases;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

import org.ictak.base.BaseClass;
import org.ictak.pages.DashboardForm;
import org.ictak.pages.LoginPage;
import org.testng.Assert;


public class DashboardTC extends BaseClass {

	DashboardForm dashform;
	LoginPage loginPage;

	@BeforeClass
	public void Login()
	{
		loginPage = new LoginPage(driver, wait);
		loginPage.login();
		loginPage.signin(1);
	}
	
	// verifying adding an item into the task field
	@Test(priority = 0)
	public void addItem() throws IOException, InterruptedException {

		dashform = new DashboardForm(driver,wait);
		int initiallistsize = dashform.listSize();
		System.out.println(initiallistsize);
		dashform.addItem();
		Thread.sleep(5000);
		int updatedlistsize = dashform.listSize();
		System.out.println(updatedlistsize);

		Assert.assertEquals(initiallistsize + 1, updatedlistsize);
	}

	// verifying deleting an item from the list
	@Test(priority = 1)
	public void deleteItem() throws IOException, InterruptedException {

		int initiallistsize = dashform.listSize();
		System.out.println(initiallistsize);
		dashform.deleteItem();
		Thread.sleep(5000);

		int updatedlistsize = dashform.listSize();
		System.out.println(updatedlistsize);

		Assert.assertEquals(initiallistsize - 1, updatedlistsize);
	}
	
	@AfterClass
	public void Logout() throws InterruptedException
	{
		Thread.sleep(1000);

		boolean logoutclick = dashform.Logout();

		Assert.assertEquals(true, logoutclick);
		
		driver.close();
	}

}
