package br.com.fitnessproject.model.service;


import org.springframework.beans.factory.annotation.Autowired;

import br.com.fitnessproject.model.db.dao.gym.GymDao;
import br.com.fitnessproject.model.db.dao.login.LoginDao;
import br.com.fitnessproject.model.db.dao.user.UserDao;
import br.com.fitnessproject.model.entity.Gym;
import br.com.fitnessproject.model.entity.Login;
import br.com.fitnessproject.model.entity.User;
import br.com.fitnessproject.model.enums.StatusLogin;
import br.com.fitnessproject.model.enums.TypeLogin;

public class SignupService {
	
	private UserDao userDao;
	private GymDao gymDao;
	
	public SignupService(UserDao userDao, GymDao gymDao){
		this.userDao = userDao;
		this.gymDao = gymDao;
	}
	
	public boolean completeSignup(LoginDao loginDao, Login l, String name){
		l.setStatus(StatusLogin.WAIT);
		loginDao.add(l); 
		boolean resp = false;
		if(l.getType().equals(TypeLogin.GYM)){
			resp = createGym(name, l);
		}else{
			resp = createUser(name, l);
		}
		
		return resp;
	}
	private boolean createUser(String name, Login l){
		User u = new User();
		u.setName(name);
		u.setLogin(l);
		return userDao.add(u).getId() > 0 ? true: false;
	}
	private boolean createGym(String name, Login l){
		Gym g = new Gym();
		g.setName(name);
		g.setLogin(l);
		return gymDao.add(g).getId() > 0 ? true:false;
	}
}
