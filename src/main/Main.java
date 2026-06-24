package main;

import gui.Frame;
import handlers.DirectoryHandler;

public class Main
{	
	public static void main(String[] args)
	{
		// Get players directory which contains game
		Definitions defs = new Definitions();
		String directory = System.getProperty("user.dir");
		defs.setDirPath(directory);
		
		// Check if GPNFs exists
		DirectoryHandler directoryHandler = new DirectoryHandler(defs);
		boolean GPNFsExists = directoryHandler.checkGPNFsExistence();
		for(int i = 0; i < 16; i++)
			System.out.println(i / 4);
		boolean contAvailable = GPNFsExists;
		
		// Create folder and fill with empty files if non-existent
		/*
		if(!GPNFsExists)
		{
			directoryHandler.createFolder();
			for(String filename: defs.filenameArray)
				directoryHandler.createFile(filename);

			new MazeHandler(defs).genMaze();
			contAvailable = false;
		}
		*/
		
		Frame frame = new Frame(defs, contAvailable);
	}
}