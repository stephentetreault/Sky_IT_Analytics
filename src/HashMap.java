



//
///*
// * HashMap class right now is static sized. NEEDS TO BE DYNAMIC LATER.
// */
//public class HashMap 
//{
//	private final static int TABLE_SIZE = 128;
//	
//	HashEntry[] table;
//	
//	public HashMap()
//	{
//		table = new HashEntry[TABLE_SIZE];
//		
//		for(int i = 0; i < TABLE_SIZE; i++)
//		{
//			table[i] = null;
//		}
//	}
//	
//	
//	public int getValue(int key)
//	{
//		int hash = (key % TABLE_SIZE);
//		
//		while (table[hash] != null && table[hash].getKey() != key)
//		{
//			hash = (hash + 1) % TABLE_SIZE;
//			
//			if(table[hash] == null)
//			{
//				return -1;
//			}
//			else
//			{
//				return table[hash].getValue();
//			}
//		}
//		
//		/*
//		 * This default return indicates erroneous behavior in code. 
//		 * Return value should be one of the two above. 
//		 */
//		return 99999; 
//	}
//	
//	public void put(int key, int val)
//	{
//		int hash = (key % TABLE_SIZE);
//		
//		while(table[hash] != null && table[hash].getKey() != key)
//		{
//			hash = (hash + 1) % TABLE_SIZE;
//			table[hash] = new HashEntry(key,val);
//		}
//	}
//	
//	public void clear()
//	{
//		for(int i = 0; i < TABLE_SIZE; i++)
//		{
//			table[i] = null;
//		}
//	}
//}
