package com.edu.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class FrontEndMyMovies extends BaseTest{

	@Test
	public void testFrontLogin() throws InterruptedException{
		webtest.open("http://localhost:8032/MyMovie/");
		webtest.click("link=��¼");
		webtest.type("name=username", "xxxxiho");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@value='���ϵ�¼']");

		assertTrue(webtest.getHtmlSource().contains("�˳�"));
//		try{
//		check.verifyElementPresent("link=�˳�");
//		}catch (Exception e) {
//			// TODO: handle exception
//			
//		}
		
//		driver.manage().window().max
	}
}
