package exceptions;

public class IdNotExistsException  extends Exception {
	private static final long serialVersionUID = 1L;

	public IdNotExistsException(String message) {
		super(message);
	}
}
