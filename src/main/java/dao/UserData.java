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
				stmt.setString( 4, user.getUsrPermission() );
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
			
			String sql = "UPDATE users SET usr_name = ?, usr_login = ?, usr_password = ?, usr_permission = ? WHERE usr_id = " + user.getUsrId();
			
			try
			{
				stmt = (PreparedStatement) con.prepareStatement( sql );
				stmt.setString( 1, user.getUsrName() );
				stmt.setString( 2, user.getUsrLogin() );
				stmt.setString( 3, user.getUsrPassword() );
				stmt.setString( 4, user.getUsrPermission() );
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
				stmt = (PreparedStatement) con.prepareStatement( sql );
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
            	user.setUsrPermission( response.getString( "usr_permission" ) );
            	
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
		boolean validate = false;
		
		String sql = "SELECT * FROM users WHERE usr_login = + '" + login + 
					 "' AND usr_password = '" + password + "'";
		
		PreparedStatement statement = con.prepareStatement( sql );
		ResultSet resultSet = statement.executeQuery();
		
		if ( resultSet.next() )
		{
			validate = true;
		}
		
		return validate;
	}
	
	public User getUserById( Integer usrId ) throws Exception
	{		
		User user = new User();
		String sql = "SELECT * FROM users";
		
		PreparedStatement statement = con.prepareStatement( sql );
		ResultSet resultSet = statement.executeQuery();
		
		while ( resultSet.next() )
		{
			if ( usrId == resultSet.getInt( 1 ) )
			{
				String usrName = resultSet.getString( 2 );
				String usrLogin = resultSet.getString( 3 );
				String usrPassword = resultSet.getString( 4 );
				String usrPermission = resultSet.getString( 5 );				

				user.setUsrId( usrId );
				user.setUsrName( usrName );
				user.setUsrLogin( usrLogin );
				user.setUsrPassword( usrPassword );
				user.setUsrPermission( usrPermission );
			}
		}
		
		return user;
	}
	
	public User getUserByLoginAndPassword( String login, String password ) throws Exception
	{
		String sql = "SELECT * FROM users WHERE usr_login = '" + login + "' AND usr_password = '" + password + "';";
		
		PreparedStatement statement = con.prepareStatement( sql );
		ResultSet resultSet = statement.executeQuery();
		
		User user = new User();
		
		if ( resultSet != null && resultSet.next() )
		{
			user.setUsrId( resultSet.getInt( "usr_id" ) );
			user.setUsrName( resultSet.getString( "usr_name" ) );
			user.setUsrLogin( resultSet.getString( "usr_login" ) );
			user.setUsrPassword( resultSet.getString( "usr_password" ) );
			user.setUsrPermission( resultSet.getString( "usr_permission" ) );	
		}
		
		return user;
	}
	
//	public User getUserByName( String name ) throws Exception 
//	{
//		String sql = "SELECT * FROM users WHERE usr_name = '" + name + " ' ";
//		
//		PreparedStatement statement = con.prepareStatement( sql );
//		ResultSet resultSet = statement.executeQuery();
//		
//		User user = new User();
//		
//		if ( resultSet != null )
//		{
//			user.setUsrId( resultSet.getInt( "usr_id" ) );
//			user.setUsrName( resultSet.getString( "usr_name" ) );
//			user.setUsrLogin( resultSet.getString( "usr_login" ) );
//			user.setUsrPassword( resultSet.getString( "usr_password" ) );
//			user.setUsrPermission( resultSet.getString( "usr_permission" ) );	
//		}
//		
//		return user;
//	}
}
