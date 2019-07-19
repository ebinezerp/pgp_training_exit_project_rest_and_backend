
package pgp.skillmapper.backend;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import pgp.skillmapper.backend.model.Employee;
import pgp.skillmapper.backend.service.EmployeeService;
import pgp.skillmapper.backend.util.EmployeeUtility;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = BackendApplication.class)
public class AddEmployeeTest {

	@Autowired
	private EmployeeService employeeService;

	private Employee employee;

	@Before
	public void setup() {
		employee = EmployeeUtility.getInstance();
	}

	@After
	public void tearDown() {

		if (employeeService.getEmployee(employee.getId()) != null) {
			employeeService.deleteEmployee(employee);
		}

	}

	@Test
	public void addEmployeeTest() {
		assertNotNull(employeeService.save(employee));
	}

	@Test
	public void addEmployeeWithFirstnameNullTest() {
		employee.setFirstname(null);
		assertNull(employeeService.save(employee));
	}

	@Test
	public void addEmployeeWithUsernameNullTest() {
		employee.setUsername(null);
		assertNull(employeeService.save(employee));
	}

	@Test
	public void addEmployeeWithDuplicateEmailTest() {
		assertNotNull(employeeService.save(employee));
		Employee employee1 = EmployeeUtility.getInstaceForDuplicate();
		employee1.setEmail(employee.getEmail());
		assertNull(employeeService.save(employee1));

	}

	@Test
	public void addEmployeeWithDuplicateUsernameTest() {
		assertNotNull(employeeService.save(employee));
		Employee employee1 = EmployeeUtility.getInstaceForDuplicate();
		employee1.setUsername(employee.getUsername());
		assertNull(employeeService.save(employee1));
	}

}
