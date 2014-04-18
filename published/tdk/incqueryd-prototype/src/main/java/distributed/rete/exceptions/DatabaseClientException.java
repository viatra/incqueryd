package distributed.rete.exceptions;

public class DatabaseClientException extends Exception {

	private static final long serialVersionUID = 1L;

	public DatabaseClientException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
