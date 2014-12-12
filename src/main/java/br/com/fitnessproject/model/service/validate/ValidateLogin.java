package br.com.fitnessproject.model.service.validate;

import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.fitnessproject.model.entity.Login;



public class ValidateLogin{


	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	public void validate(Object arg0, Map<String, String>  errors) {
		Login login = (Login) arg0; 
		if(login.getEmail().equals("") || login.getEmail() == null){
			errors.put("email", "Email nulo!");
		}
		if(login.getPassword().equals("") || login.getEmail() == null){
			errors.put("senha", "Senha nula!");
		}
		
	}
	
	
}
