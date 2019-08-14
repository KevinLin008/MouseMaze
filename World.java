

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


import Interfaces.WorldObject;
//import Interfaces.problemMovingException;
import WorldObjects.Impassable;
import WorldObjects.Passable;



public class World {
	WorldObject[][] WorldArray;
	String [][] displayedWorld;
	Drone drone;
	private int displayCount = 0;
	
	/**
	 * Constructor for World.
	 * @param X specifies the length in the horizontal direction.
	 * @param Y specifies the length in the vertical direction.
	 */
	public World(int Y, int X) {
		this.WorldArray = new WorldObject[Y+2][X+2];
		this.displayedWorld = new String[Y+2][X+2];
		this.drone = new Drone(WorldArray);
	}
	
	/**
	 * First method of creating a world is by generating a random number with
	 * a 35:65 chance of impassable to passable.
	 */
	public void CreateWorld() {
		for(int row = 0 + 1; row < this.WorldArray.length-1; row++) {
			for(int column = 0 + 1; column < this.WorldArray[row].length-1; column++) {
				int randInt = randInt();
				if(randInt <= 35) {
					WorldArray[row][column] = new Impassable();
				} else {
					WorldArray[row][column] = new Passable();
				}
			}
		}
		//for the outer border
		for(int i = 0; i < this.WorldArray.length; i++) {
			this.WorldArray[0][i] = new Impassable();
			this.WorldArray[this.WorldArray.length-1][i] = new Impassable();
			this.WorldArray[i][0] = new Impassable();
			this.WorldArray[i][this.WorldArray.length-1] = new Impassable();
		}	
	}

	
	/**
	 * A method to display the world created by a String [][] representation.
	 */
	public void displayWorld(){
		for(int row = 0; row < this.WorldArray.length; row++) {
			for(int column = 0; column < this.WorldArray[row].length; column++) {
				if(this.WorldArray[row][column] instanceof Impassable) {
					this.displayedWorld[row][column] = "X";
				} else if(this.WorldArray[row][column] instanceof Passable) {
					this.displayedWorld[row][column] = " ";
				}
			}
		}
		//For the first time this will run to decide where the drone will start.
		//printRows() first to provide a visual for user to select drone start location.
		if(this.displayCount == 0) {
			printRows();
			startUp();
		}
		this.displayedWorld[this.drone.getY()][this.drone.getX()] = this.drone.getPointer();
		printRows();
	}
	
	public void startUp() {
		boolean valid = false;
		Scanner scanner = new Scanner(System.in);
		while(!valid) {
			System.out.println("Where would you like to start?");
			int droneY = scanner.nextInt();
			int droneX = scanner.nextInt();
			if(WorldArray[droneY][droneX] instanceof Impassable) {
				System.out.println("That spot is obstructed pick another...");
			} else {
				drone.set(droneY, droneX);
				valid = true;
			}
		}
		scanner.close();
		this.displayCount++;
	}
	
	/**
	 * Adds a WorldObject at a specific specified position.
	 * @param newObject - the new object you wish to add.
	 * @param X - The horizontal component of the location you wish to add newObject.
	 * @param Y - The vertical component of the location you wish to add newObject.
	 */
	public void add(WorldObject newObject, int Y, int X) {
		this.WorldArray[Y][X] = newObject;
	}
	
	//Helper Methods
	
	/**
	 * A random number generator that generates a number from 1 to 100.
	 * @return randNum is a randomly generated integer.
	 */
	public int randInt() {
		Random rand = new Random();
		int randNum = rand.nextInt(100);
		randNum += 1;
		
		return randNum;
	}	
	
	/**
	 * A method to print out the rows of the world on the 2D array.
	 */
	public void printRows(){
		for (int row = 0; row < this.displayedWorld.length; row++) {
			System.out.println(Arrays.toString(this.displayedWorld[row]).replace(",", ""));
		}
		//to separate each world printed
		System.out.println();
	}

}