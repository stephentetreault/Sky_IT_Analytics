import java.lang.String;

/*
 * This class represents an Item object. 
 * 
 * Attributes include: 
 * - State
 * - Size
 * - Region 
 * - Division 
 */
public class Item
{
	private String state;
	private int size;
	private int region;
	private int division;	
	
	public Item()
	{
		state = "";
		size = 0;
		region = 0;
		division = 0;
	}
	
	/*
	 * Get/Set methods for the class attributes
	 */
	public void setState(String x)  	
	{ 
		state = x; 
	}

	public String getState()        	
	{ 
		return state; 
	}
	
	public void setRegion(int x)
	{
		region = x;
	}
	
	public int getRegion()
	{
		return region;
	}
	
	public void setDivision(int x)
	{
		division = x;
	}
	
	public int getDivision()
	{
		return division;
	}
	
	public void setSize(int x)
	{
		size = x;
	}
	
	public int getSize()
	{
		return size;
	}
	
//	public void setNrf(String x)    	
//	{ 
//		/*
//		 * Pad NRF codes with leading zeros if needed
//		 */
//		if(x.length() == 1)
//		{
//			nrf = new StringBuilder().append("00").append(x).toString();  //not the easiest to read/maintain but its faster than String concat()
//		}
//		else if(x.length() == 2)
//		{
//			nrf = new StringBuilder().append("0").append(x).toString();
//		}
//		else
//		{
//			nrf = this.stripQuotes(x); 
//		}
//	}
//	
//	public String getNrf()         		
//	{ 
//		return nrf; 
//	}
}