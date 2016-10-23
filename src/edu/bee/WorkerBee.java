package edu.bee;

public class WorkerBee extends Bee{
	public boolean isDead(){		
			return getHealth() < 70;				
	}
	public String getType(){
		return "Worker";
	}
}
