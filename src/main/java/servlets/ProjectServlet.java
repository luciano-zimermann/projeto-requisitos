package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjectData;
import dao.UserData;
import entities.Project;
import entities.User;

@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ProjectServlet() 
    {
    }

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException 
	{
		String action = request.getParameter( "action" );
		ProjectData p = new ProjectData();
		
		try
		{
			if ( action != null )
			{
				switch ( action )
				{
					case "upd":
					{
						String idUpdate = request.getParameter( "id" );
						
						Project project = p.getProjectById( Integer.valueOf( idUpdate ) );
						
						request.setAttribute( "project", project );
						
						RequestDispatcher destine = request.getRequestDispatcher( "update-project.jsp" );
						destine.forward( request, response );
					}
					break;
					
					case "del":
					{
						String id = request.getParameter( "id" );
						Project project = new Project();
						project.setPrjId( Integer.valueOf( id ) );
						p.delete( project );
						
						RequestDispatcher destine = request.getRequestDispatcher( "successful-deleting-project.jsp" );
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
		String description = request.getParameter( "description" );
		String customer = request.getParameter( "customer" );
		String status = request.getParameter( "status" );
		String startDate = request.getParameter( "start-date" );
		String endDate = request.getParameter( "end-date" );
		String owner = request.getParameter( "owner" );
				
		try
		{
			User user = new User();
			
			user.setUsrName( owner );
			
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
			Date projectStartDate = sdf.parse( startDate );
			Date projectEndDate = sdf.parse( endDate );
			
			Project project = new Project( description, customer, status, projectStartDate, projectEndDate, user );
			ProjectData p = new ProjectData();
			
			if ( id == null )
			{
				p.insert( project );
				response.sendRedirect( "registered-project.jsp" );
			}
			
			else
			{
				project.setPrjId( Integer.valueOf( id ) );
				p.update( project );
				response.sendRedirect( "updated-project.jsp" );
			}
		}
		
		catch ( Exception e ) 
		{
			e.printStackTrace();
		}
	}
}
