package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserData;
import entities.User;
import utilities.UserUtilities;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public UserServlet() 
    {
        super();
    }

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException 
	{	
		String action = request.getParameter( "action" );
		UserData userData;
		
		try
		{
			if ( action != null )
			{
				switch ( action )
				{
					case "upd":
					{
						userData = new UserData();
						
						String idUpdate = request.getParameter( "id" );
						
						User user = userData.getUserById( Integer.valueOf( idUpdate ) );
						
						request.setAttribute( "user", user );
						
						RequestDispatcher destine = request.getRequestDispatcher( "update-user.jsp" );
						destine.forward( request, response );
					}
				}
			}
		}
		
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException 
	{
		doGet( request, response );
		
		String id = request.getParameter( "id" );
		String name = request.getParameter( "name" );
		String login = request.getParameter( "login" );
		String password = request.getParameter( "password" );
		String permmission = request.getParameter( "permission" );
		
		try 
		{
			if ( id == null )
			{
				UserUtilities.insertUser( name, login, password, permmission );
				response.sendRedirect( "registered-user.jsp" );
			}
			
			else
			{
				String userId = request.getParameter( "id" );
				User user = new User();
				
				user.setUsrId( Integer.valueOf( userId ) );
				user.setUsrName( name );
				user.setUsrLogin( login );
				user.setUsrPassword( password );
				user.setUsrPermission( permmission );
				
				UserUtilities.updateUser( user );
				response.sendRedirect( "updated-user.jsp" );
			}
		} 
		
		catch ( Exception e ) 
		{
			e.printStackTrace();
		}
	}
}
