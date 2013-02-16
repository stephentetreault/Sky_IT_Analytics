import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String; 


public class FileIO 
{
	private BufferedReader br;
	private String line;
	private Item newItem;
	private ItemSet dataSet;
	
	// Class constructor
	public FileIO(String path) 
	{
		try 
		{ 
			br = new BufferedReader(new FileReader(path)); 
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("FILE NOT FOUND \n");
			e.printStackTrace();
		}
		
		line = "";
		newItem = new Item();
		dataSet = new ItemSet();  //THIS MAY CHANGE IF I USE HASHMAP
	}
	
	/*
	 * FileIO right now is being done with a BufferedReader but I 
	 * need to consider dealing with massive files, perhaps memory-mapping
	 * them and breaking them into chunks to deal with. 
	 * 
	 * Approach discussed here: http://www.linuxtopia.org/online_books/programming_books/thinking_in_java/TIJ314_029.htm
	 */
	public void read() 
	{
		try
		{
			line = br.readLine(); //eat up the header line
			int count = 0;
			
			while((line = br.readLine()) != null)
			{
				count++;
				/*
				 * We can disregard E-Commerce records because we do not know where
				 * they are shipping these items.
				 */
				if(!(line.indexOf("E-Commerce") > -1))
				{
					String[] temp = line.split(","); 

					newItem.setTpid(temp[0]);
					/*
					 * Overridden Location constructor: 
					 * 
					 * 	public Location(String adrs1, String adrs2, int sNum, String sName, String cityParam, String stateParam, int zipCode, String countryParam)
					 */
					newItem.setLocation(temp[3], temp[4], temp[1], temp[2], temp[5], temp[6], temp[7], temp[8]);
					newItem.setStyle(temp[9]);
					newItem.setNrf(temp[10]);
					newItem.setSize(temp[11]);
					
					
					System.out.println(newItem.getTpid() + " " + newItem.getSize() + " " + newItem.getStyle() + " " + newItem.getNrf() + " " + 
							newItem.getLocationStoreNum() + " " + newItem.getLocationStoreName() + " " + newItem.getLocationCity() + " " + newItem.getLocationState() + " " + 
							newItem.getLocationZip() + " " + newItem.getLocationCountry() + " " + newItem.getLocationAddress() + " " + "\n");
					System.out.println(count + "\n");
					//add item to data set and create new item
					dataSet.addItem(newItem);
					newItem = new Item();
					
					
				}
								
//				System.out.println(newItem.getTpid() + " " + newItem.getSize() + " " + newItem.getStyle() + " " + newItem.getNrf() + " " + 
//						newItem.getLocationStoreNum() + " " + newItem.getLocationStoreName() + " " + newItem.getLocationCity() + " " + newItem.getLocationState() + " " + 
//						newItem.getLocationZip() + " " + newItem.getLocationCountry() + " " + newItem.getLocationAddress() + " " + "\n");
			}
			
			
//			for(int a = 0; a < dataSet.size(); a++)
//			{
//				Item testItem = dataSet.getItem(a);
//				
//				System.out.println(testItem.getTpid() + " " + testItem.getSize() + " " + testItem.getStyle() + " " + testItem.getNrf() + " " + 
//						testItem.getLocationStoreNum() + " " + testItem.getLocationStoreName() + " " + testItem.getLocationCity() + " " + testItem.getLocationState() + " " + 
//						testItem.getLocationZip() + " " + testItem.getLocationCountry() + " " + testItem.getLocationAddress() + " " + "\n");
//			}
//			System.out.println(dataSet.size());
		}
		catch (IOException e)
		{
			System.out.println("EXCEPTION THROWN WHILE READING FILE \n");
			e.printStackTrace();
		}
	}
	
	// Close the reader stream and file 
	public void close() 
	{
		try 
		{ 
			br.close(); 
		} 
		catch (IOException e) 
		{
			System.out.println("FAILED TO CLOSE FILE \n");
			e.printStackTrace();
		}
	}
}
