package Interfaces;
/**
 * This exception will be thrown when the drone is unable to make a move.
 * @author KevinLin
 *
 */
public class problemMovingException extends Exception {
	
	private static final long serialVersionUID = 1L; //added this because the 
	//IDE suggested

	public problemMovingException(String message) {
		super(message);
	}
	
	public problemMovingException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
