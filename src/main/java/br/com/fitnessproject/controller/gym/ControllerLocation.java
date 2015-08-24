package br.com.fitnessproject.controller.gym;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value="gym/location")
public class ControllerLocation {
	
	private static String dir = "gym/location/";
	
	@RequestMapping(value={"index","/",""})
	public String index(){
		return dir+"index";
	}
	
}
