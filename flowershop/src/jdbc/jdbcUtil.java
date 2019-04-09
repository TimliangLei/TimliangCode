package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class jdbcUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	static {
		ResourceBundle rb = ResourceBundle.getBundle("config",Locale.getDefault());
		driver = rb.getString("driver");
		url = rb.getString("url");;
		user = rb.getString("user");;
		password = rb.getString("password");;
	}
	public static Connection open() 
	{

		String url_Login = "?user="+user+"&password="+password;
		String url_Encode = "&useUnicode=true&characterEncoding=utf-8";
		String url_End = url + url_Login + url_Encode;
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url_End);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("class not found!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public static void close (Connection conn,Statement stmt)
	{
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
