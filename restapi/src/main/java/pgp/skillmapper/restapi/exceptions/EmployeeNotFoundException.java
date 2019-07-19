package pgp.skillmapper.restapi.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
	private Long id;

	private String usernameOrEmail;

	public EmployeeNotFoundException(Long id) {
		this.id = id;
	}

	public EmployeeNotFoundException(String usernameOrEmail) {
		super();
		this.usernameOrEmail = usernameOrEmail;
	}

	@Override
	public String getMessage() {
		if (id == null) {
			return usernameOrEmail + " Employee is not existed";
		}
		return id + " employee is not existed";
	}

}
