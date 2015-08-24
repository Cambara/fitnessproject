package br.com.fitnessproject.controller.gym;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fitnessproject.model.entity.Gym;

@Controller
@RequestMapping(value="gym")
public class ControllerGym {
	private static String dir = "gym/";
	@RequestMapping(value={"index","","/"})
	public String index(){
		return dir+"index";
	}
	@RequestMapping(value="info")
	public @ResponseBody  Map<String,Object> info(HttpSession session){
		int result = 500;
		Gym gym = (Gym) session.getAttribute("gym");
		Map<String,Object> response = new HashMap<String, Object>();
		if(gym != null){
			Map<String,Object> gymMap = new HashMap<String,Object>();
			gymMap.put("id", gym.getId());
			gymMap.put("lat", gym.getLocation().getlat());
			gymMap.put("lng", gym.getLocation().getlng());
			gymMap.put("email", gym.getLogin().getEmail());
			gymMap.put("name", gym.getName());
			gymMap.put("phone", gym.getPhone());
			response.put("gym", gymMap);
			result = 200;
		}
		response.put("result", result);
		return response;
	}
	
}
