import Interfaces.Cardinal;
import Interfaces.WorldObject;
//import Interfaces.problemMovingException;
import Interfaces.problemMovingException;

//IMPORTANT: I used the rhetoric "row, column" to decide
//the array, therefore it is technically "Y-axis, X-axis."
public class Drone implements WorldObject {
	private final String NAME = "DRONE";
	private int x, y;
	private String pointer;
	private Cardinal direction;
	private WorldObject[] sensors;
	private ComputationalMatrix computationalMatrix;

	/**
	 * Sensors will be on the 4 Cardinal locations of the drone.
	 */
	public Drone(WorldObject[][] world) {
		this.sensors = new WorldObject[4];
		this.direction = Cardinal.NORTH;
		this.computationalMatrix = new ComputationalMatrix(sensorRead(world));
	}

	/**
	 * Manually set the drone somewhere in the World facing North.
	 * 
	 * @param x the specified set location of the World on the x axis.
	 * @param y the specified set location of the World on the y axis.
	 */
	public void set(int y, int x) {
		this.y = y;
		this.x = x;
		this.direction = Cardinal.NORTH;
	}

	/**
	 * This method will take in an array of WorldObjects and pass it to the sensors
	 * array which from indices 0 -> 3 reads what is in - {front, right, behind,
	 * left} of the drone.
	 * 
	 * @param objects is an array of WorldObjects that will be the current
	 *                WorldObjects in front of the drone. The drone will read the 4
	 *                WorldObjects directly around it. i.e. 
	 * 					& 
	 * 				   &^&
	 * 				 	&
	 */
	public WorldObject[] sensorRead(WorldObject[][] world) {
		try {
			if (this.direction == Cardinal.NORTH) {
				this.sensors[0] = world[this.y - 1][this.x];
				this.sensors[1] = world[this.y][this.x + 1];
				this.sensors[2] = world[this.y + 1][this.x];
				this.sensors[3] = world[this.y][this.x - 1];
			} else if (this.direction == Cardinal.EAST) {
				this.sensors[0] = world[this.y][this.x + 1];
				this.sensors[1] = world[this.y + 1][this.x];
				this.sensors[2] = world[this.y][this.x - 1];
				this.sensors[3] = world[this.y - 1][this.x];
			} else if (this.direction == Cardinal.SOUTH) {
				this.sensors[0] = world[this.y + 1][this.x];
				this.sensors[1] = world[this.y][this.x - 1];
				this.sensors[2] = world[this.y - 1][this.x];
				this.sensors[3] = world[this.y][this.x + 1];
			} else if (this.direction == Cardinal.WEST) {
				this.sensors[0] = world[this.y][this.x - 1];
				this.sensors[1] = world[this.y - 1][this.x];
				this.sensors[2] = world[this.y][this.x - 1];
				this.sensors[3] = world[this.y + 1][this.x];
			}
		} catch (ArrayIndexOutOfBoundsException exception) {
			// just for startup to work
		}

		return this.sensors;
	}

	/**
	 * Calls the method in ComputationalMatrix to conduct the logic.
	 * @throws problemMovingException
	 */
	//TODO: drone cannot go over impassible objects
	public void droneAutomatic(WorldObject[][] world) throws problemMovingException {
		Cardinal step = this.computationalMatrix.autonomous(sensorRead(world));
		if (step == Cardinal.NORTH) {
			this.direction = Cardinal.NORTH;
			setY(this.y-1);
		} else if (step == Cardinal.EAST) {
			this.direction = Cardinal.EAST;
			setX(this.x+1);
		} else if (step == Cardinal.SOUTH) {
			this.direction = Cardinal.SOUTH;
			setY(this.y+1);
		} else {
			this.direction = Cardinal.WEST;
			setX(this.x-1);
		}
	}
	
	//////////////////////////////////////////////////////////////////

	public String getName() {
		return this.NAME;
	}

	public void setX(int newX) { // setting the coordinates
		this.x = newX;
	}

	public void setY(int newY) {
		this.y = newY;
	}

	public int getX() { // getting the coordinates
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public String getPointer() {
		if (this.direction == Cardinal.NORTH)
			this.pointer = "^";
		else if (this.direction == Cardinal.EAST)
			this.pointer = ">";
		else if (this.direction == Cardinal.SOUTH)
			this.pointer = "v";
		// else if(this.direction == Cardinal.WEST)
		else
			this.pointer = "<";
		return this.pointer;
	}

}