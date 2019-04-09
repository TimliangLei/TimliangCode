package Implements;

import java.util.List;
import javabean.Book;

public interface bookDao {
	public void add(Book c);
	public void update(Book c);
	public void delete (int c);
	public Book getCustomerById(int id);
	public List<Book> query();
}
