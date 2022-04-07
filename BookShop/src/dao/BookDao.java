package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import pojo.Book;
import utils.DBUtils;

public class BookDao implements Closeable {
	private Connection connection;
	private PreparedStatement dsStatement;
	private PreparedStatement booksStatement;
	private PreparedStatement bookDetailsStatement;

	public BookDao() throws Exception {
		this.connection = DBUtils.getConnection();
		this.dsStatement = this.connection.prepareStatement("SELECT DISTINCT subjectName FROM bookTable");
		this.booksStatement = this.connection.prepareStatement("SELECT * FROM bookTable WHERE subjectName=?");
		this.bookDetailsStatement = this.connection.prepareStatement("SELECT * FROM bookTable WHERE bookId=?");
	}

	public Set<String> getSubjects() throws Exception {
		Set<String> set = new TreeSet<String>();
		try (ResultSet rs = this.dsStatement.executeQuery()) {
			while (rs.next()) {
				String subjectName = rs.getString("subjectName");
				set.add(subjectName);
			}
		}
		return set;
	}

	public List<Book> getBooks(String subjetName) throws Exception {
		List<Book> bookList = new ArrayList<Book>();
		this.booksStatement.setString(1, subjetName);
		try (ResultSet rs = this.booksStatement.executeQuery()) {
			while (rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setAutorName(rs.getString("autorName"));
				book.setSubjectName(rs.getString("subjectName"));
				book.setPrice(rs.getFloat("price"));
				bookList.add(book);
			}
		}
		return bookList;
	}

	public Book getBook(int bookId) throws Exception {
		this.bookDetailsStatement.setInt(1, bookId);
		try (ResultSet rs = this.bookDetailsStatement.executeQuery()) {
			if (rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setAutorName(rs.getString("autorName"));

				book.setSubjectName(rs.getString("subjectName"));

				book.setPrice(rs.getFloat("price"));
				return book;
			}
		}
		return null;
	}

	@Override
	public void close() throws IOException {
		try {
			this.bookDetailsStatement.close();
			this.booksStatement.close();
			this.dsStatement.close();
			this.connection.close();
		} catch (SQLException cause) {
			throw new IOException(cause);
		}
	}
}