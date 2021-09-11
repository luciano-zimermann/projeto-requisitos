package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDAO;
import connection.DataCrud;
import entities.RequirementsVersion;

public class RequerimentsVersionData implements DataCrud
{
    ConnectionDAO conexao = new ConnectionDAO();
    Connection con = ConnectionDAO.connection();
    PreparedStatement stmt;
    
	@Override
	public void insert( Object data ) 
	{
		if ( data instanceof RequirementsVersion )
		{
			RequirementsVersion requirementsVersion = (RequirementsVersion) data;
			
			String sql = "INSERT INTO requeriments_version (vrs_justification) VALUES (?)";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement( sql );
				stmt.setString( 1, requirementsVersion.getVrsJustification() );
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
		if ( data instanceof RequirementsVersion )
		{
			RequirementsVersion requirementsVersion = (RequirementsVersion) data;
			
			String sql = "UPDATE requeriments_version SET vrs_justification = ? WHERE vrs_id = ?";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement( sql );
				stmt.setString( 1, requirementsVersion.getVrsJustification() );
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
		if ( data instanceof RequirementsVersion )
		{
			RequirementsVersion requirementsVersion = (RequirementsVersion) data;
			
			String sql = "DELETE FROM requeriments_version WHERE vrs_id = ?";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement(sql);
				stmt.setInt( 1, requirementsVersion.getVrsId() );
				stmt.execute();
			}
			
			catch ( SQLException ex )
			{
				ex.printStackTrace();
			}
		}
	}

	public List<RequirementsVersion> listRequerimentsVersion() 
	{
		String sql = "SELECT * FROM requeriments_version";
		
		List<RequirementsVersion> requerimentsVersionList = new ArrayList<>();
		
		try
		{
            stmt = (PreparedStatement) con.prepareStatement( sql );
            ResultSet response = stmt.executeQuery();
            
            while ( response.next() )
            {
            	RequirementsVersion requirementsVersion = new RequirementsVersion();
            	
            	requirementsVersion.setVrsId( response.getInt( "vrs_id" ) );
            	requirementsVersion.setVrsJustification( response.getString( "vrs_justification" ) );
            	
            	requerimentsVersionList.add( requirementsVersion );
            }
		}
		
		catch ( SQLException ex )
		{
			ex.printStackTrace();
		}
		
        return requerimentsVersionList;
	}
}
