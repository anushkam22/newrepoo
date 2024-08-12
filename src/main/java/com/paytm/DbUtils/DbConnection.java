package com.paytm.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;

public class DbConnection {

	private static final String username = null;
	Connection con;
	
	public void getConnection(String url, String password) throws Throwable
	{
		try {
			Driver driver = new Driver();
              DriverManager.registerDriver(driver);
              con = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("not connected");
		}
		
	}
	
	public void getConnectiongfromdb(String url, String password) throws Throwable
	{
		try {
			Driver driver = new Driver();
              DriverManager.registerDriver(driver);
              con = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("not connected");
		}
		
	}
	
	
	public ResultSet createQuery(String query) throws Throwable {
		
		ResultSet set;
		
        Statement stat = con.createStatement();
		
		set = stat.executeQuery(query);
		return set;
		
		
	}
	
	
	
	public int updateQuery(String query)
	{
		int i = 0;
		
		try {
			 Statement stat = con.createStatement();
				
				i = stat.executeUpdate(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}
}
