package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import main.Definitions;

public class Frame extends JFrame
{
	int WIDTH, HEIGHT;
	
	public Frame(Definitions defs)
	{
		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		WIDTH = screenSize.width;
		HEIGHT = screenSize.height;
			defs.setWIDTH(WIDTH);
			defs.setHEIGHT(HEIGHT);
		
		setVisible(true);
	}
}