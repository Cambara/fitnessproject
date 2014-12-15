package br.com.fitnessproject.model.service.validate;

import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.fitnessproject.model.db.dao.login.LoginDao;
import br.com.fitnessproject.model.entity.Login;
import br.com.fitnessproject.model.enums.StatusLogin;

public class ValidateEmail{
	
	private LoginDao dao;
	private boolean isLogin;
	
	public ValidateEmail(LoginDao dao, boolean isLogin){
		this.dao = dao;
		this.isLogin = isLogin;
	}

	
	public void validate(Object e, Map<String, String> errors) {
		String email = "";
		Login l = null;
		if(isLogin){
			l = (Login) e;
			email = l.getEmail(); 
		}else{
			email = (String) e;
		}
		
		Login login = dao.findByEmail(email);
		if(isLogin){
			String password = l.getPassword();
			if(login == null || !login.getPassword().equals(password)){
				errors.put("email", "Email ou a senha podem estar errados!");
			}
		}else{
			if(login != null){
				errors.put("email", "Email já existe!");
			}
		}
		
		
	}
	
	public boolean supports(Class<?> arg0) {
		return String.class.equals(arg0);
	}

	
}
