package com.couches.engine.gfx;

public class Tile extends Image
{
	private int tileW, tileH;
	private double scale;
	
	public Tile(String path, double scale, int tileW, int tileH)
	{
		super(path);
		this.tileW = tileW;
		this.tileH = tileH;
		this.scale = scale;
	}

	public int getTileW()
	{
		return tileW;
	}

	public void setTileW(int tileW)
	{
		this.tileW = tileW;
	}

	public int getTileH()
	{
		return tileH;
	}

	public void setTileH(int tileH)
	{
		this.tileH = tileH;
	}
}
