package com.edu.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class FrontEndMyMovies extends BaseTest{

	@Test
	public void testFrontLogin() throws InterruptedException{
		webtest.open("http://localhost:8032/MyMovie/");
		webtest.click("link=登录");
		webtest.type("name=username", "xxxxiho");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@value='马上登录']");

		assertTrue(webtest.getHtmlSource().contains("退出"));
//		try{
//		check.verifyElementPresent("link=退出");
//		}catch (Exception e) {
//			// TODO: handle exception
//			
//		}
		
//		driver.manage().window().max
	}
}
