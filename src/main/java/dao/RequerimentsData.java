package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDAO;
import connection.DataCrud;
import entities.Requirements;
import entities.RequirementsVersion;

public class RequerimentsData implements DataCrud
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
			
			String sql = "INSERT INTO users (req_code, req_requeriment, req_description, req_version_ref) VALUES (?, ?, ?, ?);";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement( sql );
				stmt.setString( 1, requirements.getReqCode() );
				stmt.setString( 2, requirements.getReqRequeriment() );
				stmt.setString( 3, requirements.getReqDescription() );
				stmt.setObject( 4, requirements.getReqVersion() );
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
			
			String sql = "UPDATE requeriments SET req_code = ?, req_requeriment = ?, req_description = ?, req_version_ref WHERE req_id = ?";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement( sql );
				stmt.setString( 1, requirements.getReqCode() );
				stmt.setString( 2, requirements.getReqRequeriment() );
				stmt.setString( 3, requirements.getReqDescription() );
				stmt.setObject( 4, requirements.getReqVersion() );
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
			
			String sql = "DELETE FROM requeriments WHERE vrs_id = ?";
			
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
	
	public List<Requirements> listRequeriments() 
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
            	requirements.setReqVersion( (RequirementsVersion) response.getObject( "req_version_ref" ) );
            	
            	requerimentsList.add( requirements );
            }
		}
		
		catch ( SQLException ex )
		{
			ex.printStackTrace();
		}
		
        return requerimentsList;
	}

}
