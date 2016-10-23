package edu.bee;
import java.util.*;

public class AttackBee {
	
	/*private static int randInt(int min, int max) {
		Random rand = new Random();
		int rd = rand.nextInt((max - min) + 1) + min;	
		return rd;
	}*/
	
	private static void PrintBee(int number, Bee bee){
		int health = bee.getHealth();
		String type = bee.getType();
		String stt;
		if(bee.isDead()){
			stt = "Dead";
		}
		else{
			stt = "Alive";
		}
		
	    System.out.printf("   \t\t\t%-10d%-14s%-10d%-10s\n",number,type,health,stt);
	    
	}
	
	private static void CreateNewBees(ArrayList<Bee> list, int num){
        list.clear();       
        int numBee;
        Random rand = new Random();
        for (int i = 0; i < num -3 ; i++){            
            numBee = rand.nextInt(3);
            switch (numBee){
                case 0: list.add(new WorkerBee());               
                break;
                case 1: list.add(new DroneBee()); 
                break;
                case 2: list.add(new QueenBee());
                break;
            }
        }
        list.add(new WorkerBee());
        list.add(new DroneBee()); 
        list.add(new QueenBee());       
    }
	
	public static void main(String[] args) {
		try{
		ArrayList<Bee> myBee = new ArrayList<Bee>();
		boolean exit = false;
		int count = 1;				
		System.out.println("\n\t\t\tINPUT KEYS :\n\t\t\t1. Create new list Bee \n\t\t\t2. Attack Bees \n\t\t\t0. Exit\n\n\t\t\tFrist, Please input 1 to create a new list ! \n" );		
		System.out.print("\t\t\tInput : ");
		Scanner sc = new Scanner(System.in);
		while (!exit){				
			
			String choose = sc.nextLine();				
			int deadcount = 0;	            
			if (choose.equals("0")){	           	            		
				exit = true;
				sc.close();
			}		
			else if (choose.equals("1")){			
				CreateNewBees(myBee, 10);
				count = 1;
				System.out.println("\t\t\t               New list !\n\t\t\t-------------------***------------------\n");
				System.out.printf("   \t\t\t%-10s%-14s%-10s%-10s\n", "No.", "Type","Health","Status");
				System.out.println("\t\t\t----------------------------------------");
				for (int i = 0; i < myBee.size(); i++){
					PrintBee(i + 1, myBee.get(i));
				}
				System.out.println("\t\t\t-------------------***------------------\n\t\t\tNow choose 1 or 2: \n");
				System.out.print("\t\t\tInput : ");
			}
			else if (choose.equals("2")){				
				System.out.println("\t\t\tAFTER BE DAMAGED " + count + " TIME(S)\n\t\t\t-------------------***------------------\n");	                	
				System.out.printf("   \t\t\t%-10s%-14s%-10s%-10s\n", "No.", "Type","Health","Status");
				System.out.println("\t\t\t----------------------------------------");
				for (int i = 0; i < myBee.size(); i++){
				                          
				    myBee.get(i).damage();
				    PrintBee(i + 1, myBee.get(i));
				    if(myBee.get(i).isDead()== true){
				    	deadcount ++;
				    }
				}                   
				count ++;		                	
				if (deadcount == 10){
					System.out.println("\t\t\t-------------------***------------------\n\t\t\tAll bees are dead !\n\t\t\tPlease input 1 to create a new list !\n\t\t\tor 0 to exit \n");	                    	
					System.out.print("\t\t\tInput : ");
				}
				else{
					System.out.println("\t\t\t-------------------***------------------\n\t\t\tNow choose 1 or 2: \n");	                    	
					System.out.print("\t\t\tInput : ");
			    }
			}
			
			else{		                	
			    System.out.println("\t\t\tPlease choose 1 or 2 !");	
			    System.out.print("\t\t\tInput : ");
			}	        
		}
			
		System.out.println("\t\t\t-------------------***------------------\n\t\t\tGood bye! See you next time!");
		}
		catch (Exception e) {
			System.out.println("\t\t\tError !!! Try again !\n");
		}
	}
}
