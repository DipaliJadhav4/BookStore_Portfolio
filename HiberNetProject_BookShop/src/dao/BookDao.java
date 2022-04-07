package dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import dto.Book;
import util.HBUtils;

public class BookDao {
	
	private SessionFactory sessionFactory;
	
	public BookDao() {
		this.sessionFactory = HBUtils.getSessionFactory();
	}

	public List<Book> getAllBook() {
	
		List<Book> bookList=null;
		Session session = sessionFactory.getCurrentSession();
		
		try
		{
			HBUtils.beginTransaction();
			String hql = "FROM Book b";
			Query<Book> query = session.createQuery(hql);
			
			bookList=query.getResultList();
			HBUtils.commitTransaction();
		}catch(HibernateException ex)
		
		{
			HBUtils.rollbackTransaction();
			throw ex;
		}
		
		
		return bookList;
	}
	
	

}
