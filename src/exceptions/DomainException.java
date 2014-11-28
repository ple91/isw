package exceptions;

public class DomainException extends Exception {
	private static final long serialVersionUID = 1L;

	public DomainException(String arg0) {
		super(arg0);
	}

	public DomainException() {
		super("A database excepcion has occurred");
	}

	public DomainException(Exception e) {
		super(e.getMessage());
	}

}
