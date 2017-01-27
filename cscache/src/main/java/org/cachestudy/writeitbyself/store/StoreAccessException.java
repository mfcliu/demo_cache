package org.cachestudy.writeitbyself.store;

public class StoreAccessException extends Exception {

	private static final long serialVersionUID = -3962141124378773527L;

	/**
	 * Creates a new exception wrapping the {@link Throwable cause} passed in.
	 *
	 * @param cause the cause of this exception
	 */
	public StoreAccessException(Throwable cause) {
		super(cause);
	}

	/**
	 * Creates a new exception wrapping the {@link Throwable cause} passed in and with the provided message.
	 *
	 * @param message information about the exception
	 * @param cause the cause of this exception
	 */
	public StoreAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates a new exception with the provided message.
	 *
	 * @param message information about the exception
	 */
	public StoreAccessException(String message) {
		super(message);
	}

}
