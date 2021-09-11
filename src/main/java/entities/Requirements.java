package entities;

public class Requirements 
{
	private Integer reqId;
	private String reqCode;
	private String reqRequeriment;
	private String reqDescription;
	private RequirementsVersion reqVersion;
	
	public Requirements()
	{
	}

	public Requirements( Integer reqId, String reqCode, String reqRequeriment, String reqDescription,RequirementsVersion reqVersion ) 
	{
		this.reqId = reqId;
		this.reqCode = reqCode;
		this.reqRequeriment = reqRequeriment;
		this.reqDescription = reqDescription;
		this.reqVersion = reqVersion;
	}

	public Integer getReqId() 
	{
		return reqId;
	}

	public void setReqId( Integer reqId ) 
	{
		this.reqId = reqId;
	}

	public String getReqCode() 
	{
		return reqCode;
	}

	public void setReqCode( String reqCode ) 
	{
		this.reqCode = reqCode;
	}

	public String getReqRequeriment() 
	{
		return reqRequeriment;
	}

	public void setReqRequeriment( String reqRequeriment ) 
	{
		this.reqRequeriment = reqRequeriment;
	}

	public String getReqDescription() 
	{
		return reqDescription;
	}

	public void setReqDescription( String reqDescription ) 
	{
		this.reqDescription = reqDescription;
	}

	public RequirementsVersion getReqVersion() 
	{
		return reqVersion;
	}

	public void setReqVersion( RequirementsVersion reqVersion ) 
	{
		this.reqVersion = reqVersion;
	}
	
	
}
