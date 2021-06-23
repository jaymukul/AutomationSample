package com.sample.google.Login.commonUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;
import com.sample.google.Login.config.Config;

public class CommonMethods extends Config {
	
	//private static final Logger LOG = Logger.getLogger();
	
	/**
	 * Wait Method 
	 * @param seconds
	 * @throws InterruptedException
	 */
	
	public static void sleep(int seconds) throws InterruptedException
	{
		Thread.sleep(seconds*1500);
	}
	
	/**
	 * Clear Field and Enter Value
	 * @param element
	 * @param value
	 */
	
	public static void type(WebElement element, String value)
	{
		element.clear();
		element.sendKeys(value);
		
	}
	
	public static String returnStringforMail(int pass, int fail, int total,int skip,String hostaddress)
	{
		String str=" <HTML> <BODY> <div style=\"width:100%;text-align:center;background-color:#438EB9;font-weight:bold;color:#fff;font-size:15;\"> <label>Automation Test Report</label>  </div>  <br/> Hi Team,<br/> <br/> <br/> PFA for Automation Test Report. Download it and Open it in Browser. <br/> <br/> <table style=\"border-spacing: 0;border-collapse: collapse;\"> <tr>  <th style=\"border: 1px solid black !important;padding:2px;text-align:left;\">Passed</th>"+
                "<td style=\"border: 1px solid black !important;padding:2px;\">"+pass+"</td> <th style=\"border: 1px solid black !important;padding:2px;text-align:left;\">Failed</th> <td style=\"border: 1px solid black !important;padding:2px;\">"+fail+"</td><th style=\"border: 1px solid black !important;padding:2px;text-align:left;\">Skipped</th><td style=\"border: 1px solid black !important;padding:2px;\">"+skip+"</td></tr><tr><tr><th style=\"border: 1px solid black !important;padding:2px;text-align:left;\">Total </th> <td style=\"border: 1px solid black !important;padding:2px;\" colspan=\"5\">"+total+"</td></tr><tr></table>"+
                
				"<br/><br/><b>Server IP </b> <br/> <b>"+hostaddress+          
                
                "</b><br/><br/> Warm Regards, <br/> Jay Mukul<br/><br/>"+
                     "<small>This eMail is automatically triggered by the <b>Automation Script</b>. If you feel it has been received in error, please contact Jay Mukul.</small>"+
        "</BODY></HTML>";
		
		return str;
		
	}
	
	public static boolean isElementPresent(By by, WebDriver driver){
	    try {
	        driver.findElement(by);
	        return true;
	    }
	    catch (org.openqa.selenium.NoSuchElementException e){
	        return false;
	    }
	}
	
	@SuppressWarnings("deprecation")
	public static void waitUntilRowPopulates(List<WebElement> element,WebDriver driver) 
	{
	       final List<WebElement> table = element;

	       new FluentWait<WebDriver>(driver)
	       .withTimeout(30, TimeUnit.SECONDS)
	       .pollingEvery(1, TimeUnit.SECONDS).until(new Function<WebDriver, Boolean>() {

	           public Boolean apply(WebDriver d) {
	                return (table.size() > 0);
	           }
	       });
	   }
	
	@SuppressWarnings("deprecation")
	public static void isLoadedAndSendkeys(final WebElement ele,WebDriver driver,String key) throws Error
	{
	     new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
	     	.pollingEvery(2, TimeUnit.SECONDS)
	             .ignoring(NoSuchElementException.class)
	             .ignoring(StaleElementReferenceException.class)
	             .until(new Function<WebDriver, Boolean>() {
	                 
	                 @Override
	                 public Boolean apply(WebDriver webDriver) 
	                 {
	                     final WebElement element = ele;
	                     return element != null && element.isDisplayed();
	                 }
	             });
	     ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+ele.getLocation().y+")");
	     ele.clear();
	     ele.sendKeys(key);
	 }
	 
	@SuppressWarnings("deprecation")
	public static void isLoadedAndClick(final WebElement ele,final WebDriver driver) throws Error
	 {
		 new FluentWait<WebDriver>(driver)
		 .withTimeout(60, TimeUnit.SECONDS)
		 .pollingEvery(2, TimeUnit.SECONDS)
		 .ignoring(NoSuchElementException.class,StaleElementReferenceException.class)
		 .until(new Function<WebDriver, Boolean>()
				 {			 
			 @Override
			 public Boolean apply(WebDriver webDriver)
			 {			 
				 
				 final WebElement element = ele;
				 
				 return element != null && element.isDisplayed();
			 }
		 });
		 
		 ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+ele.getLocation().y+")");
		 ele.click();
		 
	 }

}
