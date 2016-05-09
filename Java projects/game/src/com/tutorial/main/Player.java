package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import static java.awt.Color.*;


public class Player extends GameObject{
	
	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 32);
		y = Game.clamp(y, 0, Game.HEIGHT - 32);
		
		collision();

		handler.addObject(new Trail(x+8, y+8, ID.Trail, Color.gray, 16, 16, 0.01f, handler));

	}
	
	private void collision(){
		for (int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			ID basicEnemyId = ID.BasicEnemy;
			
			if (tempObject.getID() == basicEnemyId) {
				if (getBounds().intersects(tempObject.getBounds())){
					//Collision code
					HUD.HEALTH -= 2;
				}
			}
		}
	}

	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}
