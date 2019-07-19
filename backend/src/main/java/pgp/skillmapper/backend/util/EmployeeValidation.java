package pgp.skillmapper.backend.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pgp.skillmapper.backend.model.Employee;
import pgp.skillmapper.backend.service.EmployeeService;

@Component
public class EmployeeValidation {
	
	@Autowired
	private EmployeeService employeeService;
	
	public Map<String, String> validateNewEmployeeRecord(Employee employee) {
		Map<String,String> errorMessages = new HashMap<String, String>();
		
		if(employeeService.getEmployeeByUsername(employee.getUsername())!=null) {
			errorMessages.put("username_error", "Username is already existed");
		}
		
		if(employeeService.getEmployeeByEmail(employee.getEmail())!=null) {
			errorMessages.put("email_error", "Email is already existed");
		}
		
		if(employeeService.getEmployeeByMobile(employee.getMobile())!=null) {
			errorMessages.put("mobile_error", "Mobile is already Existed");
		}
		
		return errorMessages;
	}
	
	
	public Map<String,String> validateEmployeeUpdateRecord(Employee employee){
		Map<String,String> errorMessages=new HashMap<String, String>();
		
		if(employeeService.getEmployeeWithUsernameAndNotWithId(employee.getUsername(), employee.getId())!=null) {
			errorMessages.put("username_error", "Username is already existed");
		}
		
		if(employeeService.getEmployeeWithEmailAndNotWithId(employee.getEmail(),employee.getId())!=null) {
			errorMessages.put("email_error", "Email is already existed");
		}
		
		if(employeeService.getEmployeeWithMobileAndNotWithId(employee.getMobile(), employee.getId())!=null) {
			errorMessages.put("mobile_error", "Mobile is already existed");
		}
		
		return errorMessages;
	}

}
