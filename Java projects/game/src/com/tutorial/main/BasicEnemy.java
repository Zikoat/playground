package com.tutorial.main;

import java.awt.*;

import static java.awt.Color.*;

public class BasicEnemy extends GameObject{

	private Handler handler;
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;

		velX = 5;
		velY = 5;
		
		
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if (y <= 0 || y >= Game.HEIGHT - 16) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

		handler.addObject(new Trail(x+3, y+3, ID.Trail, red, 10, 10, 0.035f, handler));
	}

	public void render(Graphics g) {
		g.setColor(red);
		g.fillRect(x, y, 16, 16);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

}
