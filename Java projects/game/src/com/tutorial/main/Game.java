package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1550691097823471818L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 *9;
	
	private Thread thread;
	private boolean running = false;

	public static float timeSeconds;

	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private long firstTime;

	public Game(){
		
		handler = new Handler();
		
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "My Game!", this);
		
		hud = new HUD();
		spawner = new Spawn(handler, hud);
		r = new Random();
		
		handler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2, ID.Player, handler));

	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		
		running = true;
		
	}

	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		firstTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;

		// Heartbeat
		while (running){
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1){
				tick();
				delta--;
			}
			
			if (running) {
				render();
				/*try {
					Thread.sleep(16);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
			}
				
			frames++;
				
			if (System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("Time: " + Math.round((System.nanoTime() - firstTime) / 1000000000f));
				// System.out.println("Frames: " +  frames);
				frames = 0;
			}
		}
		stop(); 
	}
	
	private void tick (){
		handler.tick();
		hud.tick();
		spawner.tick();

		if (HUD.HEALTH == 0) System.exit(1);

		timeSeconds = (System.nanoTime() - firstTime) / 1000000000;

	}
	
	private void render (){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max){
	if (var >= max)
		return max;
	else if (var <= min) 
		return min;
	else 
		return var;
	}

	public static int getTime(){
		return Math.round(timeSeconds);
	}
	
	public static void main (String args[]){
		System.setProperty("sun.java2d.opengl", "true");
		
		new Game();
	}
	
}
