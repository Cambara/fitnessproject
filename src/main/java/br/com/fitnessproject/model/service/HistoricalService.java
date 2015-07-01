package br.com.fitnessproject.model.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import br.com.fitnessproject.model.db.dao.body.BodyDao;
import br.com.fitnessproject.model.db.dao.historical.HistoricalTrainingDao;
import br.com.fitnessproject.model.entity.Body;
import br.com.fitnessproject.model.entity.HistoricalTraining;
import br.com.fitnessproject.model.entity.TrainerCard;
import br.com.fitnessproject.model.entity.User;

public class HistoricalService {
	
	
	public void addTraining(HistoricalTrainingDao dao, TrainerCard trainerCard, Timestamp date){
		HistoricalTraining historicalTraining = new HistoricalTraining();
		historicalTraining.setTrainerCard(trainerCard);
		historicalTraining.setDate(date);
		dao.add(historicalTraining);
	}
	public List<Map> getTraining(HistoricalTrainingDao dao,HttpSession session){
		User user = (User) session.getAttribute("user");
		List<HistoricalTraining> historicalTrainingList = dao.findByUserId(user.getId());
		List<Map> list = new ArrayList<Map>();
		for (HistoricalTraining historicalTraining : historicalTrainingList) {
			list.add(transformTrainingMap(historicalTraining));
		}
		return list;
	}
	public Map<String,Object> transformTrainingMap(HistoricalTraining historicalTraining){
		Map<String,Object> historicalTrainingMap = new HashMap<String, Object>();
		historicalTrainingMap.put("id", historicalTraining.getId());
		historicalTrainingMap.put("date", historicalTraining.getDate());
		historicalTrainingMap.put("name", historicalTraining.getTrainerCard().getName());
		historicalTrainingMap.put("desc", historicalTraining.getTrainerCard().getDesc());
		return historicalTrainingMap;
	}
	public List<Map> getMeasures(Long id, BodyDao bodyDao){
		List<Body> bodys = bodyDao.listByUserId(id);
		List<Map> listBodyMap = new ArrayList<Map>();
		BodyService bs = new BodyService();
		for(Body b : bodys){
			Map<String,Object> map = bs.createBodyMap(b);
			listBodyMap.add(map);
		}
		return listBodyMap;
	}
	
}
