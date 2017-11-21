package com.webtest.core;



import com.webtest.util.Log;

public class Checker {

	String message = "";
	String actualValue = "";
	String expectValue = "";
	String exceptionMessage = "";
	private WebDriverEngine webtest;

	public Checker(WebDriverEngine webtest) {
		this.webtest = webtest;

	}

	public String getMessage() {
		return message;
	}


	public void setMessage(String expectValue, String actualValue) {
		this.message = "expectedValue :" + expectValue + "  match actualValue:"
				+ actualValue;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}


	public void setExceptionMessage(String actualValue,String expectValue) {
		this.exceptionMessage = "expectedValue doesn't match actualValue,actual Value is :"
				+ actualValue+"; expected Value is :" + expectValue;
	}

	
	public void verifyText(String locator, String patten) throws Exception  {
		actualValue = webtest.getText(locator);
		verify(patten, actualValue);
	}

	public void verify(String pattern, String actualValue) throws Exception {
		this.actualValue = actualValue;
		this.setExceptionMessage(actualValue,pattern);
		this.setMessage(pattern, actualValue);
		String errormsg = getExceptionMessage();
		String msg = getMessage();
		if (verifyStringsByEqual(pattern, actualValue)) {
			Log.info(msg);
		} else {
			Log.fatal(errormsg);
			throw new Exception(errormsg);
		}
	
	}
	public void verifyHtmlSource(String patten) throws Exception {
		// TODO Auto-generated method stub
		actualValue = webtest.getHtmlSource();
		verify(patten, actualValue);
	}
	
	  private  boolean verifyStringsByEqual( String expectedValue,  String actualValue) {
		  boolean flag=false;
	    	if(expectedValue != null && expectedValue.equals(actualValue))
			{
	    		flag=true;
	    		return flag;
			}
	    	if(expectedValue != null && actualValue.contains(expectedValue))
	    	{
	    		flag=true;
	    		return flag;
	    	}
	    	return flag;
		}
/**
 * 
 * @param 元素path
 * @throws Exception
 */
	public void verifyElementPresent(String locator) throws Exception {

		boolean value = webtest.isElementPresent(locator);
		if (value) {
			Log.info("the Element is Present!");
		} else {
			Log.fatal("the Element is not Present!");
			throw new Exception("the Element is not Present!");
		}
	}

	public void verifyChecked(String locator) throws Exception {
		
		boolean value = webtest.isChecked(locator);
		if (value) {
			Log.info("the checkbox is checked!");
		} else {
			Log.fatal("the checkbox is not checked!");
			throw new Exception("the checkbox is not checked!");
		}
	}
	
	public void verifyTitle(String patten) throws Exception {
		// TODO Auto-generated method stub
		actualValue = webtest.getTitle();
		verify(patten, actualValue);
	}
	public void verifyValue(String locator, String patten) throws Exception {
		// TODO Auto-generated method stub
		actualValue = webtest.getValue(locator);
		verify(patten, actualValue);
	}
}
