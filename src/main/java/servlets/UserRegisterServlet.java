package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilities.UserUtilities;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append( "Served at: " ).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet( request, response );
		
		String name = request.getParameter( "name" );
		String login = request.getParameter( "login" );
		String password = request.getParameter( "password" );
		String permmission = request.getParameter( "permission" );
		
		try 
		{
			UserUtilities.insertUser( name, login, password, permmission );
		} 
		
		catch  ( Exception e ) 
		{
			e.printStackTrace();
		}
		
		
		
		response.sendRedirect( "registered-user.jsp" );
	}

}
