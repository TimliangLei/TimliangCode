package Implements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import javabean.Book;

public class bookImp implements bookDao {
	String sql;
	Connection conn = DBUtool.open();
	PreparedStatement pstmt = null;
	@Override
	public void add(Book b) {
		// TODO Auto-generated method stub
		sql = "INSERT INTO library_book(bookname,bookimg) value(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBookname());
			pstmt.setString(2, b.getBookimg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtool.close(conn);
		}
		
	}

	@Override
	public void update(Book c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> query() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
