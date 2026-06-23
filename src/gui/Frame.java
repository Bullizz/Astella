package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import gui.start_menu.StartMenuPanel;
import main.Definitions;

public class Frame extends JFrame
{
	int WIDTH, HEIGHT;
	
	public Frame(Definitions defs, boolean contAvailable)
	{
		super();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		WIDTH  = screenSize.width;
		HEIGHT = screenSize.height;
			defs.setWIDTH(WIDTH);
			defs.setHEIGHT(HEIGHT);
		
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setExtendedState(MAXIMIZED_BOTH);
		
		addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent press)
			{
				int userInp = press.getKeyCode();
				if(userInp == KeyEvent.VK_ESCAPE)
					System.exit(0);
			}
		});
		
		// Launch menu
		StartMenuPanel startMenuPanel = new StartMenuPanel(defs, WIDTH, HEIGHT, this, contAvailable);
		add(startMenuPanel);
		setVisible(true);
	}
}