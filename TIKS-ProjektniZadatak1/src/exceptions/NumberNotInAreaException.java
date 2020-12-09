package exceptions;
/**
 * Exception class which defines exception which is thrown when we
 * pass a value that is not in defined interval.
 * @author Želimir Maletić
 * @version 1.0
 * @since 2020-12-9
 */
public class NumberNotInAreaException extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor
	 * @param message Message to be displayed to console.
	 */
	public NumberNotInAreaException(String message) {
		super(message);
	}
}
