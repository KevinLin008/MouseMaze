package Interfaces;
//Everything that exists in this make shift world is of type WorldObject. An empty space is still a WorldObject.


public interface WorldObject {
	public String getName();
	public void setX(int newX);
	public void setY(int newY);
	public int getX();
	public int getY();
	
}
