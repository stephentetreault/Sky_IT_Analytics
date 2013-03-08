import java.util.ArrayList;


/*
 * Class that calculates Pearson's Correlation Coefficient
 * 
 * Formula: http://www.bized.co.uk/sites/bized/files/images/timeweb/correlcoef.gif
 */
public class Correlation
{
	private FileIO fio;
	private ArrayList<Item> collection;
	private double sumSize;              //sum(x)
	private double sumSizeSqrd;          //x^2
	private double sumRegion;            //sum(y1)
	private double sumRegionSqrd;        //y1^2
	private double sumDivision;          //sum(y2)
	private double sumDivisionSqrd;      //y2^2
	private double meanSize;             //x-bar
	private double meanRegion;           //y1-bar
	private double meanDivision;         //y2-bar
	private double sizeRegionProduct;    //x*y  
	private double sizeDivisionProduct;  //x*y
	private double corrCoef;            // our r value (the correlation coefficient)
	private int n;

	public Correlation(String path)
	{
		fio = new FileIO(path);
		collection = new ArrayList<Item>();
		sumSize = 0;
		sumSizeSqrd = 0;
		sumRegion = 0;
		sumRegionSqrd = 0;
		sumDivision = 0;
		sumDivisionSqrd = 0;
		meanSize = 0;
		meanRegion = 0;
		meanDivision = 0;
		sizeRegionProduct = 0;
		sizeDivisionProduct = 0;
		corrCoef = 0;
		n = 0;
	}
	
	public void init()
	{
		fio.read();
		collection = fio.getCollection();
		
		n = collection.size();
		
		for (int b = 0; b < n; b++)
		{
			sumSize += collection.get(b).getSize();
			sumDivision += collection.get(b).getDivision();
			sumRegion += collection.get(b).getRegion();
			sumSizeSqrd += (collection.get(b).getSize() * collection.get(b).getSize());
			sumRegionSqrd += (collection.get(b).getRegion() * collection.get(b).getRegion());
			sumDivisionSqrd += (collection.get(b).getDivision() * collection.get(b).getDivision());
			sizeRegionProduct += (collection.get(b).getSize() * collection.get(b).getRegion());
			sizeDivisionProduct += (collection.get(b).getSize() * collection.get(b).getDivision());
		}
		
		meanSize = sumSize/n;
		meanRegion = sumRegion/n;
		meanDivision = sumDivision/n;
		
		double numerator = (n * sizeRegionProduct - ((sumSize * sumRegion)/n));
		double denomP1 = (n * sumSizeSqrd - ((sumSize * sumSize)/n));
		double denomP2 = (n * sumRegionSqrd - ((sumRegion * sumRegion)/n));
		double denominator = Math.sqrt(denomP1 * denomP2);
		
		System.out.println("n = " + n + "\n" +
						   "Sum(X) = " + sumSize + "\n" +
						   "Sum(Y) = " + sumRegion + "\n" +
						   "Sum(XY) = " + sizeRegionProduct + "\n" + 
						   "Sum(X^2) = " + sumSizeSqrd + "\n" +
						   "Sum(X)^2 = " + (sumSize * sumSize) + "\n" + 
						   "Sum(Y^2) = " + sumRegionSqrd + "\n" +
						   "Sum(Y)^2 = " + (sumRegion * sumRegion) + "\n");
		
		corrCoef = numerator/denominator;
		
		System.out.println("Correlation Coefficient: " + corrCoef + "\n");
		
		for(int c = 0; c < collection.size(); c++)
		{
			System.out.println(collection.get(c).getSize() + "," + collection.get(c).getRegion());
		}
	}
	
//	public double calculate()
//	{
//		
//	}
}
