package pgp.skillmapper.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pgp.skillmapper.backend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public Employee findByUsername(String username);

	public Employee findByEmail(String email);

	public Employee findByUsernameOrEmail(String username, String email);

	@Query("select e from Employee e where (e.username=:username and e.password=:password and e.enabled=true) or (e.email=:email and e.password=:password and e.enabled=true) ")
	public Employee login(@Param("username") String username, @Param("email") String email,
			@Param("password") String password);

	public Employee findByMobile(String mobile);

	public List<Employee> findByFirstname(String firstname);

	public List<Employee> findByLastname(String lastname);

	public Employee findByUsernameAndIdNot(String username, Long id);

	public Employee findByEmailAndIdNot(String email, Long id);

	public Employee findByMobileAndIdNot(String mobile, Long id);

}
