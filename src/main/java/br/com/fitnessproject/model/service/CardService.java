package br.com.fitnessproject.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fitnessproject.model.db.dao.card.CardDao;
import br.com.fitnessproject.model.db.dao.user.UserDao;
import br.com.fitnessproject.model.entity.Card;
import br.com.fitnessproject.model.entity.User;

public class CardService {
	
	private CardDao dao;
	private HttpSession session;
	private UserDao userDao;

	public List<Map> getJsonCards(){
		User u = (User) session.getAttribute("user");
		List<Map> cards = new ArrayList<Map>();
		List<Card> cardList =  dao.list(u.getId());
		for (Card c : cardList ) {
			Map<String,Object> card = new HashMap<String, Object>();
			card.put("id", c.getId() );
			card.put("name", c.getName() );
			card.put("date_begin", c.getDateBegin() );
			card.put("date_end", c.getDateEnd());
			cards.add(card);
		}
		return cards;
	}
	public Map<String,Object> deleteCard(Long id){
		
		boolean result =  dao.remove(id); 
		Map<String,Object> response = new HashMap<String, Object>();
		response.put("result", result);
		response.put("id", id);
		return response;
	}
	public Map<String,Object> putCard(Card card){
		Map<String,Object> response = new HashMap<String, Object>();
		User u = (User) session.getAttribute("user");
		card.setUser(u);
		Long id = card.getId(); 
		
		if(id != null ){
			card = dao.update(card);
			response.put("type", "update");
		}else{
			card = dao.add(card);
			response.put("type", "add");
		}
		Map<String,Object> c = new HashMap<String, Object>();
		c.put("id", card.getId() );
		c.put("name", card.getName() );
		c.put("date_begin", card.getDateBegin() );
		c.put("date_end", card.getDateEnd());
		
		response.put("result", card.getId() > 0);
		response.put("card", c);
		return response;
	}

	public CardDao getDao() {
		return dao;
	}
	public void setDao(CardDao dao) {
		this.dao = dao;
	}
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
		
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	
}
