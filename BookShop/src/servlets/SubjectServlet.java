package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;

public class SubjectServlet extends HttpServlet 
{
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		String email = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) 
		{
			if( cookie.getName().equalsIgnoreCase("email"))
			{
				email = cookie.getValue();
				break;
			}
		}
		
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter();)
		{
			Set<String> subjects = this.dao.getSubjects();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Subject Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Welcome,"+email+"</h3><br/>");
			out.println("<form action='book'>");
			for (String subjectName : subjects) 
			{
				out.println("<input type='radio' name='subname' value='"+subjectName+"'/>"+subjectName+"<br/>");
			}
			out.println("<input type='submit' value='Show Books'/>");
			out.println("<input type='submit' value='Show Cart'formaction='showcart' />");
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