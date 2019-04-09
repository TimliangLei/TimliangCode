package test_stu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test_stu.jdbcUtil;
import test_stu.test;
import test_stu.test_stu;

public class test_stuDao {
	Connection conn;
	PreparedStatement pstmt;
	String sql_selectAll = "select * from test_stu";
	public List<test_stu> selectAll(){
		List<test_stu> list = new ArrayList<test_stu>();
		conn = jdbcUtil.open();
		ResultSet rs;
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String sname = rs.getString("sname");
				int sid = rs.getInt("sid");
				String sex = rs.getString("sex");
				test_stu stu = new test_stu();
				stu.setSex(sex);
				stu.setSid(sid);
				stu.setSname(sname);
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	String sql = "select COUNT(*) from test_stu";
	public int count(){
		List<test_stu> list = new ArrayList<test_stu>();
		conn = jdbcUtil.open();
		ResultSet rs;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	String sql_selectpage = "select * from test_stu limit ?,?";
	public List selectpage(int page){
		List<test_stu> list = new ArrayList<test_stu>();
		conn = jdbcUtil.open();
		ResultSet rs;
		try {
			pstmt = conn.prepareStatement(sql_selectpage);
			pstmt.setInt(1, (page-1)*3);
			pstmt.setInt(2, 3);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String sname = rs.getString("sname");
				int sid = rs.getInt("sid");
				String sex = rs.getString("sex");
				test_stu stu = new test_stu();
				stu.setSex(sex);
				stu.setSid(sid);
				stu.setSname(sname);
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
