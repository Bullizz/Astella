package handlers;

import main.Definitions;

public class Chest
{
	Definitions defs;
	
	int x;
	int y;
	int wallSrc;
	int potionIndex;
	int notebookIndex;
	int[][] quadrants;
	
	public Chest(int x, int y, int wallSrc, int potionIndex, int notebookIndex)
	{
		System.out.println("bruh1");
		if(wallSrc == 0)
			return;
		
		
	}

	int chestLim = 16;
	String[] potions = {"potion-0",
						"potion-1",
						"potion-2",
						"potion-3",
						"potion-4",
						"potion-5",
						"potion-6",
						"potion-7",
						"potion-8",
						"potion-9",
						"potion-0",
						"potion-1",
						"potion-2",
						"potion-3",
						"potion-4",
						"potion-5",
						"potion-6",
						"potion-7",
						"potion-8",
						"potion-9"};
	String[] notebooks = {"notebook-0",
						  "notebook-1",
						  "notebook-2",
						  "notebook-3",
						  "notebook-4",
						  "notebook-5",
						  "notebook-6",
						  "notebook-7",
						  "notebook-8",
						  "notebook-9",
						  "notebook-0",
						  "notebook-1",
						  "notebook-2",
						  "notebook-3",
						  "notebook-4",
						  "notebook-5",
						  "notebook-6",
						  "notebook-7",
						  "notebook-8",
						  "notebook-9"};
	
	public Chest[] getChestArray(Definitions defs)
	{
		int[][] maze = defs.maze;
		Chest[] chestArray = new Chest[chestLim];
		for(int index = 0; index < chestLim; index++)
		{
			
		}
		
		return null;
	}
}