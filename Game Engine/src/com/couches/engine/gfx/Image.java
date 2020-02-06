package com.couches.engine.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image
{
	private int w, h;
	private int[] p;
	
	public Image(String path)
	{
		BufferedImage image = null;
		File file = new File(path);
		
		try
		{
			image = ImageIO.read(file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		w = image.getWidth();
		h = image.getHeight();
		this.p = image.getRGB(0,  0,  w,  h,  null, 0, w);
		
		image.flush();
	}

	public int getW()
	{
		return w;
	}

	public void setW(int w)
	{
		this.w = w;
	}

	public int getH()
	{
		return h;
	}

	public void setH(int h)
	{
		this.h = h;
	}

	public int[] getP()
	{
		return p;
	}

	public void setP(int[] p)
	{
		this.p = p;
	}
}
