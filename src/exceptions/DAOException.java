package exceptions;

public class DAOException extends Exception {
	private static final long serialVersionUID = 1L;

	public DAOException(String arg0) {
		super(arg0);
	}

	public DAOException() {
		super("A database excepcion has occurred");
	}

	public DAOException(Exception e) {
		super(e.getMessage());
	}

}
