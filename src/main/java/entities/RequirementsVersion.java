package entities;

@Deprecated
public class RequirementsVersion 
{
	private Integer vrsId;
	private String vrsJustification;
	
	public RequirementsVersion()
	{
	}

	public RequirementsVersion ( Integer vrsId, String vrsJustification ) 
	{
		this.vrsId = vrsId;
		this.vrsJustification = vrsJustification;
	}

	public Integer getVrsId() 
	{
		return vrsId;
	}

	public void setVrsId( Integer vrsId ) 
	{
		this.vrsId = vrsId;
	}

	public String getVrsJustification() 
	{
		return vrsJustification;
	}

	public void setVrsJustification( String vrsJustification ) 
	{
		this.vrsJustification = vrsJustification;
	}
	
	
}
