package player;

import main.Definitions;

public class Inventory
{
	Definitions defs;
	
	String[] notebooks,
			 chests;
	
	public Inventory(Definitions defs)
	{
		this.defs = defs;
		
		notebooks = null;
		chests 	  = null;
	}
	
	public void initInventory()
	{
		
	}
	
	public void loadInventory(){}
}