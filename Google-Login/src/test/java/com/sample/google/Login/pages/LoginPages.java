package com.sample.google.Login.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.sample.google.Login.commonUtil.CommonMethods;
import com.sample.google.Login.config.AbstractPage;

public class LoginPages extends AbstractPage{

	public LoginPages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(id = "identifierId")
	private WebElement EmailId;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passWord;
	
	@FindBy(xpath = "//div[contains(text(),'Enter an email or phone number')]")
	private WebElement ValidationMessageEmail;
	
	@FindBy(xpath = "//div[@class='o6cuMc']")
	private WebElement invalidEmailVaidationMessage;
	
	@FindBy(xpath = "//span[contains(text(),'Enter a password')]")
	private WebElement ValidationMessageBlankPassword;
	
	@FindBy(xpath = "//span[contains(text(),'Wrong password. Try again or click Forgot password')]")
	private WebElement ValidationMessageInvalidPassword;
	
	@FindBy(xpath="//body/div[4]/div[2]/div[1]/div[2]/button[1]")
	private WebElement stackoverFlowGoogle;
	
	@FindBy(xpath="//img[@class='gb_Ha gbii']")
	private WebElement profileImage;
	
	@FindBy(xpath = "//div[@class='gb_rb']")
	private WebElement verifyEmail;
	
	
	
	public boolean verifyloginblankEmail(String email)
	{		
		if(ValidationMessageEmail.isDisplayed() && ValidationMessageEmail.getText().contains("Enter an email or phone number"))
		{
			Reporter.log("<br/><u><i>DETAILS Entered</i></u>");
			Reporter.log("<br/>email:"+email);
			Reporter.log("<br/><b>Validation Message : "+ValidationMessageEmail.getText()+"</b>");
			return true;
		}
		else
		{
			if(!ValidationMessageEmail.isDisplayed())
			{
				Reporter.log("<br/><b>Validation Message is not displayed.</b>");
			}
			if(!ValidationMessageEmail.getText().contains("Enter an email or phone number"))
			{
				Reporter.log("<br/><b>Validation Message is not matched.</b>");
			}
			return false;
		}
		
	}
	
	public boolean verifyloginblankPassword(String password) 
	{		
		if(ValidationMessageBlankPassword.isDisplayed() && ValidationMessageBlankPassword.getText().equalsIgnoreCase("Enter a Password"))
		{
			Reporter.log("<br/><b>Validation Message : "+ValidationMessageBlankPassword.getText()+"</b>");
			return true;
		}
		else
		{
			if(!ValidationMessageBlankPassword.isDisplayed())
			{
				Reporter.log("<br/><b>Validation Message is not displayed.</b>");
			}
			if(!ValidationMessageBlankPassword.getText().equalsIgnoreCase("Enter a Password"))
			{
				Reporter.log("<br/><b>Validation Message is not matched.</b>");
			}
			return false;
		}
	}
	
	public boolean verifyValidLogin(String email) throws InterruptedException 
	{
		CommonMethods.sleep(5);
		
		if(profileImage.isDisplayed())
		{
			profileImage.click();
			
			CommonMethods.sleep(5);
			
			if(verifyEmail.getText().equalsIgnoreCase(email))
			{
				Reporter.log("<br><Strong><font color=#008000>Login is Successful</font></strong>");
				Reporter.log("<br/><b>Entered Email is : "+verifyEmail.getText()+"</b>");
				return true;
			}
			else
			{
				Reporter.log("<br/><b>Entered Email Id doesnt matched.</b>");
				return false;
			}
			
		}
		else
		{
			Reporter.log("<br/><b>Login is not successfully.</b>");
			return false;
		}
		
	}
	
	public boolean verifyloginInvalidEmail(String email) 
	{
		if(invalidEmailVaidationMessage.isDisplayed() && invalidEmailVaidationMessage.getText().contains("Google Account"))
		{
			Reporter.log("<br/><u><i>DETAILS Entered</i></u>");
			Reporter.log("<br/>email:"+email);
			Reporter.log("<br/><b>Validation Message : "+invalidEmailVaidationMessage.getText()+"</b>");
			return true;
		}
		else
		{
			if(!invalidEmailVaidationMessage.isDisplayed())
			{
				Reporter.log("<br/><b>Validation Message is not displayed.</b>");
			}
			if(!invalidEmailVaidationMessage.getText().contains("Google Account"))
			{
				Reporter.log("<br/><b>Validation Message is not matched.</b>");
			}
			return false;
		}
	}
	
	public boolean verifyloginInvalidPassword(String password)
	{
		if(ValidationMessageInvalidPassword.isDisplayed() && ValidationMessageInvalidPassword.getText().contains("Wrong password. Try again or click Forgot password to reset it."))
		{
			Reporter.log("<br/><b>Validation Message : "+ValidationMessageInvalidPassword.getText()+"</b>");
			return true;
		}
		else
		{
			if(!ValidationMessageInvalidPassword.isDisplayed())
			{
				Reporter.log("<br/><b>Validation Message is not displayed.</b>");
			}
			if(!ValidationMessageInvalidPassword.getText().contains("Wrong password. Try again or click Forgot password to reset it."))
			{
				Reporter.log("<br/><b>Validation Message is not matched.</b>");
			}
			return false;
		}
	}

}
