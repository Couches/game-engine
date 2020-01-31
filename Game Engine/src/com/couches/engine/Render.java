package com.couches.engine;

import java.awt.image.DataBufferInt;

import com.couches.engine.gfx.Image;

public class Render
{
	private int pw, ph;
	private int[] p;
	
	public Render(Container c)
	{
		pw = c.getWidth();
		ph = c.getHeight();
		p = ((DataBufferInt)c.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void clear()
	{
		for(int i = 0; i < p.length; i++) p[i] = 0;
	}
	
	public void setPixel(int x, int y, int value)
	{
		if ((x < 0 || x >= pw || y < 0 || y >= ph) || value == 0xffff00ff)
		{
			return;
		}
		
		p[x + y * pw] = value; 
	}
	
	public void drawImage(Image image, int offX, int offY)
	{
		int newX = 0;
		int newY = 0;
		int newWidth = 0;
		int newHeight = 0;
		
		for (int y = 0; y < image.getH(); y++)
		{
			for (int x = 0; x < image.getW(); x++)
			{
				setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
			}
		}
	}
}
