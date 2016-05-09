package com.tutorial.main;

import java.util.Random;

/**
 * Created by zik on 14.01.16.
 */
public class Spawn {
    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    public Spawn(Handler handler, HUD hud){

        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){

        if(Game.getTime() == 5 && hud.getLevel() != 1){ // if time
            hud.setLevel(1);
            System.out.println(Game.getTime());
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        }

        if(hud.getLevel() == 2){
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
        }
    }
}
