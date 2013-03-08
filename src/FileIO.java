import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String; 
import java.util.ArrayList;

public class FileIO 
{
	private BufferedReader br;
	private String line;
	private Item newItem;
	private ArrayList<Item> collection;
	
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
		collection  = new ArrayList<Item>();
		//newItem = new Item();
	}
	
	/*
	 * FileIO right now is done with BufferedReader but I need to consider dealing with massive files, 
	 * perhaps memory-mapping them and breaking them into chunks to deal with. 
	 * 
	 * Approach discussed here: http://www.linuxtopia.org/online_books/programming_books/thinking_in_java/TIJ314_029.htm
	 */
	public void read() 
	{
		//int count = 0;
		
		try
		{
			line = br.readLine(); //eat up the header line

			while((line = br.readLine()) != null)
			{
				newItem = new Item();
				//count++;
				String[] temp = line.split(","); 
				newItem.setTPID(temp[0]);
				newItem.setCountry(temp[1]);
				newItem.setState(temp[2]);
				newItem.setRegionAndDivision(temp[2]);
				newItem.setCity(temp[3]);
				newItem.setSize(temp[4]);
				newItem.setNRF(temp[5]);
				newItem.setUnitsSold(temp[6]);
				newItem.setSalesDollars(temp[7]);
				
				
//				System.out.println(temp[0] + "  " + temp[1] + "  " + temp[2] + "  " + temp[3] + "  " + 
//									 temp[4] + "  " + temp[5] + "  " + temp[6] + "  " + temp[7] + "  " + "\n");
				collection.add(newItem);
			}
		}
		catch (IOException e)
		{
			System.out.println("EXCEPTION THROWN WHILE READING FILE \n");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Item> getCollection()
	{
		return collection;
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