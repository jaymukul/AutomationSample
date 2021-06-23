package com.sample.google.Login.verifications;

import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.sample.google.Login.classElements.DataUtil;
import com.sample.google.Login.classElements.LoginElements;
import com.sample.google.Login.commonUtil.CommonMethods;
import com.sample.google.Login.commonUtil.Constants;
import com.sample.google.Login.config.Config;
import com.sample.google.Login.indexpage.LoginIndexPage;
import com.sample.google.Login.pages.LoginPages;

public class LoginIndex extends Config{
	
	Map< String,Object> details;
	DataUtil util =null;

	public LoginIndex()
	{
		util=DataUtil.getInstance();
		details=util.getDetails();	
	}
	
	@Test
	public void VerifyLoginWithBlankEmail() throws InterruptedException 
	{

		int steplog = 1;
		int numberofFailure=0;
		
		LoginPages loginPages = new LoginPages(driver);
		LoginIndexPage loginIndexPage = new LoginIndexPage(driver);
		LoginElements loginElement = (LoginElements)details.get(Constants.login.LOGIN_BLANK_EMAIL);
		
		CommonMethods.sleep(2);
		
		steplog=log(steplog, "Goto This Link https://accounts.google.com/ServiceLogin");
		steplog=log(steplog, "Keep the Email Blank, and Press Enter");
		
		//Login with blank email
		loginIndexPage.loginEmail(loginElement.getEmailId());
		
		steplog=log(steplog, "Now, Verify the validation message for blank email");
		
		if(loginPages.verifyloginblankEmail(loginElement.getEmailId()))
		{
			Reporter.log("<br><Strong><font color=#008000>Pass</font></strong>");
		}
		else
		{
			numberofFailure++;
		}
		
		if(numberofFailure>0)
		{
			Assert.assertTrue(false);
		}
		
		
	}
	
	@Test
	public void VerifyLoginWithBlankPassword() throws InterruptedException 
	{

		int steplog = 1;
		int numberofFailure=0;
		
		LoginPages loginPages = new LoginPages(driver);
		LoginIndexPage loginIndexPage = new LoginIndexPage(driver);
		LoginElements loginElement = (LoginElements)details.get(Constants.login.LOGIN_BLANK_PASSWORD);
		
		CommonMethods.sleep(2);
		
		steplog=log(steplog, "Goto This Link https://accounts.google.com/ServiceLogin");
		steplog=log(steplog, "Enter Email and Press Enter");
		steplog=log(steplog, "Then, Keep the Password Blank, and Press Enter");
		
		loginIndexPage.loginblankPassword(loginElement.getEmailId());
		
		steplog=log(steplog, "Now, Verify the validation message for blank password");
		
		if(loginPages.verifyloginblankPassword(loginElement.getPassword()))
		{
			Reporter.log("<br><Strong><font color=#008000>Pass</font></strong>");
		}
		else
		{
			numberofFailure++;
		}
		
		if(numberofFailure>0)
		{
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void VerifyValidLogin() throws InterruptedException
	{
		int steplog = 1;
		int numberofFailure = 0;

		LoginPages loginPages = new LoginPages(driver);
		LoginIndexPage loginIndexPage = new LoginIndexPage(driver);
		LoginElements loginElement = (LoginElements) details.get(Constants.login.LOGIN_VALID);

		CommonMethods.sleep(2);

		steplog = log(steplog, "Goto This Link https://accounts.google.com/ServiceLogin");
		steplog = log(steplog, "Enter Valid Email & Password and Press Enter");
		
		loginIndexPage.validLogin(loginElement.getEmailId(), loginElement.getPassword());
		
		steplog=log(steplog, "Now, Verify the login details");
		
		if(loginPages.verifyValidLogin(loginElement.getEmailId()))
		{
			Reporter.log("<br><Strong><font color=#008000>Pass</font></strong>");
		}
		else
		{
			numberofFailure++;
		}
		if(numberofFailure>0)
		{
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void VerifyLoginWithInvalidEmail() throws InterruptedException
	{
		int steplog = 1;
		int numberofFailure=0;
		
		LoginPages loginPages = new LoginPages(driver);
		LoginIndexPage loginIndexPage = new LoginIndexPage(driver);
		LoginElements loginElement = (LoginElements)details.get(Constants.login.LOGIN_INVALID_EMAIL);
		
		CommonMethods.sleep(2);
		
		steplog=log(steplog, "Goto This Link https://accounts.google.com/ServiceLogin");
		steplog=log(steplog, "Keep the Invalid Email, and Press Enter");
		
		//Login with Invalid email
		loginIndexPage.loginEmail(loginElement.getEmailId());
		
		steplog=log(steplog, "Now, Verify the validation message for invalid email");
		
		if(loginPages.verifyloginInvalidEmail(loginElement.getEmailId()))
		{
			Reporter.log("<br><Strong><font color=#008000>Pass</font></strong>");
		}
		else
		{
			numberofFailure++;
		}
		
		if(numberofFailure>0)
		{
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void VerifyLoginWithInvalidPassword() throws InterruptedException
	{
		int steplog = 1;
		int numberofFailure = 0;

		LoginPages loginPages = new LoginPages(driver);
		LoginIndexPage loginIndexPage = new LoginIndexPage(driver);
		LoginElements loginElement = (LoginElements) details.get(Constants.login.LOGIN_INVALID_PASSWORD);

		CommonMethods.sleep(2);

		steplog = log(steplog, "Goto This Link https://accounts.google.com/ServiceLogin");
		steplog = log(steplog, "Enter Valid Email & Invalid Password and Press Enter");
		
		//Valid Login with Invalid password 
		loginIndexPage.validLogin(loginElement.getEmailId(), loginElement.getPassword());
		steplog=log(steplog, "Now, Verify the validation message for invalid password");
		
		if(loginPages.verifyloginInvalidPassword(loginElement.getPassword()))
		{
			Reporter.log("<br><Strong><font color=#008000>Pass</font></strong>");
		}
		else
		{
			numberofFailure++;
		}
		
		if(numberofFailure>0)
		{
			Assert.assertTrue(false);
		}
		
		
	}

	
  
}
