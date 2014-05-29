package br.com.fitnessproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fitnessproject.model.db.dao.user.UserDao;
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
}
