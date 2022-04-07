package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import pojo.Book;

public class BookServlet  extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	private BookDao dao;
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		
		try {
			super.init(config);
			this.dao= new BookDao();
		} catch (Exception e) {
		
		throw new ServletException(e);
					}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		try(PrintWriter out = resp.getWriter();)
		{
			String subjectName=req.getParameter("subname");
			List<Book> bookList =this.dao.getBooks(subjectName);			
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Book Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action='cart'>");
			for (Book book : bookList)
			{
				out.println("<input type='checkbox' name='books' value='"+book.getBookId()+"'/>"+book.toString()+"<br/>");
			}
			out.println("<input type='submit' value='Add To Cart'/>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
				
		
		}catch(Exception e)
		{
		throw new ServletException(e);
		}
		
		
		
	}
	
	
	@Override
	public void destroy()throws RuntimeException {
		try {
			this.dao.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		
		}
		super.destroy();
	}
	
}
