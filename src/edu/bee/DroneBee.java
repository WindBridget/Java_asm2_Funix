package edu.bee;

public class DroneBee extends Bee{
	public boolean isDead(){		
			return getHealth() < 50;				
	}
	public String getType(){
		return "Drone";
	}
}

