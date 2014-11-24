package br.com.fitnessproject.model.db.dao.login;

import java.util.List;

import br.com.fitnessproject.model.entity.Login;

public interface LoginDao {
	
	public Login add(Login login);
	public Login update(Login login);
	public boolean remove(Long id);
	public Login findById(Long id);
	public Login findByEmail(String email);
	public List<Login> list();

}
