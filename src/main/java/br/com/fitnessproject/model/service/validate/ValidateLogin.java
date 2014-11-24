package br.com.fitnessproject.model.service.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.fitnessproject.model.entity.Login;



public class ValidateLogin implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		Login login = (Login) arg0; 
		if(login.getEmail().equals("") || login.getEmail() == null){
			errors.rejectValue("email", "Email nulo!");
		}
		if(login.getPassword().equals("") || login.getEmail() == null){
			errors.rejectValue("senha", "Senha nula!");
		}
		
	}
	
	
}
