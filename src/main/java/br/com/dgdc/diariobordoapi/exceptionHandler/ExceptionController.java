package br.com.dgdc.diariobordoapi.exceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
	
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		Map<String, String> fields = new HashMap<>();

		for (ObjectError erro : ex.getBindingResult().getAllErrors()) {
			String atributo = ((FieldError) erro).getField();
			String mensagem = erro.getDefaultMessage();
			fields.put(atributo, mensagem);
		}

		var body = new ErrorBody();
		body.setStatus(status.value());
		body.setMensage("Um ou mais campos estao invalidos. Faca o preenchimento correto e tente novamente");
		body.setDate(LocalDateTime.now());
		body.setFields(fields);

		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
		return ResponseEntity.badRequest()
				.header("error_code", HttpStatus.BAD_REQUEST.toString())
				.header("error_value", String.valueOf(e.getValue())).body(e.getMessage());
	}

	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<String> handleResourceAlreadyExistsException(ResourceAlreadyExistsException e) {
		return ResponseEntity.badRequest()
				.header("error_code", HttpStatus.BAD_REQUEST.toString())
				.header("error_value", String.valueOf(e.getValue())).body(e.getMessage());
	}
}
