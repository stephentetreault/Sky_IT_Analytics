import java.lang.String;

/*
 * This class represents a location object. 
 */
public class Location 
{
	private int storeNum;
	private String storeName;
	private String city;
	private String state;
	private int zip;
	private String country;
	private String address;
	
	/*
	 * Default constructor
	 */
	public Location()
	{
		storeNum = 0;
		storeName = "";
		city = "";
		state = "";
		zip = 0;
		country = "";
		address = "";
	}
	
	/*
	 * Override default constructor
	 * 
	 * Params: 
	 * 	- address 1 = a
 	 *  - address 2 = b
 	 *  - store number = c
 	 *  - store name = d
 	 *  - city = e
 	 *  - state = f
 	 *  - zip = g
 	 *  - country = h
	 */
	public Location(String adrs1, String adrs2, int sNum, String sName, String cityParam, String stateParam, int zipCode, String countryParam)
	{
		this.setAddress(adrs1, adrs2);
		storeNum = sNum;
		storeName = sName;
		city = cityParam;
		state = stateParam;
		zip = zipCode;
		country = countryParam;
	}
	
	public void setStoreNum(int x)     { storeNum = x; }
	public int getStoreNum()           { return storeNum; }
	
	public void setStoreName(String x) { storeName = x; }
	public String getStoreName()       { return storeName; }
	
	public void setCity(String x)      { city = x; }
	public String getCity()            { return city; }
	
	public void setState(String x)     { state = x; }
	public String getState()           { return state; }
	
	public void setZip(int  x)         { zip = x; }
	public int getZip()                { return zip; }
	
	public void setCountry(String x)   { country = x; }
	public String getCountry()         { return country; }
	
	//could use x + y, but concat() is more efficient internally
	public void setAddress(String x, String y) 
	{ 
		if (y.equals("") && !x.equals("")) 
		{
			address = x;
		}
		else if (!y.equals("") && !x.equals(y))
		{
			address = x.concat(y);
		}
		else
		{
			address = "ADDRESS NA.";
		}
	}  
	
	public String getAddress() { return address; }	
	
	// toString() methods for int variables. Probably wont be used.
	public String storeNumToString() { return Integer.toString(storeNum); }
	public String zipToString() { return Integer.toString(zip); }	
}
