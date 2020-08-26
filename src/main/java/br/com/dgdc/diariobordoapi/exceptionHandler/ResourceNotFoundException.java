package br.com.dgdc.diariobordoapi.exceptionHandler;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		this.message = message;
	}
	
	public ResourceNotFoundException(String message, String value) {
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