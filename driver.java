import Interfaces.problemMovingException;

//import java.util.Scanner;

public class driver {
	public static void main(String args[]) throws InterruptedException, problemMovingException {
		
		
		World firstWorld = new World(10, 10);
		firstWorld.CreateWorld();
		firstWorld.displayWorld();
		
		
		 while(true) {
			 firstWorld.drone.droneAutomatic(firstWorld.WorldArray);
			 firstWorld.displayWorld();
		 	Thread.sleep(2000);
		 }
	}
}
