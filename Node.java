//import Interfaces.Cardinal;
import Interfaces.WorldObject;

/**
 * This class will represent a node in the search tree.
 * Each node will have branches labeled up, right, down, and left.
 * The orientation will be in relation with the car.
 * @author KevinLin
 *
 */
public class Node {
	private WorldObject object;
//	private int x,y;
	
//	private int legNum;
//	private String token;
	
	private Node up;
	private Node right;
	private Node down;
	private Node left;
	
	public Node(WorldObject object) {
		this.object = object;
	}
	
	public WorldObject getObject() {
		return this.object;
	}
	
	//Since an recursive creation call would happen if
	//the constructor made new nodes, these add methods
	//will be able to create only one node.
	
	public void addUPnode(WorldObject object) {
		this.up = new Node(object);
	}
	
	public void addRIGHTnode(WorldObject object) {
		this.right = new Node(object);
	}
	
	public void addDOWNnode(WorldObject object) {
		this.down = new Node(object);
	}
	
	public void addLEFTnode(WorldObject object) {
		this.left = new Node(object);
	}
	
	public Node getUPnode() {
		return this.up;
	}
	public Node getRIGHTnode() {
		return this.right;
	}
	public Node getDOWNnode() {
		return this.down;
	}
	public Node getLEFTnode() {
		return this.left;
	}
	
	public void setObject(WorldObject object) {
		this.object = object;
	}
	
	

}
