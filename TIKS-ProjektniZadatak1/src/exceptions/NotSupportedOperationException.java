package exceptions;

/**
 * Exception class which defines exception which is thrown when we
 * attempt to execute operation that is not implemented.
 * @author Želimir Maletić
 * @version 1.0
 * @since 2020-12-9
 */
public class NotSupportedOperationException extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor
	 * @param message Message to be displayed to console.
	 */
	public NotSupportedOperationException(String message){
		super(message);
	}
}
