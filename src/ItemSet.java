import java.util.ArrayList;

/*
 * Data struct class to hold Item objects 

 * ARRAYLIST IS NOT SYNCHRONIZED. IF MULTITHREADED I NEED TO SYNCHRONIZE THIS EXTERNALLY.
 * 
 * Most operations run near constant time but performance will be 
 * slowed towards end of array when it needs to be resized.
 */
public class ItemSet 
{
	private ArrayList<Item> itemList;
	
	//Constructor
	public ItemSet()
	{
		itemList = new ArrayList<Item>();
	}
	
	/*
	 * Methods are based on Oracle ArrayList methods
	 * 
	 * http://docs.oracle.com/javase/6/docs/api/java/util/ArrayList.html
	 */
	public void addItem(Item item)  { itemList.add(item); }
	public Item getItem(int index)  { return itemList.get(index); }
	
	public void clear()             { itemList.clear(); }
	
	public int size()               { return itemList.size(); }
	
	public void trimToSize()        { itemList.trimToSize(); }
	
	/*
	 *  Increases the capacity of this ArrayList instance, if needed, to ensure that it can hold at
	 *  least the number of elements specified by the minimum capacity argument.
	 */
	public void ensureCapactity(int minCapacity)
	{
		itemList.ensureCapacity(minCapacity);
	}
}
