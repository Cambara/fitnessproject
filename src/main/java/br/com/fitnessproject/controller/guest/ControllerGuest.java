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
	public String doSignup(@ModelAttribute @Valid Login login, BindingResult result, 
			@RequestParam String name, @RequestParam String confirmPassword,ModelMap model){
		String response = dir+"signup";
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("login", login);
		map.put("name", name);
		map.put("confirmPassword", confirmPassword);
		new ValidateSignup(daoLogin).validate(map, result); 
		if(!result.hasErrors()){			
			if(new SignupService(userDao,gymDao).completeSignup(daoLogin, login, name)){
				response = loginDir+"/index";
			}
		}else{
			model.addAttribute("login", login);
			model.addAttribute("name", name);
		}
		
		return response;
	}
	@RequestMapping(value="/login")
	public String login(){
		
		return dir+"login";
	}
	
	@RequestMapping(value="/doLogin")
	public String doLogin(@ModelAttribute @Valid Login login, BindingResult result){
		String response = dir+"login"; 
		new ValidateEmail(daoLogin, true).validate(login, result); 
		if(!result.hasErrors()){
			//validar o email, senha e o status do usuario
		}
		return response;
	}
	
	@RequestMapping(value="/list")
	public String list(){
		
		return dir+"maps";
	}
}
