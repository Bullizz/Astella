package handlers;

import java.util.LinkedList;

import main.Definitions;

public class Chest
{
	int x;
	int y;
	int wallSrc;
	String potion;
	String notebook;
	
	public Chest(int x, int y, int wallSrc, String potion, String notebook)
	{
//		System.out.println("bruh1");
		if(wallSrc == 0)
			return;
		
		this.x = x;
		this.y = y;
		this.wallSrc = wallSrc;
		this.potion = potion;
		this.notebook = notebook;
	}
	
	public Chest[] getChestArray(Definitions defs)
	{
		int chestLim = 16;
		int[][] maze = defs.maze;
		Chest[] chestArray = new Chest[chestLim];

		LinkedList<Integer> chestPos = new LinkedList<>();
		
		int dim = defs.DIM;
		int[][] quadrants = {{dim / 2, dim / 2},
							 {dim, dim / 2},
							 {dim / 2, dim},
							 {dim, dim}};
		
		String[] potions   = defs.potions;
		String[] notebooks = defs.notebooks;
		
		int index = 0;
		while(index < chestLim)
		{
			// Pos. of chest
			int quadrantIndex = index / 4;
			int x2 = quadrants[quadrantIndex][0];
			int x1 = x2 - (dim / 2);
			int y2 = quadrants[quadrantIndex][1];
			int y1 = y2 - (dim / 2);
			
			int x = (int) ((Math.random() * (x2 - x1)) + x1);
			int y = (int) ((Math.random() * (y2 - y1)) + y1);
			
			if(posOccupied(chestPos, dim, x, y))
				continue;
			chestPos.add((x * dim) + y);
			
			// Host wall of chest
			int wallSrc = 0;
			int mazeValue = maze[y][x];
			boolean[] wallArray = {(mazeValue & Definitions.WALL_RIGHT) != 0,
								   (mazeValue & Definitions.WALL_DOWN)  != 0,
								   (mazeValue & Definitions.WALL_LEFT)  != 0,
								   (mazeValue & Definitions.WALL_UP) 	!= 0};
			boolean wallSrcFound = false;
			while(!wallSrcFound)
			{
				int wallIndex = (int) (Math.random() * wallArray.length);
				wallSrcFound = wallArray[wallIndex];
				wallSrc = (int) Math.pow(2, wallIndex);
			}
			
			// Potion in chest
			String potion = null;
			while(potion == null)
			{
				int potionIndex = (int) (Math.random() * potions.length);
				potion = potions[potionIndex];
				potions[potionIndex] = null;
			}
						
			// Notebook in chest
			String notebook = null;
			while(notebook == null)
			{
				int notebookIndex = (int) (Math.random() * notebooks.length);
				notebook = notebooks[notebookIndex];
				notebooks[notebookIndex] = null;
			}
			
			chestArray[index] = new Chest(x, y, wallSrc, potion, notebook);
			index++;
		}
		
		return chestArray;
	}
	
	private boolean posOccupied(LinkedList<Integer> chestPos, int dim, int x, int y)
	{
		int pos = (x * dim) + y;
		if(chestPos.contains(pos))
			return true;
		return false;
	}
}