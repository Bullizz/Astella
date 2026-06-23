package gui.start_menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class ExitBtn extends JButton
{
	BufferedImage image, chestClosed, chestOpened;
	public ExitBtn()
	{
		super();
		setText("New Game");
		setBackground(Color.RED);
		setForeground(Color.BLACK);
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
		Border border = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
		setBorder(border);
		
		try
		{
			chestClosed = ImageIO.read(new File("C:/Users/albin/eclipse-workspace/Astella/src/gui/start_menu/chest-closed2.png"));
			chestOpened = ImageIO.read(new File("C:/Users/albin/eclipse-workspace/Astella/src/gui/start_menu/chest-open2-txt.png"));
			
			image = chestClosed;
		} catch(IOException e)
		{
			e.printStackTrace();
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