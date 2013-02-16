
/*
 * Main Class
 */
public class SkyITAnalytics 
{
	public static void main(String[] args) 
	{
		init();
	}
	
	private static void init()
	{
		String fp = "C:\\Users\\STetreault\\Desktop\\sampleDataSet.csv";
		FileIO fio = new FileIO(fp);
		fio.read();
		fio.close();
	}
}
