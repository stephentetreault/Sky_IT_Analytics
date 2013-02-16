
public class HashEntry
{
	private int key; 
	private int value;  //value needs to be object type Item
	
	public HashEntry(int k, int v)
	{
		key = k;
		value = v;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setValue(int v)
	{
		value = v;
	}
	
	public int getKey()
	{
		return key;
	}
}

//public class HashEntry 
//{
//	private int key;
//	private int value;
//	
//	public HashEntry(int k, int v)
//	{
//		this.key = k;
//		this.value = v;
//	}
//	
//	public int getKey()
//	{
//		return key;
//	}
//	
//	public int getValue()
//	{
//		return value;
//	}
//}
