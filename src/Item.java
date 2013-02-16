import java.lang.String;

/*
 * This class represents an Item object. 
 * 
 * Attributes include: 
 * - TPID  -- (my 1st example is just Nordstrom Retailer for client Marc Jacobs)
 * - Size
 * - Style
 * - NRF Color Code
 * - Location: 
 * 		- Store Number
 * 		- Store Name
 * 		- City
 * 		- State
 * 		- Zip Code
 * 		- Country
 * 		- Address 1
 * 		- Address 2  (possible blank values)
 * 			- Address 1 and 2 will be concatenated
 * 
 */
public class Item 
{
	private String tpid;
	private String size;
	private String style;
	private String nrf;
	private Location location;
	
	public Item()
	{
		tpid = "";
		size = "";
		style = "";
		nrf = "";
		location = new Location();
	}
	
	//Below are the Get/Set methods for the class attributes
	public void setTpid(String x)  { tpid = this.stripQuotes(x); }
	public String getTpid()        { return tpid; }
	
	public void setSize(String x)  { size = this.stripQuotes(x); }
	public String getSize()        { return size; }
	
	public void setStyle(String x) { style = this.stripQuotes(x); }
	public String getStyle()       { return style; }
	
	public void setNrf(String x)   { nrf = this.stripQuotes(x); }
	public String getNrf()         { return nrf; }
	
	/*
	 * City, State, and Zip are most granular levels. 
	 * 
	 * Region by ZipCode should be added. Consider how to approach this. 
	 */
	public void setLocation(String a, String b, String c, String d, String e, String f, String g, String h)
	{
		if(c.equals(""))
		{
			location.setStoreNum(000);
		}
		else
		{
			location.setStoreNum(Integer.parseInt(this.stripQuotes(c)));
		} 
		
		
		if(g.equals(""))
		{
			location.setZip(00000);
		}
		else
		{
			location.setZip(Integer.parseInt(this.stripQuotes(g)));
		}
		
		location.setStoreName(this.stripQuotes(d));
		location.setCity(this.stripQuotes(e));
		location.setState(this.stripQuotes(f));
		location.setCountry(this.stripQuotes(h));
		location.setAddress(this.stripQuotes(a), this.stripQuotes(b));
	}
	
	public int getLocationStoreNum()     { return location.getStoreNum(); }
	public String getLocationStoreName() { return location.getStoreName(); }
	public String getLocationCity()      { return location.getCity(); }
	public String getLocationState()     { return location.getState(); }
	public int getLocationZip()          { return location.getZip(); }
	public String getLocationCountry()   { return location.getCountry(); }
	public String getLocationAddress()   { return location.getAddress(); }
	
	// Strip enclosure quotation marks 
	public String stripQuotes(String x)  { return x.replace("\"", ""); }
}
