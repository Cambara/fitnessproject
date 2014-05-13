package br.com.fitnessproject.model.db.dao.login;

import java.util.List;

import br.com.fitnessproject.model.entity.Login;

public interface LoginDao {
	
	public boolean add(Login login);
	public boolean update(Login login);
	public boolean remove(Long id);
	public Login findById(Long id);
	public List<Login> list();

}
