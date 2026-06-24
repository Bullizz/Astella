package gui.start_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

import gui.Frame;
import main.Definitions;

public class ContBtn extends JButton
{
	Frame parent;
	Definitions defs;

	BufferedImage image, chestClosed, chestOpened;
	String  chestClosedPath = "/res/images/start_menu/cont-chest-closed-transp.png",
			chestOpenedPath = "/res/images/start_menu/cont-chest-open-transp.png";
	
	 // (width, height) = (384, 216)
	
	public ContBtn(boolean contAvailable)
	{
		super();
		setText("Continue");
//		setBackground(new Color(255, 255, 255, 1));
//		setForeground(Color.BLACK);
		Border border = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
		setBorder(border);
		
		try
		{
			chestClosed = ImageIO.read(getClass().getResourceAsStream(chestClosedPath));
			chestOpened = ImageIO.read(getClass().getResourceAsStream(chestOpenedPath));
			
			image = chestClosed;
		} catch(IOException e)
		{
			e.printStackTrace();
		}
		if(contAvailable)
		{			
			addMouseListener(new MouseAdapter()
			{
				public void mouseEntered(MouseEvent enter)
				{
					image = chestOpened;
				}
				public void mouseExited(MouseEvent exit)
				{
					image = chestClosed;				
				}
			});
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Dimension d = this.getSize();
		Graphics2D g_2d = (Graphics2D) g;
		g_2d.drawImage(image, 0, 0, d.width, d.height, this);
	}
}