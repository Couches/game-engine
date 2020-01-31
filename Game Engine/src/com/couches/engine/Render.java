package com.couches.engine;

import java.awt.image.DataBufferInt;

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
		for(int i = 0; i < p.length; i++)
		{
			//TODO: Set += i to = 0
			p[i] += i;
		}
	}
}
