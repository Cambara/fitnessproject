package br.com.fitnessproject.model.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import br.com.fitnessproject.model.db.dao.gym.GymDao;
import br.com.fitnessproject.model.db.dao.login.LoginDao;
import br.com.fitnessproject.model.db.dao.user.UserDao;
import br.com.fitnessproject.model.entity.Gym;
import br.com.fitnessproject.model.entity.Login;
import br.com.fitnessproject.model.entity.User;
import br.com.fitnessproject.model.enums.StatusLogin;
import br.com.fitnessproject.model.enums.TypeLogin;

public class LoginService {
	private UserDao userDao;
	private GymDao gymDao;
	private HttpSession session;
	
	public LoginService(UserDao userDao, GymDao gymDao,HttpSession session){
		this.userDao = userDao;
		this.gymDao = gymDao;
		this.session = session;
	}
	
	public Object completeLogin(LoginDao loginDao, Login l, Map<String,String> errors){
		Object resp = null;
		if(l.getStatus().equals(StatusLogin.DEACTIVATED)){
			l.setStatus(StatusLogin.ACTIVE);
			loginDao.update(l);
			//TODO:precisa enviar um email avisando que a conta foi ativada
		}
		if(l.getStatus().equals(StatusLogin.BLOCKED)){
			errors.put("email", "Está conta está bloqueada, por favor entre em contato com o suporte!");
		}
		else if(l.getType().equals(TypeLogin.GYM)){
			resp = getGym(l);
			
		}else{
			resp = getUser(l);
		}
		
		return resp;
	}
	public void logout(){
		session.invalidate();
	}
	private User getUser(Login l){
		User u = userDao.findByLogin(l);
		session.setAttribute("user", u);
		return u;
	}
	private Gym getGym(Login l){ 
		Gym g = gymDao.findByLogin(l);
		session.setAttribute("gym", g);
		return g;
	}
}
