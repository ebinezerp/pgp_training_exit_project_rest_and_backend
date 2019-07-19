package pgp.skillmapper.backend.util;

import pgp.skillmapper.backend.model.Employee;

public class EmployeeUtility {

	public static Employee getInstance() {
		Employee employee = new Employee();

		employee.setFirstname("ebinezer");
		employee.setLastname("perumala");
		employee.setEmail("ebinezer.p87@gmail.com");
		employee.setMobile("9494216610");
		employee.setUsername("ebinezer");
		employee.setPassword("P@ssw0rd#123");
		employee.setRole("employee");
		employee.setEnabled(true);
		return employee;
	}
	
	
	public static Employee getInstaceForDuplicate() {
	
		Employee employee = new Employee();

		employee.setFirstname("sudhakar");
		employee.setLastname("perumala");
		employee.setEmail("sudhakar@gmail.com");
		employee.setMobile("9494216611");
		employee.setUsername("sudhakar");
		employee.setPassword("P@ssw0rd#123");
		employee.setRole("employee");
		employee.setEnabled(true);
		return employee;
	}

}
