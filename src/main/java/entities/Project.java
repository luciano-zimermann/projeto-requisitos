package entities;

import java.util.Date;

public class Project 
{
	private Integer prjId;
	private String prjDescription;
	private String prjCustomer;
	private String prjStatus;
	private Date prjStartDate;
	private Date prjEndDate;
	private User prjOwner;
	
	public Project()
	{
	}
	
	public Project( Integer prjId, String prjDescription, String prjCustomer, String prjStatus, Date prjStartDate,Date prjEndDate, User prjOwner ) 
	{
		this.prjId = prjId;
		this.prjDescription = prjDescription;
		this.prjCustomer = prjCustomer;
		this.prjStatus = prjStatus;
		this.prjStartDate = prjStartDate;
		this.prjEndDate = prjEndDate;
		this.prjOwner = prjOwner;
	}

	public Integer getPrjId() 
	{
		return prjId;
	}

	public void setPrjId( Integer prjId ) 
	{
		this.prjId = prjId;
	}

	public String getPrjDescription() 
	{
		return prjDescription;
	}

	public void setPrjDescription( String prjDescription ) 
	{
		this.prjDescription = prjDescription;
	}

	public String getPrjCustomer() 
	{
		return prjCustomer;
	}

	public void setPrjCustomer( String prjCustomer ) 
	{
		this.prjCustomer = prjCustomer;
	}

	public String getPrjStatus() 
	{
		return prjStatus;
	}

	public void setPrjStatus( String prjStatus ) 
	{
		this.prjStatus = prjStatus;
	}

	public Date getPrjStartDate() 
	{
		return prjStartDate;
	}

	public void setPrjStartDate( Date prjStartDate ) 
	{
		this.prjStartDate = prjStartDate;
	}

	public Date getPrjEndDate() 
	{
		return prjEndDate;
	}

	public void setPrjEndDate( Date prjEndDate ) 
	{
		this.prjEndDate = prjEndDate;
	}

	public User getPrjOwner() 
	{
		return prjOwner;
	}

	public void setPrjOwner( User prjOwner ) 
	{
		this.prjOwner = prjOwner;
	}
	
	

}
