// 컴퓨터학과, 20190975, 신효경
package exceptions;

public class IdNotExistsException  extends Exception {
	private static final long serialVersionUID = 1L;

	public IdNotExistsException(String message) {
		super(message);
	}
}
