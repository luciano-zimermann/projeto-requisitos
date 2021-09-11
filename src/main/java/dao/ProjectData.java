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
import entities.RequirementsVersion;
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
				stmt.setDate( 4, (Date) project.getPrjStartDate() );
				stmt.setDate( 5, (Date) project.getPrjEndDate() );
				stmt.setObject( 6, project.getPrjOwner() );
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
					   + " prj_usr_owner_ref = ? WHERE vrs_id = ?";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement( sql );
				stmt.setString( 1, project.getPrjDescription() );
				stmt.setString( 2, project.getPrjCustomer() );
				stmt.setString( 3, project.getPrjStatus() );
				stmt.setDate( 4, (Date) project.getPrjStartDate() );
				stmt.setDate( 5, (Date) project.getPrjEndDate() );
				stmt.setObject( 6, project.getPrjOwner() );
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
			
			String sql = "DELETE FROM projects WHERE vrs_id = ?";
			
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
            	project.setPrjDescription( response.getString( "vrs_description" ) );
            	project.setPrjCustomer( response.getString( "prj_customer" ) );
            	project.setPrjStatus( response.getString( "prj_status" ) );
            	project.setPrjStartDate( response.getDate( "prj_start_date" ) );
            	project.setPrjEndDate( response.getDate( "prj_end_date" ) );
            	project.setPrjOwner( (User) response.getObject( "prj_usr_owner_ref" ) );
            	
            	projects.add( project );
            }
		}
		
		catch ( SQLException ex )
		{
			ex.printStackTrace();
		}
		
        return projects;
	}
}
