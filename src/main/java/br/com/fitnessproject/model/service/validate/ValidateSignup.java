package br.com.fitnessproject.model.service.validate;

import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.fitnessproject.model.db.dao.login.LoginDao;
import br.com.fitnessproject.model.entity.Login;
import br.com.fitnessproject.model.service.EncryptionMD5;

public class ValidateSignup implements Validator{
	private LoginDao dao;
	
	public ValidateSignup(LoginDao dao){
		this.dao = dao;
	}
	@Override
	public boolean supports(Class<?> arg0) {
		return Map.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		Map<String, Object> map = (Map<String, Object>) arg0;
		Login login = (Login) map.get("login");
		String confirmPassword = (String) map.get("confirmPassword"); 
		String name = (String) map.get("name");
		new ValidateEmail(dao, false).validate(login.getEmail(), errors);;
		new ValidateLogin().validate(login, errors);
		if(!errors.hasErrors()){
			confirmPassword = EncryptionMD5.encrypt(confirmPassword); 
			if(name.equals("") || name == null){
				errors.rejectValue("name", "Nome nulo!");
			}
			if(!confirmPassword.equals(login.getPassword())){
				errors.rejectValue("password", "Senhas estão diferente");
			}
		}
		
	}
	

}
