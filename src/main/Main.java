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
		boolean contAvailable = GPNFsExists;
		
		/*Frame frame = */new Frame(defs, contAvailable);
	}
}