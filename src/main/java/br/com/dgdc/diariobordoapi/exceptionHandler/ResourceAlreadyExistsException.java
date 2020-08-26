package br.com.dgdc.diariobordoapi.exceptionHandler;

public class ResourceAlreadyExistsException extends RuntimeException {

	public ResourceAlreadyExistsException(String message) {
		this.message = message;
	}
	
	public ResourceAlreadyExistsException(String message, String value) {
		this.value = value;
		this.message = message + value;
	}
	
	private String message;
	private String value;
	
	public String getMessage() {
		return message;
	}

	public String getValue() {
		return value;
	}

}