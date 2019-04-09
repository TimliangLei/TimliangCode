package Implements;


import java.sql.*;
import java.util.*;

import javax.security.auth.login.Configuration;

import java.io.*;
public class DBUtool {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		Properties prop = new Properties();
		InputStream in;
		try {
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
			prop.load(in);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");;
		username = prop.getProperty("username");;
		password = prop.getProperty("password");;
	}
	public static Connection open() 
	{
		
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	public static void close (Connection conn,Statement stmt,ResultSet rs)
	{
		if(rs!=null)
		{
			try 
			{
				rs.close();
			} catch (SQLException e) 
			{
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(stmt!=null)
		{
			try 
			{
				stmt.close();
			} catch (SQLException e) 
			{
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{
			try
			{
				conn.close();
			} 
			catch (SQLException e) 
			{
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	public static void close (Connection conn)
	{
		
		if(conn!=null)
		{
			try
			{
				conn.close();
			} 
			catch (SQLException e) 
			{
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
		
	
