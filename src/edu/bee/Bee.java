package edu.bee;

import java.util.Random;

public abstract class Bee {
	private int health = 100;
	public abstract boolean isDead();
	public abstract String getType();	
	public void damage(){
		Random rand = new Random();
		int dam = rand.nextInt(101);
        if (isDead()){
        	return;
        }
        health = health - dam;
        if (health < 0){
        	health = 0;
        }            

    }
	
	public int getHealth(){
	    return health;
	}	
}
	