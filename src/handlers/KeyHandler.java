package handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GameLoop;

public class KeyHandler implements KeyListener
{
	GameLoop gameloop;
	
	final int ESC		= KeyEvent.VK_ESCAPE,
			  UP		= KeyEvent.VK_W,
			  LEFT		= KeyEvent.VK_A,
			  DOWN		= KeyEvent.VK_S,
			  RIGHT		= KeyEvent.VK_D,
			  INVENTORY = KeyEvent.VK_E;

	@Override
	public void keyPressed(KeyEvent press)
	{
		int userInp = press.getKeyCode();
		if(userInp == ESC) // Launch menu
			System.exit(0);
	}

	@Override
	public void keyReleased(KeyEvent release)
	{
		
	}
	
	public void setGameloop(GameLoop gameloop)
	{
		this.gameloop = gameloop;
	}

	@Override // UN-USED
	public void keyTyped(KeyEvent e){}
}
