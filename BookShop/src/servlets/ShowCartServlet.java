package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao;
import pojo.Book;



public class ShowCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BookDao dao;
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		try
		{
			super.init(config);
			this.dao = new BookDao();
		} 
		catch (Exception cause) 
		{
			throw new ServletException( cause );
		}
	}
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter();)
		{
			HttpSession session = request.getSession( false );
			List<Integer> cart = null;
			if( session != null )
				cart  = (List<Integer>) session.getAttribute("BookCart");
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Show Cart Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action='logout'>");
			if( cart != null )
			{
				Book book = null;
				out.println("<hr/>");
				out.println("<h1>Selected Books are : </h1><br/>");
				
				for (int bookId : cart) 
				{
					book = dao.getBook(bookId);
					out.println("<h3>"+book.toString()+"</h3>");		
				}
				
			}
			out.println("<input type='submit' value='Logout'/>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
		catch (Exception cause) 
		{
			throw new ServletException(cause);
		}
	}
	@Override
	public void destroy() throws RuntimeException
	{
		try
		{
			this.dao.close();
		} 
		catch (IOException cause )
		{
			throw new RuntimeException(cause);
		}
	}

}
