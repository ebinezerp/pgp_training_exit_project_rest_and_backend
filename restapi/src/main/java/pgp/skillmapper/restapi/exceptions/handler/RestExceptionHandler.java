package pgp.skillmapper.restapi.exceptions.handler;

import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pgp.skillmapper.restapi.exceptions.EmployeeNotFoundException;
import pgp.skillmapper.restapi.exceptions.EmployeeValidationException;

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(EmployeeValidationException.class)
	public ResponseEntity<Map<String, String>> handleEmployeeValidationException(EmployeeValidationException ex) {
		return new ResponseEntity<Map<String, String>>(ex.getErrorMessages(), HttpStatus.CONFLICT);
	}
}
