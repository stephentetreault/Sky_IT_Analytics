import java.lang.String;
import java.util.*;


/*
 * This class represents an Item object. 
 */
public class Item
{
	/*
	 * Static, numeric representation of region
	 */
	private final static int NORTHEAST = 1;
	private final static int MIDWEST = 2;
	private final static int SOUTH = 3;
	private final static int WEST = 4;
	
	/*
	 * Static representation of division
	 */
	private final static int NEW_ENGLAND = 1;
	private final static int MID_ATLANTIC = 2;
	private final static int EAST_NORTH_CENTRAL = 3;
	private final static int WEST_NORTH_CENTRAL = 4;
	private final static int SOUTH_ATLANTIC = 5;
	private final static int EAST_SOUTH_CENTRAL = 6;
	private final static int WEST_SOUTH_CENTRAL = 7;
	private final static int MOUNTAIN = 8;
	private final static int PACIFIC = 9;
	
	/*
	 * This implementation will allow for a fast lookup of region/division by state
	 */
	private final static Set<String> DIVISION_ONE = new HashSet<String>(Arrays.asList(new String[]   {"CT", "ME", "MA", "NH", "RI", "VT"}));
	private final static Set<String> DIVISION_TWO = new HashSet<String>(Arrays.asList(new String[]   {"NY", "PA", "NJ"}));
	private final static Set<String> DIVISION_THREE = new HashSet<String>(Arrays.asList(new String[] {"WI", "MI", "IL", "IN", "OH"}));
	private final static Set<String> DIVISION_FOUR = new HashSet<String>(Arrays.asList(new String[]  {"MO", "ND", "SD", "NE", "KS", "MN", "IA"}));
	private final static Set<String> DIVISION_FIVE = new HashSet<String>(Arrays.asList(new String[]  {"DE", "MD", "DC", "VA", "WV", "NC", "SC", "GA", "FL"}));
	private final static Set<String> DIVISION_SIX = new HashSet<String>(Arrays.asList(new String[]   {"KY", "TN", "MS", "AL"}));
	private final static Set<String> DIVISION_SEVEN = new HashSet<String>(Arrays.asList(new String[] {"OK", "TX", "AR", "LA"}));
	private final static Set<String> DIVISION_EIGHT = new HashSet<String>(Arrays.asList(new String[] {"ID", "MT", "WY", "NV", "UT", "CO", "AZ", "NM"}));
	private final static Set<String> DIVISION_NINE = new HashSet<String>(Arrays.asList(new String[]  {"AK", "WA", "OR", "CA", "HA", "HI"})); //HI and HA for Hawaii 
	
	/*
	 * Static list of sizes to map size to an integer value. 
	 * "SKIP" is placed in 0 element of array so size isn't represented as a 0 value
	 */
	private final static List<String> SIZE_MAP = Arrays.asList(new String[] {"SKIP","0","2","4","6","7","8","10","12",
			  																	"23","24","25","26","27","28","29","30",
			  																	"31","32","34","34.5","35","35.5","36","36.5",
			  																	"37","37.5","38","38.5","39","39.5","40","40.5",
			  																	"41","41.5","42","L","L/XL","M","M/L","O/S","S",
			  																	"S/M","XL","XS","XS/S","XXL","XXS", "WS1"});
	
	/*
	 * Item object variables
	 */
	private String tpid;
	private String country;
	private String city;
	private String state;
	private int size;
	private int region;
	private int division;
	private String nrf;
	private int unitsSold;
	private double salesDollars;
	
	//Constructor
	public Item()
	{
		tpid = "";
		country = "";
		state = "";
		city = "";
		size = 0;
		nrf = "";
		unitsSold = 0;
		salesDollars = 0.00;
		region = 0;
		division = 0;
	}
	
	/*
	 * Get/Set methods for the class attributes
	 */
	public void setTPID(String x)
	{
		tpid = x;
	}
	
	public String getTPID()
	{
		return tpid;
	}
	
	public void setCountry(String x)
	{
		country = x;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public void setCity(String x)
	{
		city = x;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setState(String x)  	
	{ 
		state = x; 
	}

	public String getState()        	
	{ 
		return state; 
	}
	
	public void setSize(String x)  	
	{ 
		size = SIZE_MAP.indexOf(x);
	}

	public int getSize()        	
	{ 
		return size; 
	}
	
	public void setRegionAndDivision(String x)  	
	{ 
		if(DIVISION_ONE.contains(state))
		{
			region = NORTHEAST;
			division = NEW_ENGLAND;
		}
		else if(DIVISION_TWO.contains(state))
		{
			region = NORTHEAST;
			division = MID_ATLANTIC;
		}
		else if(DIVISION_THREE.contains(state))
		{
			region = MIDWEST;
			division = EAST_NORTH_CENTRAL;
		}
		else if(DIVISION_FOUR.contains(state))
		{
			region = MIDWEST;
			division = WEST_NORTH_CENTRAL;
		}
		else if(DIVISION_FIVE.contains(state))
		{
			region = SOUTH;
			division = SOUTH_ATLANTIC;
		}
		else if(DIVISION_SIX.contains(state))
		{
			region = SOUTH;
			division = EAST_SOUTH_CENTRAL;
		}
		else if(DIVISION_SEVEN.contains(state))
		{
			region = SOUTH;
			division = WEST_SOUTH_CENTRAL;
		}
		else if(DIVISION_EIGHT.contains(state))
		{
			region = WEST;
			division = MOUNTAIN;
		}
		else if(DIVISION_NINE.contains(state))
		{
			region = WEST;
			division = PACIFIC;
		}
	}

	public int getRegion()        	
	{ 
		return region; 
	}
	
	public int getDivision()
	{
		return division;
	}
	
	public void setNRF(String x)  	
	{ 
		nrf = x; 
	}

	public String getNRF()        	
	{ 
		return nrf; 
	}
	
	public void setUnitsSold(String x)  	
	{ 
		unitsSold = Integer.parseInt(x);
	}

	public int getUnitsSold()        	
	{ 
		return unitsSold; 
	}
	
	public void setSalesDollars(String x)  	
	{ 
		salesDollars = Double.parseDouble(x);
	}

	public double getSalesDollars()        	
	{ 
		return salesDollars; 
	}
}