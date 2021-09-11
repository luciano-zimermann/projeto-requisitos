package entities;

import utilities.UserUtilities;

public class User 
{
	private Integer usrId;
	private String usrName;
	private String usrLogin;
	private String usrPassword;
	private char usrPermission;
	
	public User()
	{	
	}

	public User( String usrName, String usrLogin, String usrPassword, char usrPermission ) 
	{
		this.usrName = usrName;
		this.usrLogin = usrLogin;
		this.usrPassword = usrPassword;
		this.usrPermission = usrPermission;
	}

	public Integer getUsrId() 
	{
		return usrId;
	}

	public void setUsrId( Integer usrId ) 
	{
		this.usrId = usrId;
	}

	public String getUsrName() 
	{
		return usrName;
	}

	public void setUsrName( String usrName ) 
	{
		this.usrName = usrName;
	}

	public String getUsrLogin() 
	{
		return usrLogin;
	}

	public void setUsrLogin( String usrLogin ) 
	{
		this.usrLogin = usrLogin;
	}

	public String getUsrPassword() 
	{
		return usrPassword;
	}

	public void setUsrPassword( String usrPassword ) 
	{
		this.usrPassword = usrPassword;
	}

	public char getUsrPermission() throws Exception 
	{	
		return usrPermission;
	}

	public void setUsrPermission( char usrPermission ) throws Exception 
	{		
		this.usrPermission = usrPermission;
	}
}
