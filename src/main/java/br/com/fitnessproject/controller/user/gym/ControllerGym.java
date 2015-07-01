package br.com.fitnessproject.controller.user.gym;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fitnessproject.model.db.dao.gym.GymDao;
import br.com.fitnessproject.model.service.GymService;

@Controller
@RequestMapping(value="/user/gym")
public class ControllerGym {
	private static String DIR = "/user/gym/";
	@Autowired
	private GymDao gymDao;
	@RequestMapping(value={"/index","/",""})
	public String index(){
		return DIR + "index";
	}
	@RequestMapping(value="location")
	public String locationGym(){
		return DIR+"location";
	}
	@RequestMapping(value="maps")
	public String maps(){
		return DIR+"maps";
	}
	@RequestMapping(value="get_all_gyms")
	public @ResponseBody List<Map> getAllGyms(){
		return new GymService().getAllGym(gymDao);
	}
	@RequestMapping(value="nearby_gyms")
	public String nearbyGyms(){
		return DIR +"nearbyGyms";
	}
}
