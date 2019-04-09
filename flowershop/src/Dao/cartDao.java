package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.jdbcUtil;
import vo.Cart;
import vo.User;

public class cartDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	boolean flag = false;
	String sql_add = "insert into cart(cid, cname,num) value(?,?,?)";
	public boolean add(Object o) {
		List<Cart> list = selectAll(o);
		Cart cart = (Cart) o;
		for (Cart cart1 : list) {
			if (cart1.getCid()==cart.getCid()) {
				int num = cart1.getNum()+1;
				cart1.setNum(num);
				flag = update(cart1);
				return flag;
			}
		}
		conn = jdbcUtil.open();
		try {
			pstmt = conn.prepareStatement(sql_add);
			pstmt.setInt(1, cart.getCid());
			pstmt.setString(2, cart.getCname());
			pstmt.setInt(3, cart.getNum()+1);
			pstmt.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jdbcUtil.close(conn,pstmt);
		return flag;
	}

	String sql_selectAll = "select * from cart where cname = ?";
	public List selectAll(Object o) {
		Cart cart1 = (Cart) o;
		conn = jdbcUtil.open();
		ResultSet rs = null;
		List<Cart> list = new ArrayList<Cart>();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			pstmt.setString(1, cart1.getCname());
			rs = pstmt.executeQuery();
			while(rs.next()){
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				int num = rs.getInt("num");
				Cart cart = new Cart();
				cart.setCid(cid);
				cart.setCname(cname);
				cart.setNum(num);
				list.add(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbcUtil.close(conn, pstmt,rs);
		return list;
	}

	String sql_update = "update cart set num = ? where cid = ? and cname = ?";
	public boolean update(Object o) {
		Cart cart = (Cart) o;
		conn = jdbcUtil.open();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, cart.getNum());
			pstmt.setInt(2, cart.getCid());
			pstmt.setString(3, cart.getCname());
			pstmt.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbcUtil.close(conn, pstmt);
		return flag;
	}
	String sql_delete = "delete from cart where cid = ? and cname =  ?";
	public boolean delete(int cid, String cname) {
		// TODO Auto-generated method stub
		conn = jdbcUtil.open();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, cid);
			pstmt.setString(2, cname);
			pstmt.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}


}
