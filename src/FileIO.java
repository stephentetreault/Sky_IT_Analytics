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
			
			/*
			 * I'm working under some current assumptions, mainly that each item
			 * will have the correct expected input for location (mainly that state is set). 
			 * 
			 * We ignore any online/e-commerce sales since location isn't set for those items. 
			 */
			while((line = br.readLine()) != null)
			{
				//temp[] contains (in order) TPID, Store Num, City, State, Zip, Country, Style, NRF, Size
				String[] temp = line.split(","); 
				
				newItem.setTpid(temp[0]);
				newItem.setStoreNum(temp[1]);
				newItem.setCity(temp[2]);
				newItem.setState(temp[3]);
				newItem.setRegion(temp[3]);
				newItem.setZip(temp[4]);
				newItem.setCountry(temp[5]);
				newItem.setStyle(temp[6]);
				newItem.setNrf(temp[7]);
				newItem.setSize(temp[8]);
				dataSet.addItem(newItem);
				
//				System.out.println(newItem.getTpid() + " " + newItem.getStoreNum() + " " + newItem.getCity() + " " + newItem.getState() + " " +
//						newItem.getItemRegion() + " " + newItem.getItemDivision() + " " + newItem.getZip() + " " + newItem.getCountry() + " " +
//						newItem.getStyle() + " " + newItem.getNrf() + " " + newItem.getSize() + " " + "\n");
				
				newItem = new Item();

			}
			
			for(int a = 0; a < dataSet.size(); a++)
			{
				Item testItem = dataSet.getItem(a);
				
				System.out.println(testItem.getTpid() + " " + testItem.getStoreNum() + " " + testItem.getCity() + " " + testItem.getState() + " " +
						testItem.getItemRegion() + " " + testItem.getItemDivision() + " " + testItem.getZip() + " " + testItem.getCountry() + " " +
						testItem.getStyle() + " " + testItem.getNrf() + " " + testItem.getSize() + " " + "\n");
			}
			System.out.println(dataSet.size());
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