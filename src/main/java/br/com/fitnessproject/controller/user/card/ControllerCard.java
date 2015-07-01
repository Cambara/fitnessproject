package br.com.fitnessproject.controller.user.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fitnessproject.model.db.dao.card.CardDao;
import br.com.fitnessproject.model.db.dao.user.UserDao;
import br.com.fitnessproject.model.entity.Card;
import br.com.fitnessproject.model.entity.Login;
import br.com.fitnessproject.model.entity.User;
import br.com.fitnessproject.model.service.CardService;

@Controller
@RequestMapping(value="user/card")
public class ControllerCard {
	@Autowired
	CardDao dao;
	@Autowired
	UserDao userDao;
	private static String DIR = "user/card/";
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String cards() {
		return DIR+"list";
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public @ResponseBody  Map<String,Object> list(HttpSession session){
		int result = 500;
		User u = (User) session.getAttribute("user");
		Map<String,Object> response = new HashMap<String, Object>();
		if(u != null){
			CardService cardService =  new CardService();
			cardService.setDao(dao);
			cardService.setSession(session);
			List<Map> cards = cardService.getJsonCards();
			response.put("list", cards);
			result = 200;
		}
		response.put("result", result);
		return response;
	}
	@RequestMapping(value="delete", method= RequestMethod.POST)
	public @ResponseBody Map<String,Object> delete(@RequestBody Long id,HttpSession session){
		CardService cardService =  new CardService();
		cardService.setDao(dao);
		cardService.setSession(session);
		return cardService.deleteCard(id);
	}
	@RequestMapping(value="put", method= RequestMethod.POST)
	public @ResponseBody Map<String,Object> put(@RequestBody Card card, HttpSession session){
		CardService cardService =  new CardService();
		cardService.setDao(dao);
		cardService.setUserDao(userDao);
		cardService.setSession(session);
		return cardService.putCard(card);
	}

}
