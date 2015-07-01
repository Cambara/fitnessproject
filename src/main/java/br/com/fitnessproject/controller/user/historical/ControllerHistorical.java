package br.com.fitnessproject.controller.user.historical;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fitnessproject.model.db.dao.body.BodyDao;
import br.com.fitnessproject.model.db.dao.historical.HistoricalTrainingDao;
import br.com.fitnessproject.model.entity.User;
import br.com.fitnessproject.model.service.HistoricalService;

@Controller
@RequestMapping(value="user/historical")
public class ControllerHistorical {
	private static String DIR = "user/historical/";
	@Autowired
	HistoricalTrainingDao historicalTrainingDao;
	@Autowired
	BodyDao bodyDao;
	
	
	@RequestMapping(value="/training")
	public String training(){
		return DIR+"training";
	}
	@RequestMapping(value="/training/list")
	public @ResponseBody Map<String,Object> trainingList(HttpSession session) {
		List<Map> list = new HistoricalService().getTraining(historicalTrainingDao, session);
		Map<String,Object> response= new HashMap<String, Object>();
		response.put("result", 200);
		response.put("list", list);
		return response;
	}
	@RequestMapping(value="/measures")
	public String measures(){
		return DIR+"measures";
	}
	@RequestMapping(value="/measures/list")
	public @ResponseBody Map<String,Object> TrainingList(HttpSession session) {
		User u = (User)session.getAttribute("user");
		List<Map> list = new HistoricalService().getMeasures(u.getId(), bodyDao);
		Map<String,Object> response= new HashMap<String, Object>();
		response.put("result", 200);
		response.put("list", list);
		return response;
	}

}
