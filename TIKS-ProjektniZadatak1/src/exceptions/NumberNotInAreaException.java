package exceptions;

public class NumberNotInAreaException extends Exception {
	private static final long serialVersionUID = 1L;

	public NumberNotInAreaException(String message) {
		super(message);
	}
}
