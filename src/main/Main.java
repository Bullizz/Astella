package main;

import gui.Frame;
import handlers.DirectoryHandler;

public class Main
{
	static int WIDTH, HEIGHT;
	
	public static void main(String[] args)
	{
		Definitions defs = new Definitions();
		String directory = System.getProperty("user.dir");
		defs.setDirPath(directory);
		
		DirectoryHandler directoryHandler = new DirectoryHandler(defs);
		boolean GPNFsExists = directoryHandler.checkGPNFsExistence();
		
		// Create folder and fill with empty files 
		if(!GPNFsExists)
		{
			directoryHandler.createFolder();
			for(String filename: defs.filenameArray)
				directoryHandler.createFile(filename);
		}
		
		Frame frame = new Frame(defs);
	}	
}