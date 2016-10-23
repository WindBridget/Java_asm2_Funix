package edu.bee;

public class QueenBee extends Bee{
	public boolean isDead(){		
			return getHealth() < 20;				
	}
	public String getType(){
		return "Queen";
	}
}

