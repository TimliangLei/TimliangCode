package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.jdbcUtil;
import vo.Check;
import vo.Fcheck;
import vo.User;

public class FcheckDao{
	//Vcheck为账单表映射产品信息，只允许查询
	Connection conn;
	PreparedStatement pstmt;
	boolean flag = false;
	public Object select(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
	String sql_selectAll ="select * from Vcheck where username = ?";
	public List selectAll(User u) {
		List<Fcheck> list = new ArrayList<Fcheck>();
		conn = jdbcUtil.open();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			pstmt.setString(1, u.getUsername());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Fcheck fcheck = new Fcheck();
				int pid = rs.getInt("pid");
				 int checkid = rs.getInt("checkid");
				 int num = rs.getInt("num");
				 String name = rs.getString("name");
				 String info = rs.getString("info");
				 String fphoto = rs.getString("fphoto");
				 int price = rs.getInt("price");
				 int point = rs.getInt("point");
				fcheck.setCheckid(checkid);
				fcheck.setPid(pid);
				fcheck.setFphoto(fphoto);
				fcheck.setInfo(info);
				fcheck.setName(name);
				fcheck.setUsername(u.getUsername());
				fcheck.setNum(num);
				fcheck.setPoint(point);
				fcheck.setPrice(price);
				list.add(fcheck);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
