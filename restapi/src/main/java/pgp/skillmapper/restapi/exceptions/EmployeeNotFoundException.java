package pgp.skillmapper.restapi.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
	private Long id;
	
	public EmployeeNotFoundException(Long id) {
		this.id=id;
	}
	
	@Override
	public String getMessage() {
		return id+" employee is not existed";
	}
	
}
