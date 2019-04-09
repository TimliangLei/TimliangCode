package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.jdbcUtil;
import vo.Fcart;
import vo.User;

public class FcartDao {
	//fcart视图为一个映射表，不进行插入、删除、修改操作 
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql_selectNum = "select * from fcart where cname = ?";
	public int select(User user) {
		// TODO Auto-generated method stub
		conn = jdbcUtil.open();
		ResultSet rs;
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql_selectNum);
			pstmt.setString(1, user.getUsername());
			rs = pstmt.executeQuery();
			while(rs.next()){
				num += rs.getInt("num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}
	String sql_selectAll = "select * from fcart where cname = ? group by cid desc";
	public List selectAll(User user) {
		ResultSet rs = null;
		List<Fcart> list  = new ArrayList<Fcart>();
		conn = jdbcUtil.open();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			pstmt.setString(1, user.getUsername());
			rs = pstmt.executeQuery();
			while(rs.next()){
				Fcart fcart = new Fcart();
				fcart.setCid(rs.getInt("cid"));
				fcart.setCname(rs.getString("cname"));
				fcart.setFphoto(rs.getString("fphoto"));
				fcart.setInfo(rs.getString("info"));
				fcart.setName(rs.getString("name"));
				fcart.setNum(rs.getInt("num"));
				fcart.setPoint(rs.getInt("point"));
				fcart.setPrice(rs.getInt("price"));
				list.add(fcart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
