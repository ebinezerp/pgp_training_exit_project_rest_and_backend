package pgp.skillmapper.restapi.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pgp.skillmapper.backend.model.Employee;
import pgp.skillmapper.backend.service.EmployeeService;
import pgp.skillmapper.backend.util.EmployeeValidation;
import pgp.skillmapper.restapi.exceptions.EmployeeNotFoundException;
import pgp.skillmapper.restapi.exceptions.EmployeeValidationException;
import pgp.skillmapper.restapi.util.RequestBodyValidations;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeValidation employeeValidation;

	@Autowired
	private RequestBodyValidations requestBodyValidations;

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employees = employeeService.getEmployees();
		if (employees != null) {
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Employee>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
		Employee employee = employeeService.getEmployee(id);
		if (employee == null) {
			throw new EmployeeNotFoundException(id);
		} else {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> register(@Valid @RequestBody Employee employee, Errors errors) {

		if (errors.hasErrors()) {
			throw new EmployeeValidationException(requestBodyValidations.employeeValidations(errors));
		}

		Map<String, String> errorMessages = employeeValidation.validateNewEmployeeRecord(employee);

		if (errorMessages.size() > 0) {
			throw new EmployeeValidationException(errorMessages);
		}

		if (employeeService.save(employee) == null) {
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		}

	}

	@PutMapping("/employee")
	public ResponseEntity<Employee> update(@Valid @RequestBody Employee employee, Errors errors) {

		if (errors.hasErrors()) {
			throw new EmployeeValidationException(requestBodyValidations.employeeValidations(errors));
		}

		Map<String, String> errorMessages = employeeValidation.validateEmployeeUpdateRecord(employee);

		if (errorMessages.size() > 0) {
			throw new EmployeeValidationException(errorMessages);
		}

		if (employeeService.update(employee) == null) {
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Employee> login(@RequestParam("username") String usernameOrEmail,
			@RequestParam("password") String password) {

		Employee employee = employeeService.getEmployee(usernameOrEmail, usernameOrEmail, password);

		if (employee == null) {
			throw new EmployeeNotFoundException(usernameOrEmail);
		}

		return new ResponseEntity<Employee>(employee, HttpStatus.FOUND);

	}

}
