package utilities;

import java.sql.Connection;

import connection.ConnectionDAO;
import dao.UserData;

public class LoginUtilities 
{
	public static boolean validateLogin( String login, String password )
	{
		Connection conn; 
		
		conn = ConnectionDAO.connection();
		
		UserData userData = new UserData( conn );
		boolean validateLogin = false;
		
		try 
		{
			validateLogin = userData.validateLogin( login, password );
		} 
		
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		
		return validateLogin;
	}
}
