

/*
 * I SHOULD USE HASHMAP THAT USES CHAINING, RATHER THAN OPEN ADDRESSING
 */

/*
 * DeletedEntry is a subclass of HashEntry
 * 
 * This prevents gaps in the HashMap so the struct doesn't get broken. 
 * 		- Open addressing approach to collision resolution
 * 
 * When adjusting this for Item objects, value of empty (not null) item will need to be passed to super
 */
public class DeletedEntry extends HashEntry 
{
	private static DeletedEntry entry = null;
	
	private DeletedEntry()
	{
		super(-1,-1); //call to the super class
	}
	
	//think about why this is "public static"
	public static DeletedEntry getUniqueDeletedEntry()
	{
		if(entry == null)
		{
			entry = new DeletedEntry();
		}
		
		return entry;
	}
}
