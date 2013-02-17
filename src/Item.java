import java.lang.String;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

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
	private int size;
	private Region region;  //Region will contain subregion of division
	
	/*
	 * The idea behind this is I have a set of unique styles and ints are easier to work 
	 * with than strings, with less overhead usually. So I'm going to read in a String size from my data set
	 * and get the index of it in the list. That index from the list will be an integer representation of 
	 * my size. 
	 * 
	 * I have queried the MJ DB for distinct size and took the majority of the most common
	 * sizes. This of course is working under an assumption that there are no sizes outside of this
	 * set. Just initial planning, though. 
	 * 
	 * This "size index" will also be interacting with the data grid. 
	 * 
	 * -1 will be returned if size is not found.
	 * 
	 */
	private final static List<String> SIZE_MAP = Arrays.asList(new String[] {"0","2","4","6","7","8","10","12",
																			  "23","24","25","26","27","28","29","30",
															   			      "31","32","34","34.5","35","35.5","36","36.5",
																			  "37","37.5","38","38.5","39","39.5","40","40.5",
																 		      "41","41.5","42","L","L/XL","M","M/L","O/S","S",
																			  "S/M","XL","XS","XS/S","XXL","XXS", "WS1"});
	
	public Item()
	{
		tpid = "";
		storeNum = "";
		city = "";
		state = "";
		zip = "";
		country = "";
		size = 0;
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
	
	/*
	 * Will cause trouble if size not found and indexOf() returns -1
	 */
	public void setSize(String x)  		{ size = SIZE_MAP.indexOf(this.stripQuotes(x)); }
	public int getSize()        		{ return size; }
	
	public void setStyle(String x)   	{ style = this.stripQuotes(x); }
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