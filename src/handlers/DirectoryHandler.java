package handlers;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import main.Definitions;
import player.Inventory;

public class DirectoryHandler
{
	Definitions defs;
	
	public DirectoryHandler(Definitions defs)
	{
		this.defs = defs;
	}
	
	public boolean checkFileExistence(String filename)
	{
		
		return false;
	}
	
	public boolean checkGPNFsExistence()
	{		
		Path directory = Paths.get(defs.directory, defs.foldername_GPNFs);
		int foundFiles = 0;
		try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(directory))
		{
			for(Path GPNFsContent: dirStream)
				foundFiles++;
			
			if(foundFiles == defs.filenameArray.length)
				return true;
			return false;
		} catch(IOException ioe)
		{
//			ioe.printStackTrace();
			return false;
		}
	}
	
	public void createFolder()
	{
		String directory = defs.directory + defs.foldername_GPNFs;
		
		try
		{
			File newFolder = new File(directory);
			newFolder.mkdir();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void createFile(String filename)
	{
		filename = defs.directory + defs.foldername_GPNFs + filename;
		try
		{
			File newFile = new File(filename);
			newFile.createNewFile();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Restore GPNFs
	public void restoreGPNFs()
	{
		String directory = defs.directory + defs.foldername_GPNFs;
		try
		{
			File folder = new File(directory);
			File[] GPNFsContent = folder.listFiles();
			for(File file: GPNFsContent)
				file.delete();
			folder.delete();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		createFolder();
	}
	
	public void writeToChestFile(ChestHandler[] chestArray){}
	public void writeToPlayerFile(){}
	public void writeToMonsterFile(){}
	public void writeToMazeFile(int[][] maze){}
	public void writeToInventoryFile(){}
	
	public void readFromChestFile(){}
	public void readFromPlayerFile(){}
	public void readFromMonsterFile(){}
	public void readFromMazeFile(){}
	public void readFromInventoryFile(){}

	public Inventory loadInventory()
	{
		
		
		return null;
	}
}