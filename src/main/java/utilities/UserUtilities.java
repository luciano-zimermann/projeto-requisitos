package utilities;

import dao.UserData;
import entities.User;

public class UserUtilities 
{	
	public static void insertUser( String name, String login, String password, String permission ) throws Exception
	{
		User user = new User( name, login, password, permission );
		
		if ( user != null )
		{
			UserData userData = new UserData();
			
			userData.insert( user );
		}
	}
	
	public static void updateUser( User user ) throws Exception
	{
		UserData userData = new UserData();
		
		if ( user != null )
		{
			userData.update( user );
		}
	}
	
	public static User getUserByLoginAndPassword( String name, String password ) throws Exception
	{
		UserData userData = new UserData();

		return userData.getUserByLoginAndPassword( name, password );
	}
}
