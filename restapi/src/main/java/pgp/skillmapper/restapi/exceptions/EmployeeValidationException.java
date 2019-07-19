package pgp.skillmapper.restapi.exceptions;

import java.util.Map;

public class EmployeeValidationException extends RuntimeException {
	private Map<String, String> errorMessages;

	public EmployeeValidationException(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	@Override
	public String getMessage() {
		return "Employee validation errors";
	}

	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
	
	
	
}
