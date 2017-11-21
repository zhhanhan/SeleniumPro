package com.webtest.dataprovider;

import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DBDataProvider {
	


	public  Object[][] getTestDataByMysql(String tableName) {

		String url = "jdbc:mysql://127.0.0.1:3306/mymovie";
		List<Object[]> records = new ArrayList<Object[]>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection(url, "root", "123456");
			if (!conn.isClosed()) {
				System.out.println("�������ݿ�ɹ�?");
			}
		
			Statement stmt = conn.createStatement();
			String sql = "select id,filmname,petname  from " + tableName;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int cols = rsMetaData.getColumnCount();
			System.out.println(cols);
			while (rs.next()) {
				String fields[] = new String[cols];

				int col=0;
				for (int i = 0; i < cols; i++) {
					fields[col] = rs.getString(i+1);
					col++;
				}
				records.add(fields);
			
			}
			rs.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] results = new Object[records.size()][];
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);
		}
		return results;
	}
	@DataProvider(name = "testData")
	public  Object[][] getTestDataByExcel() throws IOException {

		return getTestDataByMysql("mm_movie");

	}

	@Test(dataProvider = "testData")
	public void testDataDriverByExcel(String id,String f,String pet) throws InterruptedException {

		System.out.println(id+" "+f+" "+" "+pet);
	}
}
