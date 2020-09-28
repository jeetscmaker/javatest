package org.jk.exception;

public class FileReadException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FileReadException(String message) {
		super(message);
	}
}
