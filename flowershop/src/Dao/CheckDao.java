package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import jdbc.jdbcUtil;
import vo.Cart;

public class CheckDao{
	Connection conn = null;
	PreparedStatement pstmt = null;
	boolean flag = false;
	String sql_add = "insert into fcheck(checkid,username,num,pid) value(?,?,?,?)";
	public boolean add(Object o,int checkid) {
		Cart cart = (Cart) o;
		conn = jdbcUtil.open();
		try {
			pstmt = conn.prepareStatement(sql_add);
			pstmt.setInt(1, checkid);
			pstmt.setString(2, cart.getCname());
			pstmt.setInt(3, cart.getNum());
			pstmt.setInt(4, cart.getCid());
			pstmt.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jdbcUtil.close(conn,pstmt);
		return flag;
	}

	public Object select(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
