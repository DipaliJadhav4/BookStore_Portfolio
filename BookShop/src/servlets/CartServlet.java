package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession( false );
		if( session != null )
		{
			@SuppressWarnings("unchecked")
			List<Integer> cart  = (List<Integer>) session.getAttribute("BookCart");
			String[] strBookIds = request.getParameterValues("books");
			for (String strBookId : strBookIds) 
			{
				int bookId = Integer.parseInt(strBookId);
				cart.add(bookId);
			}
		}
		String url = response.encodeRedirectURL("subject");
		response.sendRedirect(url);
	}

}
