package test;

import java.util.List;
import dao.BookDao;
import dto.Book;
import util.HBUtils;

public class Program {

	public static void main(String[] args) {
		
		HBUtils.getSessionFactory();
		BookDao dao = new BookDao();
		List<Book> booklist = dao.getAllBook();
		booklist.forEach(System.out::println);		
		
		HBUtils.getSessionFactory().close();

	}

}
