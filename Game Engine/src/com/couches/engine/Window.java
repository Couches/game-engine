package com.couches.engine;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Window
{
	private JFrame frame;
	private BufferedImage image;
	private BufferStrategy bs;
	private Canvas canvas;
	private Graphics g;
	private Container c;
	private float zm;
	
	public Window(Container c)
	{
		Dimension s = new Dimension((int) (c.getWidth()), (int) (c.getHeight()));
		image = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_RGB);
		canvas = new Canvas();
		canvas.setPreferredSize(s);
		canvas.setMaximumSize(s);
		canvas.setMinimumSize(s);
		
		frame = new  JFrame (c.getTitle());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas.createBufferStrategy(2);
		bs = canvas.getBufferStrategy();
		g = bs.getDrawGraphics();
		this.c = c;
	}
	
	public void update()
	{
		if (c.getInput().isKey(KeyEvent.VK_UP)) zm += 0.009;
		if (c.getInput().isKey(KeyEvent.VK_DOWN)) zm -= 0.009;
		zm *= 0.9;
		c.setScale(c.getScale() + zm);
		if (c.getScale() < 1f)
		{
			c.setScale(1f);
			zm = 0;
		}
		if (c.getScale() > 10f)
		{
			c.setScale(10f);
			zm = 0;
		}
		
		g.drawImage(image, (int) (c.getWidth() / 2 * (-c.getScale() + 1)), (int) (c.getHeight() / 2 * (-c.getScale() + 1)), (int) (canvas.getWidth() * c.getScale()), (int) (canvas.getHeight() * c.getScale()), null);
		bs.show();
	}

	public BufferedImage getImage()
	{
		return image;
	}

	public Canvas getCanvas()
	{
		return canvas;
	}

	public JFrame getFrame()
	{
		return frame;
	}
}
