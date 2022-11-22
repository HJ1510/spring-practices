package com.bitacademy.fileupload.exception;

public class FileUploadServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FileUploadServiceException() {
		super("FileUploadServiceException Occurs");
	}
	
	public FileUploadServiceException(String message) {
		super(message);
	}
}
