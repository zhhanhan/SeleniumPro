package com.edu.test;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;


//�������ʹ���˶�������
public class BaiduTest extends BaseTest {
	String url = "https://www.baidu.com/";


	
	@Test
	public void testBaidu() throws Exception {
		webtest.open(url);
		webtest.type("id=kw", "taobao");
		webtest.click("id=su");
		check.verify("", "�˳�");
		Thread.sleep(5000);
	}
	

	
	

}
