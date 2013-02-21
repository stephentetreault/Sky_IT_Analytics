import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String; 

public class FileIO 
{
	private BufferedReader br;
	private String line;
	//private Item newItem;
	//private ItemSet dataSet;
	private DataList collection;
	
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
		//newItem = new Item();
		//dataSet = new ItemSet();  //THIS MAY CHANGE IF I USE HASHMAP
		collection = new DataList();
	}
	
	/*
	 * FileIO right now is done with BufferedReader but I need to consider dealing with massive files, 
	 * perhaps memory-mapping them and breaking them into chunks to deal with. 
	 * 
	 * Approach discussed here: http://www.linuxtopia.org/online_books/programming_books/thinking_in_java/TIJ314_029.htm
	 */
	public void read() 
	{
		int count = 0;
		try
		{
			line = br.readLine(); //eat up the header line
			
			/*
			 * I'm working under assumptions that each item will have the correct expected
			 * input for location (mainly that state is set and size is set). 
			 * 
			 * We ignore any online/e-commerce sales since location isn't set for those items. 
			 */
			while((line = br.readLine()) != null)
			{
				count++;
				String[] temp = line.split(","); 
				
				//collection.updateRegionAndDivisionFreq(temp[3]);
				//collection.updateSizeFreq(temp[8]);
				
				
				
				//newItem.setTpid(temp[0]);
				//newItem.setStoreNum(temp[1]);
				//newItem.setCity(temp[2]);
				//newItem.setState(temp[3]);
				//newItem.setRegion(temp[3]);
				//newItem.setZip(temp[4]);
				//newItem.setCountry(temp[5]);
				//newItem.setStyle(temp[6]);
				//newItem.setNrf(temp[7]);
				//newItem.setSize(temp[8]);
				//dataSet.addItem(newItem);
				//newItem = new Item();
			}
			System.out.println(count);			
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