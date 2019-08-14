import Interfaces.Cardinal;
import Interfaces.WorldObject;
import Interfaces.problemMovingException;
import WorldObjects.Passable;

/**
 * This class will read in data and analyze where and what kind of WorldObjects are
 * presently there and through its algorithms, determine how the drone will respond.
 * @author Kevin Lin
 */
public class ComputationalMatrix {
	//first attempt - binary search tree represented with an array
	//inside each index of the array will be a key for a key:value pair hashmap
	
	
	private Tree tree;
	
	
	public ComputationalMatrix(WorldObject[] snsrReadings) {
		this.tree = new Tree(new Passable());
	}
	
	//TODO: directions of the drone are not what they should be
	//	fix AI. 
	/**
	 * Returns a direction in-relation to the World.
	 */
	public Cardinal autonomous(WorldObject[] surroundings) throws problemMovingException {
		Cardinal nextStep = null;
		this.tree.updateNodes(surroundings);
		nextStep = this.tree.check();
		System.out.println(nextStep);
		return nextStep;
	}
	
	
}
