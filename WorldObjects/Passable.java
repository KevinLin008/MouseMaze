package WorldObjects;
import Interfaces.WorldObject;

public class Passable implements WorldObject {
	private String name = "Passable";
	private int x, y;
	
	public String getName() {
		return this.name;
	}
			
	public void setX(int newX){	//setting the coordinates
		this.x = newX;
	}

	public void setY(int newY){	
		this.y = newY;
	}

	public int getX(){			//getting the coordinates
		return this.x;
	}

	public int getY(){			
		return this.y;
	}
	

}
