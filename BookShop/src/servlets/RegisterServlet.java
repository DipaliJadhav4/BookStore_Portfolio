package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import pojo.User;

public class RegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private UserDao dao;
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		try
		{
			super.init(config);
			this.dao = new UserDao();
		} 
		catch (Exception cause) 
		{
			throw new ServletException( cause );
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		User user = new User();
		user.setFull_name( request.getParameter("txtFullName") );
		user.setEmail( request.getParameter("txtEmail") );
		user.setPassword( request.getParameter("txtPassword"));
	//	user.setBirth_date(Date.valueOf(request.getParameter("txtBirthDate")));
		
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter();)
		{
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Registration Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			dao.registerUser( user );
			out.println("<h3>Registration is successful.<a href='Login.html'>Login</a></h3><br/>");
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