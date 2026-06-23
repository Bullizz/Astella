package gui.start_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.Frame;
import main.Definitions;

public class StartMenuPanel extends JPanel
{
	BufferedImage backgroundImg;
	final static GridLayout grid1 = new GridLayout(1, 3);
	final static GridLayout grid2 = new GridLayout(5, 1);
	final static Color transparent = new Color(255, 255, 255, 1);
	
	int WIDTH, HEIGHT;
	
	ContBtn contBtn;
	NewGameBtn newGameBtn;
	ExitBtn exitBtn;
	
	public StartMenuPanel(Definitions defs, int WIDTH, int HEIGHT, Frame parent, boolean contAvailable)
	{
		super();
			this.WIDTH  = WIDTH;
			this.HEIGHT = HEIGHT;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLocation(0, 0);
		try
		{
			backgroundImg = ImageIO.read(new File("C:/Users/albin/eclipse-workspace/Astella/src/gui/start_menu/menu-V1.png"));
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
		contBtn.addActionListener(actionListener);
		if(contAvailable)
			newGameBtn.addActionListener(actionListener);
		exitBtn.addActionListener(actionListener);
		
		parent.setFocusable(true);
	}
	
	private void launchNewGame()
	{
		
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
		
		g_2d.drawImage(backgroundImg, 0, 0, WIDTH, HEIGHT, this);
	}
}