package handlers;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import main.Definitions;
import player.Inventory;

public class DirectoryHandler
{
	Definitions defs;
	
	public DirectoryHandler(Definitions defs)
	{
		this.defs = defs;
	}
	
	public boolean checkGPNFsExistence()
	{		
		Path directory = Paths.get(defs.directory, defs.foldername_GPNFs);
		
		try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(directory))
		{
			for(Path GPNFsContent: dirStream)
				return true;
			return false;
		} catch(IOException ioe)
		{
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
	public void restoreFolder()
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
		for(String filename: defs.filenameArray)
			createFile(filename);
	}
	
	public void writeToChestFile(){}
	public void writeToPlayerFile(){}
	public void writeToMonsterFile(){}
	public void writeToMazeFile(){}
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