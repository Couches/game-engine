package com.couches.engine;

public abstract class Controller
{
	public abstract  void update(Container c, float dt);
	public abstract void render(Container c, Render r);
}
