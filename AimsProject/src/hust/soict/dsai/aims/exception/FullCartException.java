package hust.soict.dsai.aims.exception;

public class FullCartException extends Exception {

	public FullCartException() {}

	public FullCartException(String message) {
		super(message);
	}

	public FullCartException(Throwable cause) {
		super(cause);
	}

	public FullCartException(String message, Throwable cause) {
		super(message, cause);
	}

	public FullCartException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
