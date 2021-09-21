package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDAO;
import connection.DataCrud;
import entities.Project;
import entities.User;

public class ProjectData implements DataCrud 
{
    ConnectionDAO conexao = new ConnectionDAO();
    Connection con = ConnectionDAO.connection();
    PreparedStatement stmt;
    
	@Override
	public void insert( Object data ) 
	{
		if ( data instanceof Project )
		{
			Project project = (Project) data;
			
			String sql = "INSERT INTO projects (prj_description, prj_customer, prj_status, prj_start_date, prj_end_date, prj_usr_owner_ref) "
					   + "VALUES (?, ?, ?, ?, ?, ?);";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement( sql );
				stmt.setString( 1, project.getPrjDescription() );
				stmt.setString( 2, project.getPrjCustomer() );
				stmt.setString( 3, project.getPrjStatus() );
				stmt.setDate( 4, new java.sql.Date( project.getPrjStartDate().getTime() ) );
				stmt.setDate( 5, new java.sql.Date( project.getPrjEndDate().getTime() ) );
				stmt.setInt( 6, project.getPrjOwner().getUsrId() );
				stmt.execute();
			}
			
			catch ( SQLException ex )
			{
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void update( Object data ) 
	{
		if ( data instanceof Project )
		{
			Project project = (Project) data;
			
			String sql = "UPDATE projects SET prj_description = ?, prj_customer = ?, prj_status = ?, prj_start_date = ?, prj_end_date = ?,"
					   + " prj_usr_owner_ref = ? WHERE prj_id = '" + project.getPrjId() + " ' ";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement( sql );
				stmt.setString( 1, project.getPrjDescription() );
				stmt.setString( 2, project.getPrjCustomer() );
				stmt.setString( 3, project.getPrjStatus() );
				stmt.setDate( 4, new java.sql.Date( project.getPrjStartDate().getTime() ) );
				stmt.setDate( 5, new java.sql.Date( project.getPrjEndDate().getTime() ) );
				stmt.setInt( 6, project.getPrjOwner().getUsrId() );
				stmt.execute();
			}
			
			catch ( SQLException ex )
			{
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void delete( Object data ) 
	{
		if ( data instanceof Project )
		{
			Project project = (Project) data;
			
			String sql = "DELETE FROM projects WHERE prj_id = ?";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement(sql);
				stmt.setInt( 1, project.getPrjId() );
				stmt.execute();
			}
			
			catch ( SQLException ex )
			{
				ex.printStackTrace();
			}
		}
	}

	public List<Project> listProjects() 
	{
		String sql = "SELECT * FROM projects";
		
		List<Project> projects = new ArrayList<>();
		
		try
		{
            stmt = (PreparedStatement) con.prepareStatement( sql );
            ResultSet response = stmt.executeQuery();
            
            while ( response.next() )
            {
            	Project project = new Project();
            	
            	project.setPrjId( response.getInt( "prj_id" ) );
            	project.setPrjDescription( response.getString( "prj_description" ) );
            	project.setPrjCustomer( response.getString( "prj_customer" ) );
            	project.setPrjStatus( response.getString( "prj_status" ) );
            	project.setPrjStartDate( response.getDate( "prj_start_date" ) );
            	project.setPrjEndDate( response.getDate( "prj_end_date" ) );
            	project.setPrjOwner( getUser( response.getInt( "prj_usr_owner_ref" ) ) );
            	
            	projects.add( project );
            }
		}
		
		catch ( Exception ex )
		{
			ex.printStackTrace();
		}
		
        return projects;
	}
	
	public Project getProjectById( Integer id ) throws Exception
	{		
		Project project = new Project();
		String sql = "SELECT * FROM projects";
		
		PreparedStatement statement = con.prepareStatement( sql );
		ResultSet resultSet = statement.executeQuery();
		
		while ( resultSet.next() )
		{
			if ( id == resultSet.getInt( 1 ) )
			{
				String description = resultSet.getString( 2 );
				String customer = resultSet.getString( 3 );
				String status = resultSet.getString( 4 );
				Date startDate = resultSet.getDate( 5 );
				Date endDate = resultSet.getDate( 6 );
				User owner = getUser( resultSet.getInt( 7 ) );

				project.setPrjId( id );
				project.setPrjDescription( description );
				project.setPrjCustomer( customer );
				project.setPrjStatus( status );
				project.setPrjStartDate( startDate );
				project.setPrjEndDate( endDate );
				project.setPrjOwner( owner );	
			}
		}
		
		return project;
	}
	
	public User getUser( int userId ) throws Exception
	{
		UserData ud = new UserData();
		User user = new User();
		
		for ( User u : ud.listUsers() )
		{
			if ( u.getUsrId() == userId )
			{
				user.setUsrId( u.getUsrId() );
				user.setUsrName( u.getUsrName() );
				user.setUsrLogin( u.getUsrLogin() );
				user.setUsrPassword( u.getUsrPassword() );
				user.setUsrPermission( u.getUsrPermission() );
			}
			
			break;
		}
		
		return user;
	}
}
