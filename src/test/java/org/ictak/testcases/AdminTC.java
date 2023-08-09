package org.ictak.testcases;

import java.io.IOException;

import org.ictak.base.BaseClass;
import org.ictak.pages.AdminUsers;
import org.ictak.pages.LoginPage;
import org.ictak.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminTC extends BaseClass {

	LoginPage loginPage;
	AdminUsers admin;

	@BeforeClass
	public void Login()
	{
		loginPage = new LoginPage(driver, wait);
		loginPage.login();
		loginPage.signin(1);
	}

	@Test(priority=0)
	public void AddValidUser()
	{
		admin = new AdminUsers(driver,wait);

		boolean adminclick = admin.AdminClick();

		Assert.assertEquals(true, adminclick);

		boolean newadminclick = admin.NewAdminclick();

		Assert.assertEquals(true, newadminclick);

		admin.SetValues();

		boolean addresult = admin.AddUser();

		Assert.assertEquals(true, addresult);

	}

	@Test(priority=1)

	public void AddInValidUser()
	{

		boolean newadminclick = admin.NewAdminclick();

		Assert.assertEquals(true, newadminclick);

		admin.SetInvalidValues();

		boolean addresult = admin.AddInvalidUser();

		Assert.assertEquals(false, addresult);

	}

	@Test(priority=2)
	public void EditUser() throws IOException, InterruptedException
	{		
		String actual = ExcelUtility.getAdminusers(0, 0);

		String expected = admin.Search(0);

		Assert.assertEquals(actual, expected);

		boolean editclick = admin.Edit();

		Assert.assertEquals(true, editclick);

		admin.ResetValues();

		Thread.sleep(1000);

		boolean editresult = admin.UpadateUser();

		Assert.assertEquals(true, editresult);

	}

	@Test(priority=3)
	public void DeleteUser() throws InterruptedException, IOException
	{
		String actual = ExcelUtility.getAdminusers(1, 0);

		String expected = admin.Search(1);

		Assert.assertEquals(actual, expected);
		
		boolean deleteclick1 = admin.Delete();

		Assert.assertEquals(true, deleteclick1);

		boolean canceldelete = admin.CancelDelete();

		Assert.assertEquals(true, canceldelete);

		Thread.sleep(2000);

		expected = admin.Search(1);

		Assert.assertEquals(actual, expected);
		
		boolean deleteclick = admin.Delete();

		Assert.assertEquals(true, deleteclick);

		boolean confirmdelete = admin.ConfirmDelete();

		Assert.assertEquals(true, confirmdelete);

	}

	@Test(priority=4)
	public void ViewNLogout() throws IOException, InterruptedException
	{
		Thread.sleep(2000);

		String actual = ExcelUtility.getAdminusers(2, 0);

		String expected = admin.Search(2);

		Assert.assertEquals(actual, expected);
		
		boolean viewclick = admin.ViewUser();

		Assert.assertEquals(true, viewclick);

	}

	@AfterClass
	public void Logout() throws InterruptedException
	{
		Thread.sleep(1000);

		boolean logoutclick = admin.Logout();

		Assert.assertEquals(true, logoutclick);
		
		driver.close();
	}

}
