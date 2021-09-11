package utilities;

import java.sql.Connection;
import connection.ConnectionDAO;
import dao.UserData;
import entities.User;

public class UserUtilities 
{	
	public static void insertUser( String name, String login, String password, String permission ) throws Exception
	{
		Connection conn; 
		
		conn = ConnectionDAO.connection();
		
		UserData userData = new UserData( conn );
		
		char permissionMode = permission.charAt(0);
		
		User user = new User( name, login, password, permissionMode );
		
		if ( user != null )
		{
			userData = new UserData( conn );
			
			userData.insert( user );
		}
	}
}
