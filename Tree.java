import Interfaces.Cardinal;
import Interfaces.WorldObject;
//import WorldObjects.Impassable;
import WorldObjects.Passable;
import Interfaces.problemMovingException;

//Attempt 1: make a 4n search tree
//Attempt 2: make a 4n decision tree
public class Tree {
	private Node root;
	private Node traversingNode;
	
	
	public Tree(WorldObject object) {
		this.root = new Node(object); // Do I need to clone root?
		this.traversingNode = this.root;
	}
	
	public void goUp() {
		this.traversingNode = this.traversingNode.getUPnode();
	}
	public void goRight() {
		this.traversingNode = this.traversingNode.getRIGHTnode();
	}
	public void goDown() {
		this.traversingNode = this.traversingNode.getDOWNnode();
	}
	public void goLeft() {
		this.traversingNode = this.traversingNode.getLEFTnode();
	}
	
	/**
	 * This method will check the 4 possible moves for the drone by checking
	 * the 4 nodes branching from the current traversingNode. The drone will always
	 * try to move forward if possible, if not... then right... then down... then left.
	 * @throws problemMovingException is thrown in this case if the drone
	 *  cannot make any moves.
	 */
	public Cardinal check() throws problemMovingException {
		if(this.traversingNode.getUPnode().getObject() instanceof Passable) {
			this.traversingNode = this.traversingNode.getUPnode();
			return Cardinal.NORTH;
		} else if(this.traversingNode.getRIGHTnode().getObject() instanceof Passable) {
			this.traversingNode = this.traversingNode.getRIGHTnode();
			return Cardinal.EAST;
		} else if(this.traversingNode.getDOWNnode().getObject() instanceof Passable) {
			this.traversingNode = this.traversingNode.getDOWNnode();
			return Cardinal.SOUTH;
		} else if(this.traversingNode.getLEFTnode().getObject() instanceof Passable) {
			this.traversingNode = this.traversingNode.getLEFTnode();
			return Cardinal.WEST;
		} else {
			throw new problemMovingException("The drone spawned in an immovable position.");
		}
	}
	
	/**
	 * This method will take in a "scan" of the WorldObjects around the drone 
	 * (represented through an array) and create new nodes and connect them with
	 * the root.
	 * @param surroundings is an array of WorldObjects around the drone currently.
	 */
	public void updateNodes(WorldObject[] surroundings) {
		this.traversingNode.addUPnode(surroundings[0]);		
		this.traversingNode.addRIGHTnode(surroundings[1]);
		this.traversingNode.addDOWNnode(surroundings[2]);
		this.traversingNode.addLEFTnode(surroundings[3]);
	}
	
	public void setObject(WorldObject object) {
		this.traversingNode.setObject(object);
	}
	
}
