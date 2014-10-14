package br.com.fitnessproject.controller.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerGuest {
	private static String dir = "guest/";
	@RequestMapping(value="/index")
	public String index() {
		return dir+"index";
	}
	@RequestMapping(value="/signup")
	public String signup(){
		return dir+"signup";
	}
	@RequestMapping(value="/login")
	public String login(){
		return dir+"login";
	}
}
