package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) 
		{
			if( cookie.getName().equalsIgnoreCase("email"))
			{
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				break;
			}
		}
		
		HttpSession session = request.getSession( false );
		if( session != null )
			session.invalidate();
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter();)
		{
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Logout Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("You are successfully logged out.<a href='Login.html'>Login Again</a><br/>");
			out.println("</body>");
			out.println("</html>");
		}
		catch (Exception cause) 
		{
			throw new ServletException(cause);
		}
	}

	
	
	
	
	
	

}
