package com.webtest.core;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ObjectMap {

	Properties prop = null;

	public ObjectMap(String propFile) {
		prop = new Properties();
		try {
			FileInputStream in = new FileInputStream(propFile);
			prop.load(in);
			in.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public String getlocator(String ElementNameInProp) throws Exception {
		System.out.println(prop.getProperty(ElementNameInProp));
		return prop.getProperty(ElementNameInProp);


	}

}
