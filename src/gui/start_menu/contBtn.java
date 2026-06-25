package gui.start_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import gui.Frame;
import main.Definitions;

public class ContBtn extends JButton
{
	Definitions defs;

	BufferedImage image, chestClosed, chestOpened;
	String chestClosedPath = "/res/images/start_menu/cont-chest-closed-transp.png",
//		   chestOpenedPath = "/res/images/start_menu/cont-chest-open-transp.png";
		   chestOpenedPath = "/gui/start_menu/chest-open3.png";
	
	 // (width, height) = (384, 216)
	
	public ContBtn(boolean contAvailable)
	{
		super();
		setBorder(null);
		
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
//		setFocusPainted(false);
		
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
					repaint();
				}
				public void mouseExited(MouseEvent exit)
				{
					image = chestClosed;
					repaint();
				}
			});
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Dimension d = getSize();
		g.drawImage(image, 0, 0, d.width, d.height, null);
	}
}