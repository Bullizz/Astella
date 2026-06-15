package main;

import gui.Frame;
import handlers.DirectoryHandler;
import handlers.MazeHandler;
import player.Inventory;

public class Main
{
	static int WIDTH, HEIGHT;
	
	public static void main(String[] args)
	{
		// Get players directory containing game
		Definitions defs = new Definitions();
		String directory = System.getProperty("user.dir");
		defs.setDirPath(directory);
		
		// Check if GPNFs exists
		DirectoryHandler directoryHandler = new DirectoryHandler(defs);
		boolean GPNFsExists = directoryHandler.checkGPNFsExistence();

		Inventory inventory;
		
		// Create folder and fill with empty files if non-existent 
		if(!GPNFsExists)
		{
			directoryHandler.createFolder();
			for(String filename: defs.filenameArray)
				directoryHandler.createFile(filename);

			// Gen maze
			new MazeHandler(defs).genMaze();
			inventory = new Inventory(defs);
		}
		
		// Load maze
		int[][] maze = defs.maze;
//		if(maze == null)
//			return;
		
		inventory = directoryHandler.loadInventory();
		
		// Gen frame
		Frame frame = new Frame(defs);
	}
}