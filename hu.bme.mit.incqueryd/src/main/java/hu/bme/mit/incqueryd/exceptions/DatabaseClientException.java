package hu.bme.mit.incqueryd.exceptions;

/**
 * 
 * @author szarnyasg
 *
 */
public class DatabaseClientException extends Exception {

    private static final long serialVersionUID = 1L;

    public DatabaseClientException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
