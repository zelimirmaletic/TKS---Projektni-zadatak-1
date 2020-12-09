package exceptions;

public class NotSupportedOperationException extends Exception {
	private static final long serialVersionUID = 1L;

	public NotSupportedOperationException(String message){
		super(message);
	}
}
