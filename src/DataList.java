import java.lang.String;
import java.util.*;

/*
 * Class for a data grid which will contain the counts for occurrences of sizes
 * in regions and divisions. 
 */
public class DataList 
{
	/*
	 * Region values, can be determined via the state an item was sold in. Zip code not needed.
	 */
	private final static int NORTHEAST = 0;
	private final static int MIDWEST = 1;
	private final static int SOUTH = 2;
	private final static int WEST = 3;
	
	/*
	 * Division values, can be determined via the state an item was sold in. Zip code not needed.
	 */
	private final static int NEW_ENGLAND = 0;
	private final static int MID_ATLANTIC = 1;
	private final static int EAST_NORTH_CENTRAL = 2;
	private final static int WEST_NORTH_CENTRAL = 3;
	private final static int SOUTH_ATLANTIC = 4;
	private final static int EAST_SOUTH_CENTRAL = 5;
	private final static int WEST_SOUTH_CENTRAL = 6;
	private final static int MOUNTAIN = 7;
	private final static int PACIFIC = 8;
	
	/*
	 * The collections contain no duplicate elements, hence why using a Set makes sense instead of an array. 
	 * 
	 * It is O(N) to create the collection in the first place which may seem slow, but it will be utilized for
	 * every item read in the data. The time consumed to initialize it is outweighed by the fact I wont have 
	 * to perform linear searches for every record in the data. Creating it like this offers O(1) time performance 
	 * for basic operations including searching the set using contains() function.
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
	

	private ArrayList<Item> itemList;
	private Item newItem;
	private Correlation corrCoeff;
	
	public DataList()
	{
		itemList = new ArrayList<Item>();
		newItem = new Item();
	}

	public void setItem(String stateVar, String sizeVar)
	{
		newItem.setState(stateVar);
		this.setRegionAndDivision(stateVar);
		this.updateSizeFreq(sizeVar);
		itemList.add(newItem);
	}
	
	//Set size variable 
	public void updateSizeFreq(String sizeVar)
	{
		newItem.setSize(SIZE_MAP.indexOf(sizeVar));
	}
	
	/*
	 * Set the region and division based on the state passed as param
	 */
	public void setRegionAndDivision(String state)
	{
		if(DIVISION_ONE.contains(state))
		{
			newItem.setRegion(NORTHEAST);
			newItem.setDivision(NEW_ENGLAND);
		}
		else if(DIVISION_TWO.contains(state))
		{
			newItem.setRegion(NORTHEAST);
			newItem.setDivision(MID_ATLANTIC);
		}
		else if(DIVISION_THREE.contains(state))
		{
			newItem.setRegion(MIDWEST);
			newItem.setDivision(EAST_NORTH_CENTRAL);
		}
		else if(DIVISION_FOUR.contains(state))
		{
			newItem.setRegion(MIDWEST);
			newItem.setDivision(WEST_NORTH_CENTRAL);
		}
		else if(DIVISION_FIVE.contains(state))
		{
			newItem.setRegion(SOUTH);
			newItem.setDivision(SOUTH_ATLANTIC);
		}
		else if(DIVISION_SIX.contains(state))
		{
			newItem.setRegion(SOUTH);
			newItem.setDivision(EAST_SOUTH_CENTRAL);
		}
		else if(DIVISION_SEVEN.contains(state))
		{
			newItem.setRegion(SOUTH);
			newItem.setDivision(WEST_SOUTH_CENTRAL);
		}
		else if(DIVISION_EIGHT.contains(state))
		{
			newItem.setRegion(WEST);
			newItem.setDivision(MOUNTAIN);
		}
		else if(DIVISION_NINE.contains(state))
		{
			newItem.setRegion(WEST);
			newItem.setDivision(PACIFIC);
		}
	}
	
	public void print()
	{
		System.out.println(newItem.getRegion() + "  " + newItem.getDivision() + "  " + newItem.getSize() + "  " + newItem.getState() + "\n");
	}
	
	public void calcCorrelation()
	{
		
	}
}
