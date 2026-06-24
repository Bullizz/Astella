package gui.start_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.Frame;
import handlers.Chest;
import handlers.DirectoryHandler;
import handlers.MazeHandler;
import main.Definitions;

public class StartMenuPanel extends JPanel
{
	Definitions defs;
	Frame parent;
	
	BufferedImage backgroundImg;
	String backgroundImgPath = "/res/images/start_menu/start-menu-background.png";
	
	final static GridLayout grid1 = new GridLayout(1, 3);
	final static GridLayout grid2 = new GridLayout(5, 1);
	final static Color transparent = new Color(255, 255, 255, 1);
	
	int WIDTH, HEIGHT;
	boolean contAvailable;
	
	ContBtn contBtn;
	NewGameBtn newGameBtn;
	ExitBtn exitBtn;
	
	public StartMenuPanel(Definitions defs, int WIDTH, int HEIGHT, Frame parent, boolean contAvailable)
	{
		super();
			this.WIDTH  = WIDTH;
			this.HEIGHT = HEIGHT;
		
		this.defs = defs;
		this.parent = parent;
		this.contAvailable = contAvailable;
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLocation(0, 0);
		try
		{
			backgroundImg = ImageIO.read(getClass().getResourceAsStream(backgroundImgPath));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		setLayout(grid1);
		
		addFillerPanel(this);
//		addFillerPanel(this);
		JPanel menuBtnHolder = new JPanel();
		menuBtnHolder.setLayout(grid2);
		menuBtnHolder.setBackground(transparent);
		add(menuBtnHolder);
			addFillerPanel(menuBtnHolder);
			
			contBtn = new ContBtn(contAvailable);
			contBtn.setFocusable(false);
			menuBtnHolder.add(contBtn);
			
			newGameBtn = new NewGameBtn();
			newGameBtn.setFocusable(false);
			menuBtnHolder.add(newGameBtn);
			
			exitBtn = new ExitBtn();
			exitBtn.setFocusable(false);
			menuBtnHolder.add(exitBtn);
			
			JPanel info = new JPanel();
			info.setBackground(getRngColor());
			menuBtnHolder.add(info);
		addFillerPanel(this);
//		addFillerPanel(this);
		
		ActionListener actionListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent btnPressed)
			{
				Object btn = btnPressed.getSource();
				if(btn == contBtn)
				{
					JOptionPane.showMessageDialog(null, "Continue");
					launchContinueGame();
				}
				else if(btn == newGameBtn)
				{
					JOptionPane.showMessageDialog(null, "New Game");
					launchNewGame();
				}
				else if(btn == exitBtn)
					System.exit(0);
			}
		};
		if(contAvailable)
			contBtn.addActionListener(actionListener);
		newGameBtn.addActionListener(actionListener);
		exitBtn.addActionListener(actionListener);
		
		parent.setFocusable(true);
	}
	
	DirectoryHandler directoryHandler;
	
	private void launchNewGame()
	{
		/*
		 * Confirm window
		 */
		directoryHandler = new DirectoryHandler(defs);
		parent.getContentPane().remove(this);
		if(!contAvailable)
		{
			directoryHandler.createFolder();
			for(String file: defs.filenameArray)
				directoryHandler.createFile(file);
		}
		else
			directoryHandler.restoreGPNFs();
		
		// Gen. maze
		new MazeHandler(defs).genMaze();
		
		// Gen chests
		Chest[] chestArray = new Chest(0, 0, 0, 0, 0).getChestArray(defs);
		
		int dim = defs.DIM;
		
		// Gen. player start pos.
		int playerX = dim / 2;
		int playerY = dim / 2;
		while((dim / 4) < playerX && playerX < ((3 * dim) / 4))
			playerX = (int) (Math.random() * dim);
		while((dim / 4) < playerY && playerY < ((3 * dim) / 4))
			playerY = (int) (Math.random() * dim);
		
		// Gen. enemy start pos., ensure it starts in opposite quadrant of player
		int enemyXMax, enemyXMin,
			enemyYMax, enemyYMin;
		if(playerX < dim / 2)
		{
			enemyXMin = (3 * dim) / 4;
			enemyXMax = dim;
		}
		else
		{
			enemyXMin = 0;
			enemyXMax = dim / 4;
		}
		if(playerY < dim / 2)
		{
			enemyYMin = (3 * dim) / 4;
			enemyYMax = dim;
		}
		else
		{
			enemyYMin = 0;
			enemyYMax = dim / 4;
		}
		int enemyX = (int) ((Math.random() * (enemyXMax - enemyXMin)) + enemyXMin);
		int enemyY = (int) ((Math.random() * (enemyYMax - enemyYMin)) + enemyYMin);
	}
	
	private void launchContinueGame(){}
	
	private Color getRngColor()
	{
		int R = (int) (Math.random() * 255);
		int G = (int) (Math.random() * 255);
		int B = (int) (Math.random() * 255);
		
		return new Color(R, G, B);
	}

	private void addFillerPanel(JPanel parent)
	{
		JPanel fillerPanel = new JPanel();
		fillerPanel.setBackground(transparent);
		parent.add(fillerPanel);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g_2d = (Graphics2D) g;
		
		g.drawImage(backgroundImg, 0, 0, WIDTH, HEIGHT, this);
	}
}