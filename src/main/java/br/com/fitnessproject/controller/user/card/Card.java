package br.com.fitnessproject.controller.user.card;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="user/card")
public class Card {
	private static String DIR = "user/card/";
	
	@RequestMapping(value="list")
	public String list(){
		return DIR +"list";
	}
}
