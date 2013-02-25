import java.util.ArrayList;


/*
 * Class that calculates Pearson's Correlation Coefficient
 * 
 * Formula: http://www.bized.co.uk/sites/bized/files/images/timeweb/correlcoef.gif
 */
public class Correlation
{
	/*
	 * For now I'm calculating values for both region and division, only one will be used at a time though
	 */
	private double sumSize;        //sum(x)
	private double sumSizeSqrd;    //x^2
	private double sumRegion;      //sum(y1)
	private double sumRegionSqrd;  //y1^2
//	private double sumDivision;    //sum(y2)
//	private double sumDivisionSqrd;  //y2^2
	private double meanSize;      //x-bar
	private double meanRegion;    //y1-bar
//	private double meanDivision;  //y2-bar
	private double sizeLocationProduct;  //x*y  
	private double corrCoeff;  // our r value (the correlation coefficient)
	private int n;
	
	/*
	 * Constructor
	 * 
	 * Calculate values for variables. 
	 */
	public Correlation(ArrayList<Item> list)
	{
		corrCoeff = 0.00; 
		n = list.size();
		
		for (int a = 0; a < n; a++)
		{
			sumSize += list.get(a).getSize();
			sumSizeSqrd += (list.get(a).getSize() * list.get(a).getSize());   //x^2 done like this is faster than Math.pow()
			
			sumRegion += list.get(a).getRegion();
			sumRegionSqrd += (list.get(a).getRegion() * list.get(a).getRegion());
			
//			sumDivision += list.get(a).getDivision();
//			sumDivisionSqrd += (list.get(a).getDivision() * list.get(a).getDivision());
		
			sizeLocationProduct += (list.get(a).getSize() *  list.get(a).getRegion());
//			sizeLocationProduct += (list.get(a).getSize() *  list.get(a).getDivision());
		}
		
		meanSize = sumSize/list.size();
		meanRegion = sumRegion/list.size();
//		meanDivision = sumDivision/list.size();
	}
	
	public double calculateCoefficient()
	{
		double numerator = (n * sizeLocationProduct - (sumSize*sumRegion));
		double denomPart1 = (n*sumSizeSqrd - (sumSize*sumSize));
		double denomPart2 = (n*sumRegionSqrd - (sumRegion*sumRegion));
		double denom = Math.sqrt(denomPart1*denomPart2);
		return (numerator/denom); 
	}
}
