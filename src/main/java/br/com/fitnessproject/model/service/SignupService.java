package br.com.fitnessproject.model.service;


import javax.servlet.http.HttpSession;

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
	private HttpSession session;
	
	public SignupService(UserDao userDao, GymDao gymDao,HttpSession session){
		this.userDao = userDao;
		this.gymDao = gymDao;
		this.session = session;
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
		u = userDao.add(u); 
		session.setAttribute("user", u);
		return u.getId() > 0 ? true: false;
	}
	private boolean createGym(String name, Login l){
		Gym g = new Gym();
		g.setName(name);
		g.setLogin(l);
		g = gymDao.add(g);
		session.setAttribute("gym", g);
		return g.getId() > 0 ? true:false;
	}
}
