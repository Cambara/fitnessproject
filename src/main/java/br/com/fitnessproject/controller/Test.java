package br.com.fitnessproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fitnessproject.model.db.dao.user.UserDao;
import br.com.fitnessproject.model.entity.Login;
import br.com.fitnessproject.model.entity.User;

@Controller
@RequestMapping(value = "/test")
public class Test {
	@Autowired
	UserDao dao;
	
	
	@RequestMapping(value = "/index")
	public String index()
	{
		return "index";
	}
	@RequestMapping(value = "/add")
	public String add()
	{
		return "add";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(User user)
	{	
		System.out.println("nome" + user.getName());
		dao.add(user);
		return "index";
	}
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(){
		dao.list();
		return "index";
	}
	@RequestMapping(value="signup")
	public String signup(){
		return "test/signup";
	}
	@RequestMapping(value = "doSignup", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> doSignup() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", "cambara");
		map.put("passwords", "tiago");
		map.put("host",System.getenv("OPENSHIFT_MYSQL_DB_HOST"));
		map.put("port",System.getenv("OPENSHIFT_MYSQL_DB_PORT"));
		map.put("user",System.getenv("OPENSHIFT_MYSQL_DB_USERNAME"));
		map.put("password",System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD"));
		map.put("url",System.getenv("OPENSHIFT_MYSQL_DB_URL"));
		return map;
	} 
}
