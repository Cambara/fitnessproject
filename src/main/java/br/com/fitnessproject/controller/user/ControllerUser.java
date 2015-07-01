package br.com.fitnessproject.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fitnessproject.model.entity.User;

@Controller
@RequestMapping(value="user")
public class ControllerUser {
	private static String dir = "user/";
	@RequestMapping(value={"/index","","/"})
	public String index() {
		return dir + "index";
	}
	@RequestMapping(value="info")
	public @ResponseBody  Map<String,Object> info(HttpSession session){
		int result = 500;
		User u = (User) session.getAttribute("user");
		Map<String,Object> response = new HashMap<String, Object>();
		if(u != null){
			Map<String,Object> info = new HashMap<String, Object>();
			info.put("name", u.getName());
			info.put("email", u.getLogin().getEmail());
			info.put("status", u.getLogin().getStatus().getDesc());
			try {
				info.put("birthday", u.getBirthday());
				info.put("gender", u.getGender().getDescription());
			} catch (Exception e) {}
			response.put("info", info);
			result = 200;
		}
		response.put("result", result);
		return response;
	}
	
}
