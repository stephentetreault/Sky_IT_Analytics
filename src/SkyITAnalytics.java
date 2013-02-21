
/*
 * Sky IT Group Analytics platform
 * 
 * Author: 	Stephen Tetreault
 * Created: 02.16.2013
 * For:     Sky IT Group
 * 
 * No code may be copied without consent of the author. 
 */

public class SkyITAnalytics 
{
	public static void main(String[] args) 
	{
		init();
	}
	
	private static void init()
	{
		String fp = "C:\\Users\\STetreault\\Desktop\\sampleDataSet.csv";  //big data set
		//String fp = "C:\\Users\\STetreault\\Desktop\\dataTest.csv"; 
		FileIO fio = new FileIO(fp);
		fio.read();
		fio.close();
		System.gc();  //invoke garbage collector so JVM can try to recycle unused objects to free some memory
	}
}
