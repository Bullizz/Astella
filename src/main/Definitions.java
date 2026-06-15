package main;

public class Definitions
{
	int[][] maze;
	
	int WIDTH;
	int HEIGHT;
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
	
	public int WALL_UP    = 8;
	public int WALL_LEFT  = 4;
	public int WALL_DOWN  = 2;
	public int WALL_RIGHT = 1;
	
	public void setDirPath(String directory)
	{
		this.directory = directory;
	}
	
	public void setMaze(int[][] maze)
	{
		this.maze = maze;
	}
	
	public void setWIDTH(int wIDTH)
	{
		WIDTH = wIDTH;
	}
	
	public void setHEIGHT(int hEIGHT)
	{
		HEIGHT = hEIGHT;
	}
}