package pgp.skillmapper.restapi.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

@Component
public class RequestBodyValidations {
	
	public Map<String,String> employeeValidations(Errors errors){
		Map<String, String> errorMessages=new HashMap<String, String>();
		
		for(FieldError fieldError: errors.getFieldErrors()) {
			if(fieldError.getField().equals("firstname")) {
				errorMessages.put("firstname_error", fieldError.getDefaultMessage());
			}
			
			if(fieldError.getField().equals("lastname")) {
				errorMessages.put("lastname_error", fieldError.getDefaultMessage());
			}
			
			if(fieldError.getField().equals("email")) {
				errorMessages.put("email_error", fieldError.getDefaultMessage());
			}
			
			if(fieldError.getField().equals("mobile")) {
				errorMessages.put("mobile_error", fieldError.getDefaultMessage());
			}
			
			if(fieldError.getField().equals("username")) {
				errorMessages.put("username_error", fieldError.getDefaultMessage());
			}
			
			if(fieldError.getField().equals("password")) {
				errorMessages.put("password_error", fieldError.getDefaultMessage());
			}
		}
		
		return errorMessages;
		
	}

}
