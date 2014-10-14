package br.com.fitnessproject.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="user")
public class ControllerUser {
	private static String dir = "user/";
	@RequestMapping(value="/index")
	public String index() {
		return dir + "index";
	}
	
}
