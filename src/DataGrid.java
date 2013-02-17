
/*
 * Class for a data grid which will contain the counts for occurrences of sizes
 * in regions and divisions. 
 */
public class DataGrid 
{
	private int[][][] grid;
	
	public DataGrid()
	{
		/*
		 * The basis for this initialization:
		 * 
		 * grid = new int [# of distinct sizes in DB][# of regions][# of divisions]
		 */
		grid = new int [47][3][8];
	}
	
	
}
