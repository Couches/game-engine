package com.couches.game;

import java.awt.event.KeyEvent;

import com.couches.engine.Container;
import com.couches.engine.Controller;
import com.couches.engine.Grid;
import com.couches.engine.Player;
import com.couches.engine.Render;

public class Manager extends Controller	
{
	Player player = new Player();
	Grid level = new Grid(200.0 / 16.0, "res/textures/sampleLevel02.png");
	
	public Manager()
	{
		
	}

	public void update(Container c, float dt)
	{
		player.update(c);
		
		
	}

	float temp = 0;
	
	public void render(Container c, Render r)
	{
		r.drawGrid(level, (int) -player.getX(), (int) -player.getY());
		r.drawPlayer(player, (int) player.getX(), (int) player.getY());
	}
	
	
	//c.getInput().getMouseX() - (int) (image.getW() * image.getScaleW() / 2
	public static void main(String[] args)
	{
		Container c = new Container(new Manager());
		c.start();
	}
}
