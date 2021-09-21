package entities;

public class Requirements 
{
	private Integer reqId;
	private String reqCode;
	private String reqRequeriment;
	private String reqDescription;
	private Integer reqVersion;
	private String reqJustification;
	
	public Requirements()
	{
	}

	public Requirements( String reqCode, String reqRequeriment, String reqDescription, Integer reqVersion, String reqJustification ) 
	{
		this.reqCode = reqCode;
		this.reqRequeriment = reqRequeriment;
		this.reqDescription = reqDescription;
		this.reqVersion = reqVersion;
		this.reqJustification = reqJustification;
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

	public Integer getReqVersion() 
	{
		return reqVersion;
	}

	public void setReqVersion( Integer reqVersion ) 
	{
		this.reqVersion = reqVersion;
	}
	
	public String getReqJustification() 
	{
		return reqJustification;
	}
	
	public void setReqJustification( String reqJustification ) 
	{
		this.reqJustification = reqJustification;
	}
}
