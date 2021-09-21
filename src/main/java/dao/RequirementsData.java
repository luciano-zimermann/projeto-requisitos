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
import entities.Requirements;
import entities.RequirementsVersion;
import entities.User;

public class RequirementsData implements DataCrud
{
    ConnectionDAO conexao = new ConnectionDAO();
    Connection con = ConnectionDAO.connection();
    PreparedStatement stmt;
	
	@Override
	public void insert( Object data ) 
	{
		if ( data instanceof Requirements )
		{
			Requirements requirements = (Requirements) data;
			
			String sql = "INSERT INTO requeriments (req_code, req_requeriment, req_description, req_version, req_justification) VALUES (?, ?, ?, ?, ?);";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement( sql );
				stmt.setString( 1, requirements.getReqCode() );
				stmt.setString( 2, requirements.getReqRequeriment() );
				stmt.setString( 3, requirements.getReqDescription() );
				stmt.setInt( 4, requirements.getReqVersion() );
				stmt.setString( 5, requirements.getReqJustification() );
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
		if ( data instanceof Requirements )
		{
			Requirements requirements = (Requirements) data;
			
			String sql = "UPDATE requeriments SET req_code = ?, req_requeriment = ?, req_description = ?, req_version = ?, req_justification = ? "
					+ "WHERE req_id = ' " +requirements.getReqId() + " ' ";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement( sql );
				stmt.setString( 1, requirements.getReqCode() );
				stmt.setString( 2, requirements.getReqRequeriment() );
				stmt.setString( 3, requirements.getReqDescription() );
				stmt.setInt( 4, requirements.getReqVersion() );
				stmt.setString( 5, requirements.getReqJustification() );
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
		if ( data instanceof Requirements )
		{
			Requirements requirements = (Requirements) data;
			
			String sql = "DELETE FROM requeriments WHERE req_id = ?";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement(sql);
				stmt.setInt( 1, requirements.getReqId() );
				stmt.execute();
			}
			
			catch ( SQLException ex )
			{
				ex.printStackTrace();
			}
		}
	}
	
	public List<Requirements> listRequeriments() throws Exception 
	{
		String sql = "SELECT * FROM requeriments";
		
		List<Requirements> requerimentsList = new ArrayList<>();
		
		try
		{
            stmt = (PreparedStatement) con.prepareStatement( sql );
            ResultSet response = stmt.executeQuery();
            
            while ( response.next() )
            {
            	Requirements requirements = new Requirements();
            	
            	requirements.setReqId( response.getInt( "req_id" ) );
            	requirements.setReqCode( response.getString( "req_code" ) );
            	requirements.setReqRequeriment( response.getString( "req_requeriment" ) );
            	requirements.setReqDescription( response.getString( "req_description" ) );
            	requirements.setReqVersion( response.getInt( "req_version" ) );
            	requirements.setReqJustification( response.getString( "req_justification" ) );
            	
            	requerimentsList.add( requirements );
            }
		}
		
		catch ( SQLException ex )
		{
			ex.printStackTrace();
		}
		
        return requerimentsList;
	}
	
	public Requirements getRequirementsById( Integer id ) throws Exception 
	{
		Requirements requirements = new Requirements();
		String sql = "SELECT * FROM requeriments";
		
		PreparedStatement statement = con.prepareStatement( sql );
		ResultSet resultSet = statement.executeQuery();
		
		while ( resultSet.next() )
		{
			if ( id == resultSet.getInt( 1 ) )
			{
				String code = resultSet.getString( 2 );
				String requirement = resultSet.getString( 3 );
				String description = resultSet.getString( 4 );
				Integer version =  resultSet.getInt( 5 );
				String justification = resultSet.getString( 6 ); 
				
				requirements.setReqId( id );
				requirements.setReqCode( code );
				requirements.setReqRequeriment( requirement );
				requirements.setReqDescription( description );
				requirements.setReqVersion( version );
				requirements.setReqJustification( justification );
			}
		}
		
		return requirements;
	}
}
