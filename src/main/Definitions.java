package main;

import handlers.ChestHandler;
import player.Inventory;

public class Definitions
{
	public int[][] maze;
	public ChestHandler[] chests;
	public Inventory[] inventory;
	
	public int WIDTH;
	public int HEIGHT;
	public int DIM = 25;
	
	public String directory;
	public final String foldername_GPNFs   = "\\GPNFs\\";
	public final String filename_chest	   = "chest.txt";
	public final String filename_player	   = "player.txt";
	public final String filename_monster   = "monster.txt";
	public final String filename_maze	   = "maze.txt";
	public final String filename_inventory = "inventory.txt";
	public final String filename_validity  = "validity.txt";
//	public final String backslash 		   = "\\";
	
	public String[] filenameArray = {filename_chest,
									 filename_player,
									 filename_monster,
									 filename_maze,
									 filename_inventory};
	
	public static int WALL_UP    = 8;
	public static int WALL_LEFT  = 4;
	public static int WALL_DOWN  = 2;
	public static int WALL_RIGHT = 1;
	
	public String[] potions = {"potion-0",
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
	public String[] notebooks = {"notebook-0",
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
	
	public void setChests(ChestHandler[] chests)
	{
		this.chests = chests;
	}
	
	public void setDirPath(String directory)
	{
		this.directory = directory;
	}
	
	public void setMaze(int[][] maze)
	{
		this.maze = maze;
	}
	
	public void setWIDTH(int WIDTH)
	{
		this.WIDTH = WIDTH;
	}
	
	public void setHEIGHT(int HEIGHT)
	{
		this.HEIGHT = HEIGHT;
	}
}