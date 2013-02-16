import java.lang.String;

/*
 * This class represents an Item object. 
 * 
 * Attributes include: 
 * - TPID  
 * - Store Number
 * - City
 * - State
 * - Zip
 * - Country
 * - Style
 * - NRF Code
 * - Size
 * - Region 
 * - Division 
 */

public class Item
{
	private String tpid;
	private String storeNum;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String style;
	private String nrf;
	private String size;
	private Region region;  //Region will contain subregion of division
	
	public Item()
	{
		tpid = "";
		storeNum = "";
		city = "";
		state = "";
		zip = "";
		country = "";
		size = "";
		style = "";
		nrf = "";
		region = new Region();
	}
	
	/*
	 * Get/Set methods for the class attributes
	 */
	public void setTpid(String x)  		{ tpid = this.stripQuotes(x); }
	public String getTpid()        		{ return tpid; }
	
	public void setStoreNum(String x)   { storeNum = this.stripQuotes(x); }
	public String getStoreNum()         { return storeNum; }
	
	public void setCity(String x)  		{ city = this.stripQuotes(x); }
	public String getCity()        		{ return city; }
	
	public void setState(String x)  	{ state = this.stripQuotes(x); }
	public String getState()        	{ return state; }
	
	public void setZip(String x)  		{ zip = this.stripQuotes(x); }
	public String getZip()        		{ return zip; }
	
	public void setCountry(String x)  	{ country = this.stripQuotes(x); }
	public String getCountry()        	{ return country; }
	
	public void setSize(String x)  		{ size = this.stripQuotes(x); }
	public String getSize()        		{ return size; }
	
	public void setStyle(String x) 		{ style = this.stripQuotes(x); }
	public String getStyle()       		{ return style; }
	
	public void setNrf(String x)    	
	{ 
		/*
		 * Pad NRF codes with leading zeros if needed
		 */
		if(x.length() == 1)
		{
			nrf = new StringBuilder().append("00").append(x).toString();
		}
		else if(x.length() == 2)
		{
			nrf = new StringBuilder().append("0").append(x).toString();
		}
		else
		{
			nrf = this.stripQuotes(x); 
		}
	}
	public String getNrf()         		{ return nrf; }
	
	public void setRegion(String x)  	{ region.setRegionAndDivision(x); }
	public int getItemRegion()        	{ return region.getRegion(); }
	public int getItemDivision()		{ return region.getDivision(); }
	
	// Strip enclosure quotation marks 
	public String stripQuotes(String x)  { return x.replace("\"", ""); }
}