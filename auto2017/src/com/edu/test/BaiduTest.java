package com.edu.test;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;


//这个例子使用了对象库管理
public class BaiduTest extends BaseTest {
	String url = "https://www.baidu.com/";


	
	@Test
	public void testBaidu() throws Exception {
		webtest.open(url);
		webtest.type("id=kw", "taobao");
		webtest.click("id=su");
		check.verify("", "退出");
		Thread.sleep(5000);
	}
	

	
	

}
