package br.com.fitnessproject.controller.user.measures;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fitnessproject.model.db.dao.body.BodyDao;
import br.com.fitnessproject.model.entity.Body;
import br.com.fitnessproject.model.entity.User;
import br.com.fitnessproject.model.service.BodyService;
@Controller
@RequestMapping(value="user/measures")
public class ControllerMeasures {
	private static String dir = "user/measures/";
	
	@Autowired
	BodyDao bodyDao;
	@RequestMapping(value={"/index","","/"})
	public String measures(){
		return dir+"index";
	}
	
	@RequestMapping(value="put" , method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> put(@RequestBody Body body,HttpSession session){
		User u = (User)session.getAttribute("user");
		body.setUser(u); 
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		body.setDate(date);
		Map<String,Object> bodyMap = new BodyService().addBody(body, bodyDao);
		Map<String,Object> response = new HashMap<String, Object>();
		response.put("params", bodyMap);
		response.put("type","params");
		response.put("result", true);
		return response;
		
		
	}
	@RequestMapping(value="get_measures")
	public @ResponseBody Map<String,Object> getMeasures(HttpSession session){
		User u = (User) session.getAttribute("user");		
		return new BodyService().getMeasures(u.getId(), bodyDao);
	}
}
