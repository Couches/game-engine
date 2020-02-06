package com.couches.engine;

public class Container implements Runnable
{
	private Thread thread;
	private Window window;
	private Render renderer;
	private Input input;
	private Controller game;
	
	private boolean running = false;
	private final double UPDATE_CAP = 1.0 / 144.0;
	public int displayWidth = 400, displayHeight = 400;
	private float scale = 1f;
	private String title = "Couches' Engine v1.0";
	
	public Container(Controller game)
	{
		this.game = game;
	}
	
	public Container()
	{
		
	}
	
	public void start()
	{
		window = new Window(this);
		renderer = new Render(this);
		input = new Input(this);
		
		thread = new Thread(this);
		thread.run();
	}
	
	public void stop()
	{
		
	}
	
	public void run()
	{
		running = true;
		
		boolean render;
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;
		
		double frameTime = 0;
		int frames = 0;
		int fps = 0;
		
		while(running)
		{
			render = false;
			
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unprocessedTime += passedTime;
			frameTime += passedTime;
			
			while(unprocessedTime >= UPDATE_CAP)
			{
				unprocessedTime -= UPDATE_CAP;
				render = true;
				
				game.update(this, (float) UPDATE_CAP);
				
				input.update();
				
				if(frameTime >= 1.0)
				{
					frameTime = 0;
					fps = frames;
					frames = 0;
					System.out.println("FPS: " + fps);
				}
			}
			
			if(render)
			{
				renderer.clear(0, 191, 255);
				game.render(this, renderer);
				window.update();
				frames++;
			}
			else
			{
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		dispose();
	}
	
	private void dispose()
	{
		
	}

	public int getWidth()
	{
		return displayWidth;
	}

	public void setWidth(int width)
	{
		this.displayWidth = width;
	}

	public int getHeight()
	{
		return displayHeight;
	}

	public void setHeight(int height)
	{
		this.displayHeight = height;
	}

	public float getScale()
	{
		return scale;
	}

	public void setScale(float scale)
	{
		this.scale = scale;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Window getWindow()
	{
		return window;
	}

	public Input getInput()
	{
		return input;
	}
}