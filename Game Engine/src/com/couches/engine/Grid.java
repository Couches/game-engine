package com.couches.engine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.couches.engine.gfx.Image;

public class Grid
{
	private double scale;
	private int width, height;
	private BufferedImage bufferedImage = null;
	private Image image = null;
	
	public Grid(double scale, String path)
	{
		File file = new File(path);
		
		try
		{
			bufferedImage = ImageIO.read(file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		this.scale = scale;
		this.width = bufferedImage.getWidth();
		this.height = bufferedImage.getHeight();
		
		image = new Image(path);
	}

	public BufferedImage getBufferedImage()
	{
		return this.bufferedImage;
	}
	
	public Image getImage()
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
