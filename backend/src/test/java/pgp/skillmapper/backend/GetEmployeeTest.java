package pgp.skillmapper.backend;

import static org.junit.Assert.assertEquals;
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
public class GetEmployeeTest {
	
	@Autowired
	private EmployeeService employeeService;
	
	private Employee employee;
	
	@Before
	public void setup() {
		employee = EmployeeUtility.getInstance();
		employeeService.save(employee);
	}
	
	@After
	public void tearDown() {
		if(employeeService.getEmployee(employee.getId())!=null) {
			employeeService.deleteEmployee(employee);
		}
	}
	
	@Test
	public void getEmployeeTest() {
		Employee employee=employeeService.getEmployee(this.employee.getId());
		assertEquals(this.employee, employee);
	}
	
	
	@Test
	public void getEmployeeTestFailure() {
		assertNull(employeeService.getEmployee(200L));
	}
	
	

}
