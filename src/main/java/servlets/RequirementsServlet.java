package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RequirementsData;
import entities.Requirements;
import entities.RequirementsVersion;

@WebServlet("/RequirementsServlet")
public class RequirementsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public RequirementsServlet() 
    {
    }

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException 
	{
		String action = request.getParameter( "action" );
		RequirementsData r = new RequirementsData();
		
		try
		{
			if ( action != null )
			{
				switch ( action )
				{
					case "upd":
					{
						String idUpdate = request.getParameter( "id" );
						
						Requirements requirements = r.getRequirementsById( Integer.valueOf( idUpdate ) );
						
						request.setAttribute( "requirements", requirements );
						
						RequestDispatcher destine = request.getRequestDispatcher( "update-requirements.jsp"  );
						destine.forward( request, response );
					}
					break;
					
					case "del":
					{
						String id = request.getParameter( "id" );
						Requirements requirements = new Requirements();
						requirements.setReqId( Integer.valueOf( id ) );
						r.delete( requirements );
						
						RequestDispatcher destine = request.getRequestDispatcher( "successful-deleting-requirements.jsp" );
						destine.forward( request, response );
					}
					break;
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
		String code = request.getParameter( "code" );
		String requirement = request.getParameter( "requirement" );
		String description = request.getParameter( "description" );
		String version = request.getParameter( "version" );
		String justification = request.getParameter( "justification" );
		
		try
		{
			Integer vrs = Integer.valueOf( version );
			Requirements requirements = new Requirements( code, requirement, description, vrs, justification );
			RequirementsData r = new RequirementsData();
			
			if ( id == null )
			{
				r.insert( requirements );
				response.sendRedirect( "registered-requirement.jsp" );
			}
			
			else
			{
				requirements.setReqId( Integer.valueOf( id ) );
				r.update( requirements );
				response.sendRedirect( "updated-requirement.jsp" );
			}
		}
		
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

}
