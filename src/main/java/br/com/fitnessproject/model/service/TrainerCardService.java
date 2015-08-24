package br.com.fitnessproject.model.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;

import br.com.fitnessproject.model.db.dao.card.CardDao;
import br.com.fitnessproject.model.db.dao.card.trainer.TrainerCardDao;
import br.com.fitnessproject.model.db.dao.user.UserDao;
import br.com.fitnessproject.model.entity.Card;
import br.com.fitnessproject.model.entity.Exercise;
import br.com.fitnessproject.model.entity.TrainerCard;
import br.com.fitnessproject.model.entity.User;

public class TrainerCardService {
	private TrainerCardDao dao;
	private CardDao cardDao;
	private UserDao userDao;
	private HttpSession session;
	
	@Transactional()
	public List<Map> getJsonTrainers(Long id){
		User u = (User) session.getAttribute("user");
		List<Map> trainerCards = new ArrayList<Map>();
		List<TrainerCard> trainers = dao.list(id);
		for(TrainerCard t : trainers){
			Map<String,Object> trainer = new HashMap<String, Object>();
			trainer.put("id", t.getId());
			trainer.put("name", t.getName());
			trainer.put("desc", t.getDesc());
			trainer.put("last_trainer", t.getLastTrainer());
			trainer.put("rest_begin", t.getRestBegin());
			trainer.put("rest_end", t.getRestEnd());
			Map<String,Object> card = new HashMap<String, Object>();
			card.put("id", t.getCard().getId());
			trainer.put("card", card);
			
			List<Exercise> exercises = t.getExercises();
			List<Map> exerciseList = new ArrayList<Map>();
			for(Exercise exercise : exercises){
				Map<String,Object> e = new HashMap<String, Object>();
				e.put("id", exercise.getId());
				e.put("name", exercise.getName());
				e.put("nRepeat", exercise.getnRepeat());
				e.put("weight", exercise.getWeight());
				e.put("serie", exercise.getSerie());
				Map<String,Object> trainerCard = new HashMap<String, Object>();
				trainerCard.put("id", t.getId());
				e.put("trainerCard", trainerCard);
				exerciseList.add(e);
			}
			trainer.put("exercises", exerciseList);
			trainerCards.add(trainer);
		}

		
		return trainerCards;
	}
	public Map<String,Object> deleteCard(Long id){
		boolean result =  dao.remove(id); 
		Map<String,Object> response = new HashMap<String, Object>();
		response.put("result", result);
		response.put("id", id);
		return response;
	}
	public Map<String,Object> putCard(TrainerCard trainerCard){
		Map<String,Object> response = new HashMap<String, Object>();		
		Long id = trainerCard.getId(); 
		
		if(id != null ){
			trainerCard = dao.update(trainerCard);
			response.put("type", "update");
		}else{
			trainerCard = dao.add(trainerCard);
			response.put("type", "add");
		}
		
		Map<String,Object> trainer = new HashMap<String, Object>();
		trainer.put("id", trainerCard.getId());
		trainer.put("name", trainerCard.getName());
		trainer.put("desc", trainerCard.getDesc());
		trainer.put("last_trainer", trainerCard.getLastTrainer());
		trainer.put("id_card", trainerCard.getCard().getId());
		trainer.put("rest_begin", trainerCard.getRestBegin());
		trainer.put("rest_end", trainerCard.getRestEnd());
		Map<String,Object> card = new HashMap<String, Object>();
		card.put("id", trainerCard.getCard().getId());
		trainer.put("card",card);
		List<Exercise> exercises = trainerCard.getExercises();
		List<Map> exerciseList = new ArrayList<Map>();
		for(Exercise exercise : exercises){
			Map<String,Object> e = new HashMap<String, Object>();
			e.put("id", exercise.getId());
			e.put("name", exercise.getName());
			e.put("nRepeat", exercise.getnRepeat());
			e.put("weight", exercise.getWeight());
			e.put("serie", exercise.getSerie());
			Map<String,Object> trainerCardMap = new HashMap<String, Object>();
			trainerCardMap.put("id", trainerCard.getId());
			e.put("trainerCard", trainerCardMap);
			exerciseList.add(e);
		}
		trainer.put("exercises", exerciseList);
		
		
		response.put("result", trainerCard.getId() > 0);
		response.put("card", trainer);
		return response;
	}
	public TrainerCard createTrainerCard(Map<String,Object> trainerCardMap){
		Map<String,Object> cardMap = (Map<String,Object>) trainerCardMap.get("card");
		TrainerCard trainerCard = new TrainerCard();
		Object idObject = cardMap.get("id");
		Long idCard =  Long.parseLong(idObject.toString());
		Card card = new Card();
		card.setId(idCard);
		String desc = (String) trainerCardMap.get("desc");
		String idStr = trainerCardMap.get("id").toString();
		String restBegin = (String) trainerCardMap.get("restBegin");
		String restEnd = (String) trainerCardMap.get("restEnd");
		Timestamp lastTrainer = null;
		if(trainerCardMap.get("lastTrainer") != null){
			Long lDate = (Long)trainerCardMap.get("lastTrainer");
			lastTrainer = new Timestamp(lDate);
			
		}
		String name = (String) trainerCardMap.get("name");
		if(!idStr.isEmpty()){
			Long id = Long.parseLong(idStr); 			
			trainerCard.setId(id);
		}
		trainerCard.setCard(card);
		trainerCard.setDesc(desc);		
		trainerCard.setLastTrainer(lastTrainer);
		trainerCard.setName(name);
		trainerCard.setRestBegin(restBegin);
		trainerCard.setRestEnd(restEnd);
		List<Exercise> exercises = createExerciseList(trainerCardMap.get("exercises"), trainerCard);
		trainerCard.setExercises(exercises);
		return trainerCard;
	}
	private List<Exercise> createExerciseList(Object obj,TrainerCard trainerCard){
		List<Exercise> exercises = new ArrayList<Exercise>();
		List<Map> exerciseMaps = (List<Map>) obj;
		for(Map<String,Object> e : exerciseMaps){
			Map<String, Object> trainerCardMap = (Map<String, Object>) e.get("trainerCard");
			Exercise exercise = new Exercise();
			exercise.setName(e.get("name").toString());
			exercise.setnRepeat(e.get("nRepeat").toString());
			exercise.setWeight(e.get("weight").toString());
			exercise.setSerie(Integer.parseInt(e.get("serie").toString()) );
			String idStr = e.get("id").toString();
			if(!idStr.isEmpty()){
				exercise.setId(Long.parseLong(idStr));				
			}
			exercise.setTrainerCard(trainerCard);
			exercises.add(exercise);
		}
		
		return exercises;
	}
	
	public Map<String,Object> getNextTrainer(){
		User u = (User) session.getAttribute("user");
		TrainerCard trainerCard =  dao.getNextTrainer(u.getId());
		return createTrainerCardMap(trainerCard);
	}
	
	public Map<String,Object> createTrainerCardMap(TrainerCard trainerCard){
		Map<String,Object> trainerCardMap = new HashMap<String, Object>();
		trainerCardMap.put("id",trainerCard.getId());
		trainerCardMap.put("last_trainer", trainerCard.getLastTrainer());
		trainerCardMap.put("name", trainerCard.getName());
		trainerCardMap.put("desc", trainerCard.getDesc());
		trainerCardMap.put("rest_begin", trainerCard.getRestBegin());
		trainerCardMap.put("rest_end", trainerCard.getRestEnd());
		trainerCardMap.put("exercises",createExercisesMap(trainerCard.getExercises()) );
		Map<String,Object> cardMap = new HashMap<String, Object>();
		Long idCard = null;
		if(trainerCard.getCard() != null){
			idCard = trainerCard.getCard().getId();
		}
		cardMap.put("id", idCard);
		trainerCardMap.put("card", cardMap);
		return trainerCardMap;
	}
	public List<Map> createExercisesMap(List<Exercise> exercises){
		List<Map> exercisesMap = new ArrayList<Map>();
		for(Exercise e : exercises){
			Map<String,Object> eMap= new HashMap<String, Object>();
			eMap.put("id", e.getId());
			eMap.put("name", e.getName());
			eMap.put("nRepeat", e.getnRepeat());
			eMap.put("serie", e.getSerie());
			eMap.put("weight", e.getWeight());
			exercisesMap.add(eMap);
		}
		return exercisesMap;
	}
	public TrainerCardDao getDao() {
		return dao;
	}
	public void setDao(TrainerCardDao dao) {
		this.dao = dao;
	}
	public CardDao getCardDao() {
		return cardDao;
	}
	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
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
