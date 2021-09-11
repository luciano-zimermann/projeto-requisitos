package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDAO;
import connection.DataCrud;
import entities.User;

public class UserData implements DataCrud
{
    Connection con = ConnectionDAO.connection();
    PreparedStatement stmt;
    
	public UserData( Connection conn ) 
	{
	}
	
	public UserData()
	{
	}

	@Override
	public void insert( Object data ) throws Exception 
	{
		if ( data instanceof User )
		{
			User user = (User) data;
			
			String sql = "INSERT INTO users (usr_name, usr_login, usr_password, usr_permission) VALUES (?, ?, ?, ?);";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement( sql );
				stmt.setString( 1, user.getUsrName() );
				stmt.setString( 2, user.getUsrLogin() );
				stmt.setString( 3, user.getUsrPassword() );
				stmt.setString( 4, String.valueOf(user.getUsrPermission() ) );
				stmt.execute();
			}
			
			catch ( SQLException ex )
			{
				ex.printStackTrace();
			}
		}
	}
	
	@Override
	public void update( Object data ) throws Exception 
	{
		if ( data instanceof User )
		{
			User user = (User) data;
			
			String sql = "UPDATE users SET usr_name = ?, usr_login = ?, usr_password = ?, usr_permission = ? WHERE usr_id = ?";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement( sql );
				stmt.setString( 1, user.getUsrName() );
				stmt.setString( 2, user.getUsrLogin() );
				stmt.setString( 3, user.getUsrPassword() );
				stmt.setString( 4, String.valueOf(user.getUsrPermission() ) );
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
		if ( data instanceof User )
		{
			User user = (User) data;
			
			String sql = "DELETE FROM users WHERE usr_id = ?";
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement(sql);
				stmt.setInt( 1, user.getUsrId() );
				stmt.execute();
			}
			
			catch ( SQLException ex )
			{
				ex.printStackTrace();
			}
		}
	}
	
	public List<User> listUsers() throws Exception 
	{
		String sql = "SELECT * FROM users";
		
		List<User> users = new ArrayList<>();
		
		try
		{
            stmt = (PreparedStatement) con.prepareStatement( sql );
            ResultSet response = stmt.executeQuery();
            
            while ( response.next() )
            {
            	User user = new User();
            	
            	user.setUsrId( response.getInt( "usr_id" ) );
            	user.setUsrName( response.getString( "usr_name" ) );
            	user.setUsrLogin( response.getString( "usr_login" ) );
            	user.setUsrPassword( response.getString( "usr_password" ) );
            	user.setUsrPermission( response.getString( "usr_permission" ).charAt(0) );
            	
            	users.add( user );
            }
		}
		
		catch ( SQLException ex )
		{
			ex.printStackTrace();
		}
		
        return users;
	}
	
	public boolean validateLogin( String login, String password ) throws Exception
	{
		String sql = "SELECT * FROM users WHERE usr_login = + '" + login + 
					 "' AND usr_password = '" + password + "'";
		
		PreparedStatement statement = con.prepareStatement( sql );
		ResultSet resultSet = statement.executeQuery();
		
		if ( resultSet.next() )
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}
