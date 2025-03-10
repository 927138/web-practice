package exception;


public class Exception extends RuntimeException {

	private final int errorCode;
	
	public Exception(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
}