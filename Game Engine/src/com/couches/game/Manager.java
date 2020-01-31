package com.couches.game;

import java.awt.event.KeyEvent;

import com.couches.engine.Container;
import com.couches.engine.Controller;
import com.couches.engine.Render;
import com.couches.engine.gfx.Image;

public class Manager extends Controller	
{
	private Image image;
	
	public Manager()
	{
		image = new Image("sample.png");
	}

	public void update(Container c, float dt)
	{
		if (c.getInput().isKeyDown(KeyEvent.VK_A))
		{
			System.out.println("A was pressed");
		}
	}

	public void render(Container c, Render r)
	{
		r.drawImage(image, c.getInput().getMouseX(), c.getInput().getMouseY());
	}
	
	public static void main(String[] args)
	{
		Container c = new Container(new Manager());
		c.start();
	}
}
