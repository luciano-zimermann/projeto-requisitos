package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.User;
import utilities.LoginUtilities;
import utilities.UserUtilities;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException 
	{
		response.getWriter().append( "Served at: " ).append( request.getContextPath() );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException 
	{
		doGet( request, response );
		
		String login = request.getParameter( "login" );
		String password = request.getParameter( "password" );
		
		boolean validateLogin = LoginUtilities.validateLogin( login, password );
		
		try
		{
			User user = new User();
			
			if ( validateLogin )
			{	
				if ( login.isEmpty() )
				{
					response.sendRedirect( "login.jsp" );
				}
				
				else
				{	
					user = UserUtilities.getUserByLoginAndPassword( login, password );
					boolean userIsAdmin = user.getUsrPermission().equals( "administrador" )
										|| user.getUsrPermission().equals( "administrator" );
					
					if ( user != null )
					{	
						if ( userIsAdmin ) 
						{
							response.sendRedirect( "administrator-account.jsp" );
						}
						
						else
						{
							response.sendRedirect( "user-account.jsp" );
						}
					}
				}
			}
			
			else
			{
				response.sendRedirect( "login-error.jsp" );	
			}
		}
		
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}
