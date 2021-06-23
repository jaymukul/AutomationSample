package com.sample.google.Login.indexpage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sample.google.Login.commonUtil.CommonMethods;
import com.sample.google.Login.config.AbstractPage;

public class LoginIndexPage extends AbstractPage {

	public LoginIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "identifierId")
	private WebElement EmailId;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passWord;
	
	@FindBy(xpath="//body/div[4]/div[2]/div[1]/div[2]/button[1]")
	private WebElement stackoverFlowGoogle;
	
	public void loginEmail(String email) throws InterruptedException
	{
        CommonMethods.sleep(3);
		
		EmailId.sendKeys(email);
		
		CommonMethods.sleep(2);
		
		EmailId.sendKeys(Keys.ENTER);

	}
	
	public void loginblankPassword(String email) throws InterruptedException
	{
        CommonMethods.sleep(3);
		
		EmailId.sendKeys(email);
		
		CommonMethods.sleep(2);
		
		EmailId.sendKeys(Keys.ENTER);
		
		CommonMethods.sleep(2);
		
		passWord.sendKeys(Keys.ENTER);
	}
	
	public void validLogin(String email,String password) throws InterruptedException
	{
		CommonMethods.sleep(3);

		EmailId.sendKeys(email);

		CommonMethods.sleep(2);

		EmailId.sendKeys(Keys.ENTER);

		CommonMethods.sleep(2);

		passWord.sendKeys(password);
		
		CommonMethods.sleep(3);

		passWord.sendKeys(Keys.ENTER);
	}
		

}
