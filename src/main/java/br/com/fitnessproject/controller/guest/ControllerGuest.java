package br.com.fitnessproject.controller.guest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fitnessproject.model.db.dao.gym.GymDao;
import br.com.fitnessproject.model.db.dao.login.LoginDao;
import br.com.fitnessproject.model.db.dao.user.UserDao;
import br.com.fitnessproject.model.entity.Gym;
import br.com.fitnessproject.model.entity.Login;
import br.com.fitnessproject.model.entity.User;
import br.com.fitnessproject.model.enums.TypeLogin;
import br.com.fitnessproject.model.service.LoginService;
import br.com.fitnessproject.model.service.SignupService;
import br.com.fitnessproject.model.service.validate.ValidateEmail;
import br.com.fitnessproject.model.service.validate.ValidateSignup;

@Controller
public class ControllerGuest {
	private static String DIR = "guest/";
	@Autowired
	LoginDao daoLogin;
	@Autowired
	UserDao userDao;
	@Autowired
	GymDao gymDao;
	@RequestMapping(value={"/index","","/"})
	public String index() {
		return DIR+"index";
	}
	@RequestMapping(value="/signup")
	public String signup(){
		return DIR+"signup";
	}
	@RequestMapping(value="doSignup")
	public @ResponseBody Map<String,Object> doSignup(@RequestBody Map<String,String> request, HttpSession session){
		String result= "500";
		
		Login l = new Login();
		l.setEmail(request.get("email"));
		l.setPassword(request.get("password"));
		l.setType(TypeLogin.valueOf(request.get("type")));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("login", l);
		map.put("confirmPassword", request.get("confirmPassword"));
		map.put("name", request.get("name"));
		Map<String, String> errors = new HashMap<String, String>();
		new ValidateSignup(daoLogin).validate(map, errors);
		if(errors.isEmpty()){			
			if(new SignupService(userDao,gymDao,session).completeSignup(daoLogin, l, request.get("name"))){
				
				result="200";
			}
		}
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("result", result);
		response.put("errors", errors);
		
		if(l.getType().equals(TypeLogin.GYM)){
			response.put("location", "gym/index");
		}else{
			response.put("location", "user/index");
		}
		return response;
	}
	@RequestMapping(value="/login")
	public String login(){
		
		return DIR+"login";
	}
	
	@RequestMapping(value="/doLogin")
	public @ResponseBody Map<String,Object> doLogin(@RequestBody Login login, HttpSession session){
		int result = 500;
		String location = "";
		Map<String,Object> response = new HashMap<String, Object>(); 
		Map<String, String> errors = new HashMap<String, String>();
		new ValidateEmail(daoLogin, true).validate(login, errors); 
		if(errors.isEmpty()){
			//validar o email, senha e o status do usuario
			LoginService ls = new LoginService(userDao, gymDao,session);
			login = daoLogin.findByEmail(login.getEmail());
			Object r = ls.completeLogin(daoLogin, login, errors);
			if(r != null){
				if(login.getType().equals(TypeLogin.GYM)){
					Gym g = (Gym) r;
					result = 200;
					location = "gym/index";
					
				}else if(login.getType().equals(TypeLogin.USER)){
					User u = (User) r;
					result = 200;
					location = "user/index";
				}				
			}
			
		}
		response.put("errors", errors);
		response.put("location", location);
		response.put("result", result);
		return response;
	}
	@RequestMapping(value="logout")
	public String logout(HttpSession session){
		new LoginService(userDao, gymDao, session).logout();
		return "redirect:/";
	}
	@RequestMapping(value="/list")
	public String list(){
		
		return DIR+"maps";
	}
}
