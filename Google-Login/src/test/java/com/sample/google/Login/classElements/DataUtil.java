package com.sample.google.Login.classElements;

import java.util.HashMap;
import java.util.Map;

import com.sample.google.Login.commonUtil.Constants;


public class DataUtil {
	
	private static DataUtil dataUtil = null;

	private Map<String, Object> details = new HashMap<String, Object>();
	
	private DataUtil()
	{
		loginDetails();
	}

	public static DataUtil getInstance()
	{
		if(dataUtil ==null)
		{
			dataUtil = new DataUtil();
		}
		return dataUtil;
	}
	
	public Map<String, Object> getDetails() 
	{
		return details;
	}

	public void setDetails(Map<String, Object> details) 
	{
		this.details = details;
	}
		
	
	private void loginDetails()
	{
		//For Test Case ID 
		details.put(Constants.login.VERIFYLOGINWITHBLANKEMAIL,new MethodDetails("TC_LOGIN_001"));
		details.put(Constants.login.VERIFYLOGINWITHBLANKPASSWORD,new MethodDetails("TC_LOGIN_002"));
		details.put(Constants.login.VERIFYVALIDLOGIN, new MethodDetails("TC_LOGIN_003"));
		details.put(Constants.login.VERIFYLOGINWITHINVALIDEMAILID, new MethodDetails("TC_LOGIN_004"));
		details.put(Constants.login.VERIFYLOGINWITHINVALIDPASSWORD, new MethodDetails("TC_LOGIN_005"));
		
		//For Login Details
		details.put(Constants.login.LOGIN_BLANK_EMAIL, new LoginElements("", "jay*12345"));
		details.put(Constants.login.LOGIN_BLANK_PASSWORD, new LoginElements("jaymukul6@gmail.com", ""));
		details.put(Constants.login.LOGIN_VALID, new LoginElements("jaymukul6@gmail.com", "jay*12345"));
		details.put(Constants.login.LOGIN_INVALID_EMAIL, new LoginElements("jaymukul6@test.com",""));
		details.put(Constants.login.LOGIN_INVALID_PASSWORD, new LoginElements("jaymukul6@gmail.com", "jay123"));
	}
	
}
