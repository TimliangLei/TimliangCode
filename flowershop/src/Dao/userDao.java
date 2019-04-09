package Dao;

import java.awt.TexturePaint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;

import jdbc.jdbcUtil;
import vo.Flower;
import vo.User;

public class userDao {
	Connection conn = jdbcUtil.open();
	PreparedStatement pstmt;
	ResultSet rs;
	boolean flag = false;
	String sql_add = "insert into fuser(username,password,identity) values(?,?,?)";
	public boolean add(Object o) {
		// TODO Auto-generated method stub
		User user = (User) o;
		List<User> users = selectAll();
		for (User user2 : users) {
			if(user2.getUsername().equals(user.getUsername())){
				return false;
			}
		}
		try {
			pstmt = conn.prepareStatement(sql_add);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getIdentity());
			pstmt.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbcUtil.close(conn,pstmt);
		return flag;
	}
	String sql_select = "select password from fuser where username=? AND identity=?";
	public Object select(Object o) {
		// TODO Auto-generated method stub
		User user = (User) o;
		int count = 0;
		try {
			pstmt=conn.prepareStatement(sql_select);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getIdentity());
			rs=pstmt.executeQuery();
			if (rs.next()) {
				String password = rs.getString("password");
				if (password.equals(user.getPassword())){
					flag = true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	public boolean update(Object o) {
		// TODO Auto-generated method stub
		return flag;
	}
	public boolean delete(Object o) {
		// TODO Auto-generated method stub
		return flag;
	}
	String sql_selectAll = "select * from fuser";
	public List selectAll() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		try {
			pstmt=conn.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setIdentity(rs.getString("identity"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
