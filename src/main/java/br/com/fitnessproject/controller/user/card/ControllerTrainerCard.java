package br.com.fitnessproject.controller.user.card;

import java.util.Date;
import java.sql.Timestamp;
import java.util.Calendar;
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
import br.com.fitnessproject.model.db.dao.card.trainer.TrainerCardDao;
import br.com.fitnessproject.model.db.dao.historical.HistoricalTrainingDao;
import br.com.fitnessproject.model.db.dao.user.UserDao;
import br.com.fitnessproject.model.entity.TrainerCard;
import br.com.fitnessproject.model.entity.User;
import br.com.fitnessproject.model.service.CardService;
import br.com.fitnessproject.model.service.HistoricalService;
import br.com.fitnessproject.model.service.TrainerCardService;

@Controller
@RequestMapping(value="user/card/trainer")
public class ControllerTrainerCard {
	private static String DIR = "user/card/trainer/";
	@Autowired
	TrainerCardDao dao;
	@Autowired
	CardDao cardDao;
	@Autowired
	UserDao userDao;
	@Autowired
	HistoricalTrainingDao historicalTrainingDao;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String card() {
		return DIR+"list";
	}
	@RequestMapping(value="list", method = RequestMethod.GET )
	public @ResponseBody  Map<String,Object> list(Long id, HttpSession session){
		int result = 500;
		User u = (User) session.getAttribute("user");
		Map<String,Object> response = new HashMap<String, Object>();
		if(u != null){
			TrainerCardService trainerCardService =  new TrainerCardService();
			trainerCardService.setDao(dao);
			trainerCardService.setSession(session);
			List<Map> trainers = trainerCardService.getJsonTrainers(id);
			response.put("list", trainers);
			result = 200;
		}
		response.put("result", result);
		return response;
	}
	@RequestMapping(value="delete", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> delete(@RequestBody Long id){
		TrainerCardService cardService = new TrainerCardService();
		cardService.setDao(dao);
		return cardService.deleteCard(id);
	}
	@RequestMapping(value="put", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> put(@RequestBody Map<String,Object> request) {
		TrainerCardService cardService = new TrainerCardService();
		cardService.setDao(dao);
		TrainerCard trainerCard = cardService.createTrainerCard(request);
		return cardService.putCard(trainerCard);
	}
	@RequestMapping(value="finishedTrainer", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> finishedTrainer(@RequestBody Map<String,Object> request) {
		TrainerCardService cardService = new TrainerCardService();
		cardService.setDao(dao);
		TrainerCard trainerCard = cardService.createTrainerCard(request);
		//get the current date
		Date date = new Date();
		Timestamp now = new Timestamp(date.getTime());
		trainerCard.setLastTrainer(now);
		new HistoricalService().addTraining(historicalTrainingDao, trainerCard, now);
		return cardService.putCard(trainerCard);
	}
	@RequestMapping(value="next_trainer")
	public @ResponseBody Map<String, Object> getNextTrainer(HttpSession session){
		TrainerCardService cardService = new TrainerCardService();
		cardService.setDao(dao);
		cardService.setSession(session);
//		Map<String,Object> response = new HashMap<String, Object>();
//		response.put("result", true);
//		response.put("type", "params");
//		response.put("params",cardService.getNextTrainer());
		return cardService.getNextTrainer();
		
	}
}
