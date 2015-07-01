package br.com.fitnessproject.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fitnessproject.model.db.dao.gym.GymDao;
import br.com.fitnessproject.model.entity.Gym;

public class GymService {
	
	public List<Map> getAllGym(GymDao gymDao){
		return createListGymMap(gymDao.list());
	}
	
	private List<Map> createListGymMap(List<Gym> gyms){
		List<Map> gymMaps = new ArrayList<Map>();
		for(Gym g : gyms){
			gymMaps.add(createGymMap(g));
		}		
		return gymMaps;
	}
	private Map<String, Object> createGymMap(Gym g){
		Map<String,Object> gymMap = new HashMap<String, Object>();
		gymMap.put("id", g.getId());
		gymMap.put("name", g.getName());
		gymMap.put("phone", g.getPhone());
		Map<String,Object> locationMap = new HashMap<String, Object>();
		locationMap.put("id", g.getLocation().getId());
		locationMap.put("lat", g.getLocation().getlat());
		locationMap.put("lng", g.getLocation().getlng());
		gymMap.put("location", locationMap);
		gymMap.put("email", g.getLogin().getEmail());
		
		return gymMap;
	}
}
