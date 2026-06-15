package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;

import handlers.KeyHandler;
import main.Definitions;

public class Frame extends JFrame
{
	int WIDTH, HEIGHT;
	
	public Frame(Definitions defs)
	{
		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		WIDTH  = screenSize.width;
		HEIGHT = screenSize.height;
			defs.setWIDTH(WIDTH);
			defs.setHEIGHT(HEIGHT);
		
		setUndecorated(true);
		setExtendedState(MAXIMIZED_BOTH);
		
		KeyHandler keyHandler = new KeyHandler();
		addKeyListener(keyHandler);
		
		
		setVisible(true);
	}
}