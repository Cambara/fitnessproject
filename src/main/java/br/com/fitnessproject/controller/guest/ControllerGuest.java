package br.com.fitnessproject.controller.guest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.xml.ws.BindingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fitnessproject.model.db.dao.gym.GymDao;
import br.com.fitnessproject.model.db.dao.login.LoginDao;
import br.com.fitnessproject.model.db.dao.user.UserDao;
import br.com.fitnessproject.model.entity.Login;
import br.com.fitnessproject.model.enums.StatusLogin;
import br.com.fitnessproject.model.enums.TypeLogin;
import br.com.fitnessproject.model.service.SignupService;
import br.com.fitnessproject.model.service.validate.ValidateEmail;
import br.com.fitnessproject.model.service.validate.ValidateSignup;

@Controller
public class ControllerGuest {
	private static String dir = "guest/";
	private static String loginDir = "user/";
	@Autowired
	LoginDao daoLogin;
	@Autowired
	UserDao userDao;
	@Autowired
	GymDao gymDao;
	@RequestMapping(value="/index")
	public String index() {
		return dir+"index";
	}
	@RequestMapping(value="/signup")
	public String signup(){
		return dir+"signup";
	}
	@RequestMapping(value="doSignup")
	public @ResponseBody Map<String,Object> doSignup(@RequestBody Map<String,String> request){
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
			if(new SignupService(userDao,gymDao).completeSignup(daoLogin, l, request.get("name"))){
				
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
		
		return dir+"login";
	}
	
	@RequestMapping(value="/doLogin")
	public String doLogin(@ModelAttribute @Valid Login login){
		String response = dir+"login"; 
		Map<String, String> errors = new HashMap<String, String>();
		new ValidateEmail(daoLogin, true).validate(login, errors); 
		if(errors.isEmpty()){
			//validar o email, senha e o status do usuario
		}
		return response;
	}
	
	@RequestMapping(value="/list")
	public String list(){
		
		return dir+"maps";
	}
}
