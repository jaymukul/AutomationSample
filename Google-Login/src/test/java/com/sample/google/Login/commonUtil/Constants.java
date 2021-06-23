package com.sample.google.Login.commonUtil;

import java.text.SimpleDateFormat;

public class Constants {

	public static final String TODAY_DATE = new SimpleDateFormat("ddMM").format(System.currentTimeMillis());
	
	public interface login{
		
		//For Test case ID and Test case scenario
		public static final String VERIFYLOGINWITHBLANKEMAIL ="Verify Login With Blank Email";
		public static final String VERIFYLOGINWITHBLANKPASSWORD ="Verify Login With Blank Password";
		public static final String VERIFYVALIDLOGIN = "Verify Valid Login";
		public static final String VERIFYLOGINWITHINVALIDEMAILID = "Verify Login with Invalid Email Id";
		public static final String VERIFYLOGINWITHINVALIDPASSWORD = "Verify Login with Invalid Password";
		
		//Login details
		public static final String LOGIN_BLANK_EMAIL = "BlankEmailLogin";
		public static final String LOGIN_BLANK_PASSWORD = "BlankPasswordLogin";
		public static final String LOGIN_VALID = "ValidLogin";
		public static final String LOGIN_INVALID_EMAIL="INVALIDEMAIL";
		public static final String LOGIN_INVALID_PASSWORD="INVALIDPASSWORD";
		
	}
}
