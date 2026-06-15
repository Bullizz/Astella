package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel
{
	public GamePanel(){}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		Graphics2D g_2d = (Graphics2D) g;
		
		g_2d.dispose();
	}
}