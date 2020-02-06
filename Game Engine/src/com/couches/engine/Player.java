package com.couches.engine;

import java.awt.event.KeyEvent;

import com.couches.engine.gfx.Image;

public class Player
{
	private Container c = new Container();
	
	private double x, y, xvel, yvel;
	private Image texture = new Image("res/textures/sample02.png");
	
	public Player()
	{
		
	}

	public void update(Container c)
	{
		if (c.getInput().isKey(KeyEvent.VK_A)) xvel -= 0.2;
		if (c.getInput().isKey(KeyEvent.VK_D)) xvel += 0.2;
		if (c.getInput().isKey(KeyEvent.VK_W)) yvel -= 0.2;
		if (c.getInput().isKey(KeyEvent.VK_S)) yvel += 0.2;
		
		xvel *= 0.9;
		yvel *= 0.9;
		x += xvel;
		y += yvel;
	}
	
	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}
	
	public Image getTexture()
	{
		return this.texture;
	}
}
