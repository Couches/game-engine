package com.couches.engine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Grid
{
	private double scale;
	private int width, height;
	private BufferedImage image = null;
	
	public Grid(double scale, String path)
	{
		File file = new File(path);
		
		try
		{
			image = ImageIO.read(file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		this.scale = scale;
		this.width = image.getWidth();
		this.height = image.getHeight();
	}

	public BufferedImage getLevel()
	{
		return this.image;
	}
	
	public double getScale()
	{
		return this.scale;
	}
	
	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
}
