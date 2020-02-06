package com.couches.engine;

import java.awt.Color;
import java.awt.image.DataBufferInt;

import com.couches.engine.gfx.Image;
import com.couches.engine.gfx.Tile;

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
	
	public void clear(int r, int g, int b)
	{
		for(int i = 0; i < p.length; i++) p[i] = new Color(r, g, b).getRGB();;
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
		if (offX < -image.getW()) return;
		if (offY < -image.getH()) return;
		if (offX >= pw) return;
		if (offY >= ph) return;
		
		int newX = 0;
		int newY = 0;
		double newWidth = image.getW();
		double newHeight = image.getH();
		
		if (offX < 0) newX -= offX;
		if (offY <  0) newY -= offY;
		
		if (newWidth + offX > pw) newWidth -= newWidth + offX - pw;
		if (newHeight + offY > ph) newHeight -= newHeight + offY - ph;
		
		for (int y = newY; y < newHeight; y++)
		{
			for (int x = newX; x < newWidth; x++)
			{
				setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
			}
		}
	}
	
	public void drawImageTile(Tile image, int offX, int offY, int tileX, int tileY)
	{
		if (offX < -image.getTileW()) return;
		if (offY < -image.getTileH()) return;
		if (offX >= pw) return;
		if (offY >= ph) return;
		
		int newX = 0;
		int newY = 0;
		int newWidth = image.getTileW();
		int newHeight = image.getTileH();
		
		if (offX < 0) newX -= offX;
		if (offY <  0) newY -= offY;
		if (newWidth + offX >= pw) newWidth -= newWidth + offX - pw;
		if (newHeight + offY >= ph) newHeight -= newHeight + offY - ph;
		
		for (int y = newY; y < newHeight; y++)
		{
			for (int x = newX; x < newWidth; x++)
			{
				setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
			}
		}
	}
	
	public void drawRect (int x, int y, int width, int height, int color)
	{
		for  (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				setPixel(x + j, y + i, color);
			}
		}
	}
	
	public void drawPlayer(Player player)
	{
		drawImage(player.getTexture(), (int) player.getX(), (int) player.getY());
	}
	
	public void drawGrid(Grid grid)
	{
		for (int i = 0; i < grid.getHeight(); i++)
		{
			for (int j = 0; j < grid.getWidth(); j++)
			{
				if (grid.getLevel().getRGB(i, j) != 0xffff00ff)
					drawRect((int) (i * grid.getScale()), (int) (j * grid.getScale()), (int) Math.ceil(grid.getScale()), (int) Math.ceil(grid.getScale()), grid.getLevel().getRGB(i, j));
			}
		}
	}
}
