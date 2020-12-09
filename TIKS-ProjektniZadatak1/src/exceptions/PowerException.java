package exceptions;

/**
 * Exception class which defines exception which is thrown when we
 * attempt to raise to power that is out of defined interval.
 * @author Želimir Maletić
 * @version 1.0
 * @since 2020-12-9
 */
public class PowerException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor
	 * @param message Message to be displayed to console.
	 */
	public PowerException(String message) {
		super(message);
	}
}
