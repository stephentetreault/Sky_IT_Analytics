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
	//private Correlation corrCoeff;
	
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
			
			while((line = br.readLine()) != null)
			{
				count++;
				String[] temp = line.split(","); 
				collection.setItem(temp[3], temp[8]);
				collection.print();
			}
			//System.out.println(collection.calcCorrelation());	
			//corrCoeff = new Correlation(collection);
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