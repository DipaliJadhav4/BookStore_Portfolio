package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.UserDao;
import pojo.User;

public class ValidateServlet extends HttpServlet
{
	private UserDao dao;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		
		try {
			super.init(config);
			this.dao=new UserDao();
		} catch (Exception e) {
		
			throw new ServletException(e);
		}
	}
	
	
	@SuppressWarnings("resource")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email = req.getParameter("txtEmail");
		String password = req.getParameter("txtPassword");	
		//UserDao dao = null;
		resp.setContentType("text/html");
		
		
		try(PrintWriter out = resp.getWriter();) 
		{
			dao= new UserDao();
			
			User user = dao.validate(email,password);
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Validation Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			if( user != null )
			{
				Cookie  cookie = new Cookie("email", user.getEmail());
				resp.addCookie(cookie);
				
				List<Integer> cart = new ArrayList<>( );
				HttpSession session = req.getSession();
				session.setAttribute("BookCart", cart);
				
				String url =  resp.encodeRedirectURL("subject");
				resp.sendRedirect(url);
			}
			else
			{
				out.println("<h3>Invalid email or password.<a href='Index.html'>Retry</a></h3><br/>");
			}
			out.println("</body>");
			out.println("</html>");
			
		} catch (Exception cause) 
		{
			throw new ServletException(cause);
			
		}
	
		
	}
	
	@Override
	public void destroy()throws RuntimeException
	{
		try {
			super.destroy();
			dao.close();
		} catch (IOException e) {
		
			throw new RuntimeException(e);
			
		}
		
	}

}
