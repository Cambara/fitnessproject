package br.com.fitnessproject.model.service;

import java.util.HashMap;
import java.util.Map;

import br.com.fitnessproject.model.db.dao.body.BodyDao;
import br.com.fitnessproject.model.entity.Body;

public class BodyService {
	
	
	public Map<String,Object> addBody(Body body, BodyDao bodyDao){
		body = bodyDao.add(body);
		return createBodyMap(body);
	}
	public Map<String,Object> getMeasures(Long id, BodyDao bodyDao){
		Body body = bodyDao.getByUserId(id);
		return createBodyMap(body);
	}
	public Map<String,Object> createBodyMap(Body body){
		Map<String,Object> userMap = new HashMap<String, Object>();
		userMap.put("id", body.getUser().getId());
		Map<String,Object> bodyMap = new HashMap<String, Object>();
		bodyMap.put("id", body.getId());
		bodyMap.put("back", body.getBack());
		bodyMap.put("hip", body.getHip());
		bodyMap.put("biceps_l", body.getBicepsL());
		bodyMap.put("biceps_r", body.getBicepsR());
		bodyMap.put("forearm_l", body.getForearmL());
		bodyMap.put("forearm_r", body.getForearmR());
		bodyMap.put("bust", body.getBust());
		bodyMap.put("heigth", body.getHeigth());
		bodyMap.put("leg_l", body.getLegL());
		bodyMap.put("leg_r", body.getLegR());
		bodyMap.put("calf_l", body.getCalfL());
		bodyMap.put("calf_r", body.getCalfR());
		bodyMap.put("waist", body.getWaist());
		bodyMap.put("weigth", body.getWeigth());
		bodyMap.put("date", body.getDate());
		bodyMap.put("user", userMap);
		return bodyMap;
	}
}
