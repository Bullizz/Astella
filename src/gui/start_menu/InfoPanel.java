package gui.start_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class InfoPanel extends JPanel
{
	BufferedImage image;
	String imagePath = "/res/images/start_menu/info-panel-transp.png";
	
	public InfoPanel()
	{
		super();
		setOpaque(false);
		try
		{
			image = ImageIO.read(getClass().getResourceAsStream(imagePath));
		} catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Dimension d = super.getSize();
		g.drawImage(image, 0, 0, d.width, d.height, null);
	}
}