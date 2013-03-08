import java.util.ArrayList;

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
		String fp = "C:\\Users\\STetreault\\Desktop\\dataTest.csv";
		Correlation correlation = new Correlation(fp);
		correlation.init();
	}
}
