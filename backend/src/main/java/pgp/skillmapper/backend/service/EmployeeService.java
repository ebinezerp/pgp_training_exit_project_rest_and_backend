package pgp.skillmapper.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pgp.skillmapper.backend.model.Employee;
import pgp.skillmapper.backend.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee save(Employee employee) {
		try {
			return employeeRepository.save(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Employee update(Employee employee) {
		System.out.println("update method called");
		try {
			return employeeRepository.save(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Employee getEmployee(Long id) {
		try {
			return employeeRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Employee getEmployeeByUsername(String username) {
		try {
			return employeeRepository.findByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Employee getEmployeeByEmail(String email) {
		try {
			return employeeRepository.findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Employee getEmployee(String email, String username) {
		try {
			return employeeRepository.findByUsernameOrEmail(username, email);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Employee getEmployee(String email, String username,String password) {
		try {
			return employeeRepository.login(username, email,password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Employee> getEmployeeByFirstname(String firstname) {
		try {
			return employeeRepository.findByFirstname(firstname);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Employee> getEmployeeByLastname(String lastname) {
		try {
			return employeeRepository.findByFirstname(lastname);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteEmployee(Employee employee) {
		try {
			employeeRepository.delete(employee);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Employee getEmployeeByMobile(String mobile) {
		try {
			return employeeRepository.findByMobile(mobile);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Employee getEmployeeWithUsernameAndNotWithId(String username, Long id) {
		try {
			return employeeRepository.findByUsernameAndIdNot(username, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Employee getEmployeeWithEmailAndNotWithId(String email, Long id) {
		try {
			return employeeRepository.findByEmailAndIdNot(email, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Employee getEmployeeWithMobileAndNotWithId(String mobile, Long id) {
		try {
			return employeeRepository.findByMobileAndIdNot(mobile, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Employee> getEmployees() {
		try {
			return employeeRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
