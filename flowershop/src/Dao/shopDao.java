package Dao;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.jdbcUtil;
import vo.Flower;
import vo.User;
import vo.Flower;

public class shopDao {
	Connection conn = null;
	boolean flag = false;
	PreparedStatement pstmt;
	String sql_selectAll = "SELECT * FROM fshop ORDER BY fid DESC";
	public List selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Flower> list = null;
		ResultSet rs=null;
		try {
			conn = jdbcUtil.open();
			pstmt = conn.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			list = new ArrayList<Flower>();
			while (rs.next()) {
				Flower flower = new Flower();
				int fid = rs.getInt("fid");
				String name = rs.getString("name");
				String info = rs.getString("info");
				int price = rs.getInt("price");
				int point = rs.getInt("point");
				String fphoto = rs.getString("fphoto");
				flower.setFid(fid);
				flower.setInfo(info);
				flower.setName(name);
				flower.setPoint(point);
				flower.setPrice(price);
				flower.setFphoto(fphoto);
				list.add(flower);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jdbcUtil.close(conn,pstmt,rs);
		return list;
	}
	String sql_insert="insert into fshop(name,info,price,point,fphoto) value(?,?,?,?,?)";
	public boolean add(Object o) {
		// TODO Auto-generated method stub
		Flower flower = (Flower) o;
		List<Flower> list = selectAll();
		for (Flower flower2 : list) {
			if(flower2.getName().equals(flower.getName())){
				return false;
			}
		}
		try {
			conn=jdbcUtil.open();
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, flower.getName());
			pstmt.setString(2, flower.getInfo());
			pstmt.setInt(3, flower.getPrice());
			pstmt.setInt(4, flower.getPoint());
			pstmt.setString(5, flower.getFphoto());
			pstmt.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbcUtil.close(conn, pstmt);
		return flag;
	}

	
	String sql_update = "update fshop set info=?,price=?,point=?,fphoto=? where name = ?";
	public boolean update(Object o) {
		// TODO Auto-generated method stub
		conn = jdbcUtil.open();
		Flower flower = (Flower) o;
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, flower.getInfo());
			pstmt.setInt(2, flower.getPrice());
			pstmt.setInt(3, flower.getPoint());
			pstmt.setString(4, flower.getFphoto());
			pstmt.setString(5, flower.getName());
			pstmt.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	String sql_delete="delete from fshop where name = ?";
	public boolean delete(Object o) {
		// TODO Auto-generated method stub
		conn= jdbcUtil.open();
		String name = (String) o;
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setString(1, name);
			pstmt.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbcUtil.close(conn, pstmt);
		return flag;
	}
	String sql_select = "select * from fshop where fid = ?";
	public Object select(Object o) {
		// TODO Auto-generated method stub
		int fid = (int) o;
		Flower flower = new Flower();
		conn = jdbcUtil.open();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				String name = rs.getString("name");
				String info = rs.getString("info");
				String fphoto = rs.getString("fphoto");
				int price = rs.getInt("price");
				int point = rs.getInt("point");
				flower.setFid(fid);
				flower.setFphoto(fphoto);
				flower.setInfo(info);
				flower.setName(name);
				flower.setPoint(point);
				flower.setPrice(price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flower;
	}
	String sql = "select COUNT(*) from fshop";
	public int count(){
		List<Flower> list = new ArrayList<Flower>();
		conn = jdbcUtil.open();
		ResultSet rs;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	String sql_selectpage = "select * from fshop limit ?,?";
	public List selectpage(int page){
		List<Flower> list = new ArrayList<Flower>();
		conn = jdbcUtil.open();
		ResultSet rs;
		try {
			pstmt = conn.prepareStatement(sql_selectpage);
			pstmt.setInt(1, (page-1)*3);
			pstmt.setInt(2, 3);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Flower flower = new Flower();
				int fid = rs.getInt("fid");
				String name = rs.getString("name");
				String info = rs.getString("info");
				int price = rs.getInt("price");
				int point = rs.getInt("point");
				String fphoto = rs.getString("fphoto");
				flower.setFid(fid);
				flower.setInfo(info);
				flower.setName(name);
				flower.setPoint(point);
				flower.setPrice(price);
				flower.setFphoto(fphoto);
				list.add(flower);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
