package br.com.fitnessproject.model.service.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.fitnessproject.model.db.dao.login.LoginDao;
import br.com.fitnessproject.model.entity.Login;
import br.com.fitnessproject.model.enums.StatusLogin;

public class ValidateEmail implements Validator{
	
	private LoginDao dao;
	private boolean isLogin;
	
	public ValidateEmail(LoginDao dao, boolean isLogin){
		this.dao = dao;
		this.isLogin = isLogin;
	}

	@Override
	public void validate(Object e, Errors errors) {
		String email = (String) e;
		Login login = dao.findByEmail(email);
		if(isLogin){
			if(login == null){
				errors.rejectValue("email", "Email ou a senha podem estar errados!");
			}
		}else{
			if(login != null){
				errors.rejectValue("email", "Email já existe!");
			}
		}
		
		
	}
	@Override
	public boolean supports(Class<?> arg0) {
		return String.class.equals(arg0);
	}

	
}
