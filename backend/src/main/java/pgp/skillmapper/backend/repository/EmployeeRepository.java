package pgp.skillmapper.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pgp.skillmapper.backend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public Employee findByUsername(String username);
	public Employee findByEmail(String email);
	public Employee findByUsernameOrEmail(String username,String email);
	public Employee findByUsernameOrEmailAndPassword(String username,String email,String password);
	public Employee findByMobile(String mobile);
	public List<Employee> findByFirstname(String firstname);
	public List<Employee> findByLastname(String lastname);
	public Employee findByUsernameAndIdNot(String username,Long id);
	public Employee findByEmailAndIdNot(String email, Long id);
	public Employee findByMobileAndIdNot(String mobile, Long id);
	
}
